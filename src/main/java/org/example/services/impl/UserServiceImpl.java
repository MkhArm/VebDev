package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.models.entities.Model;
import org.example.models.entities.Offer;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.input.UserDTO;
import org.example.models.entities.User;
import org.example.models.entities.UserRole;
import org.example.models.enums.UserRoleType;
import org.example.repositories.UserRoleRepository;
import org.example.repositories.UserRepository;
import org.example.services.dtos.output.UserOutputDTO;
import org.example.services.internal.InternalRoleService;
import org.example.services.internal.InternalUserService;
import org.example.services.UserService;
import org.example.services.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class UserServiceImpl implements UserService, InternalUserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final InternalRoleService internalRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, ModelMapper modelMapper, InternalRoleService internalRoleService, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.internalRoleService = internalRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "users", allEntries = true)
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        UserRole userRole = userRoleRepository.findByRole(userDTO.getRole())
                .orElseThrow(() -> new EntityNotFoundException("User role not found: " + userDTO.getRole()));
        user.setRole(userRole);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    @Cacheable("users")
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDTO.getId()));

        existingUser.setUsername(userDTO.getUsername());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setActive(userDTO.getActive());
        existingUser.setImageUrl(userDTO.getImageUrl());
        existingUser.setRole(internalRoleService.findByRole(userDTO.getRole()));

        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"users", "offers"}, allEntries = true)
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Cacheable("users")
    public List<UserDTO> findUsersByRole(UserRoleType roleType) {
        List<User> users = userRepository.findByRole_Role(roleType);
        List<UserDTO> userDTOs = users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    @Cacheable("users")
    public UserDTO getUserByUsername(String username) {
        Optional user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @Cacheable("users")
    public User getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return user;
    }

    @Override
    @Cacheable("users")
    public UserDTO getUserDTOById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @Cacheable("users")
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(e -> modelMapper.map(e, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("users")
    public List<UserOutputDTO> getUserOutputDTO() {
        return userRepository.findAll().stream().map(e -> modelMapper.map(e, UserOutputDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("users")
    public UserOutputDTO getUserOutputDTOById(String id) {
        return modelMapper.map(userRepository.findById(id), UserOutputDTO.class);
    }

    @Override
    @CacheEvict(cacheNames = "users", allEntries = true)
    public UserDTO editUser(String id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        UserRole userRole = userRoleRepository.findByRole(userDTO.getRole())
                .orElseThrow(() -> new EntityNotFoundException("CarModel not found: " + userDTO.getRole()));
        existingUser.setRole(userRole);
        existingUser.setActive(userDTO.getActive());
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setImageUrl(userDTO.getImageUrl());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setPassword(userDTO.getPassword());

        User updatedUser = userRepository.save(existingUser);

        return modelMapper.map(updatedUser, UserDTO.class);
    }

}

