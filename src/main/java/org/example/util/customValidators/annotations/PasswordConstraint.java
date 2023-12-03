package org.example.util.customValidators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.util.customValidators.PasswordValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {
    String message() default "Invalid password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
