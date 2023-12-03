package org.example.util.customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.services.dtos.input.UserRoleDTO;
import org.example.util.customValidators.annotations.UserRoleConstraint;

public class UserRoleValidator implements ConstraintValidator<UserRoleConstraint, UserRoleDTO> {

    @Override
    public void initialize(UserRoleConstraint userRole) {
    }

    @Override
    public boolean isValid(UserRoleDTO userRoleDTO, ConstraintValidatorContext cxt) {
        return userRoleDTO != null && userRoleDTO.getRole() != null;
    }
}

