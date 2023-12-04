package org.example.util.customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.input.UserDTO;
import org.example.util.customValidators.annotations.UserConstraint;

public class UserValidator implements ConstraintValidator<UserConstraint, UserDTO> {

    @Override
    public void initialize(UserConstraint offer) {
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext cxt) {
        if (userDTO == null) {
            return false;
        }

        return userDTO.getUsername() != null && !userDTO.getPassword().isEmpty() &&
                userDTO.getFirstName() != null &&
                userDTO.getImageUrl() != null && !userDTO.getImageUrl().isEmpty() &&
                userDTO.getLastName() != null;
    }
}

