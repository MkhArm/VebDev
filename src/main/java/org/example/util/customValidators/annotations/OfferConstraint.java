package org.example.util.customValidators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.util.customValidators.OfferValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OfferValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OfferConstraint {
    String message() default "Invalid offer";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
