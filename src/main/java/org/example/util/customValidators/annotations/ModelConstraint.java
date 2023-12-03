package org.example.util.customValidators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.util.customValidators.ModelValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ModelValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelConstraint {
    String message() default "Invalid car model";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

