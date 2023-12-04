package org.example.util.customValidators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.util.customValidators.UserValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserConstraint {
    String message() default "Invalid user";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}