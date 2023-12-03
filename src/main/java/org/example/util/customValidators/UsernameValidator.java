package org.example.util.customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.repositories.UserRepository;
import org.example.util.customValidators.annotations.UsernameConstraint;

public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {

    private final UserRepository userRepository;

    public UsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cxt) {
        return username != null && username.length() >= 3 && username.length() <= 30 && isUsernameUnique(username);
    }

    private boolean isUsernameUnique(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }
}
