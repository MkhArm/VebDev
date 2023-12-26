package org.example.services.security;

import org.example.models.entities.User;
import org.example.models.entities.UserRole;
import org.example.models.enums.UserRoleType;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRoleRepository;
import org.example.services.exceptions.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.services.dtos.input.UserRegistrationDto;
import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void register(UserRegistrationDto registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords.match");
        }

        Optional<User> byUserName = this.userRepository.findByUsername(registrationDTO.getUsername());

        if (byUserName.isPresent()) {
            throw new RuntimeException("userName.used");
        }

        UserRole userRole = userRoleRepository.
                findByRole(UserRoleType.USER).orElseThrow();

        User user = new User(
                registrationDTO.getUsername(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getFirstName(),
                registrationDTO.getLastName(),
                true,
                "",
                userRole
        );

        this.userRepository.save(user);
    }

    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }
        return user.get();
    }
}
