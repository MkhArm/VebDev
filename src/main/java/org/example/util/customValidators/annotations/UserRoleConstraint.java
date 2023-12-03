package org.example.util.customValidators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.util.customValidators.UserRoleValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserRoleValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserRoleConstraint {
    String message() default "Invalid user role";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

