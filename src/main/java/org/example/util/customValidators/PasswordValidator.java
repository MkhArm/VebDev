package org.example.util.customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.util.customValidators.annotations.PasswordConstraint;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

    @Override
    public void initialize(PasswordConstraint password) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext cxt) {
        return password != null && password.length() >= 6;
    }
}
