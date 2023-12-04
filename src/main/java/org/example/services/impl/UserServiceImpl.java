package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.services.dtos.input.UserDTO;
import org.example.models.entities.User;
import org.example.models.entities.UserRole;
import org.example.models.enums.UserRoleType;
import org.example.repositories.UserRoleRepository;
import org.example.repositories.UserRepository;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.services.dtos.output.UserOutputDTO;
import org.example.services.internal.InternalRoleService;
import org.example.services.internal.InternalUserService;
import org.example.services.UserService;
import org.example.services.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, InternalUserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final InternalRoleService internalRoleService;

    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, ModelMapper modelMapper, InternalRoleService internalRoleService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.internalRoleService = internalRoleService;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        UserRole userRole = userRoleRepository.findByRole(userDTO.getRole())
                .orElseThrow(() -> new EntityNotFoundException("User role not found: " + userDTO.getRole()));
        user.setRole(userRole);

        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
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
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserDTO> findUsersByRole(UserRoleType roleType) {
        List<User> users = userRepository.findByRole_Role(roleType);
        List<UserDTO> userDTOs = users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        Optional user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        return user;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(e -> modelMapper.map(e, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserOutputDTO> getUserOutputDTO() {
        return userRepository.findAll().stream().map(e -> modelMapper.map(e, UserOutputDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserOutputDTO getUserOutputDTOById(String id) {
        return modelMapper.map(userRepository.findById(id), UserOutputDTO.class);
    }

}

