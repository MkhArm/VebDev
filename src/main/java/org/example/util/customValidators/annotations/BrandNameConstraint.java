package org.example.util.customValidators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.util.customValidators.BrandNameValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BrandNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BrandNameConstraint {
    String message() default "Invalid brand name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

