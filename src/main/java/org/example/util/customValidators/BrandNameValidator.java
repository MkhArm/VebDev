package org.example.util.customValidators;

import org.example.repositories.BrandRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.util.customValidators.annotations.BrandNameConstraint;

public class BrandNameValidator implements ConstraintValidator<BrandNameConstraint, String> {

    private final BrandRepository brandRepository;

    public BrandNameValidator(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public boolean isValid(String brandName, ConstraintValidatorContext cxt) {
        return brandName != null && brandName.length() >= 3 && brandName.length() <= 30 && isBrandNameUnique(brandName);
    }

    private boolean isBrandNameUnique(String brandName) {
        return brandRepository.findByName(brandName).isEmpty();
    }
}

