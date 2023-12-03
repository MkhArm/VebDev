package org.example.util.customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.services.dtos.input.ModelDTO;
import org.example.util.customValidators.annotations.ModelConstraint;

public class ModelValidator implements ConstraintValidator<ModelConstraint, ModelDTO> {

    @Override
    public void initialize(ModelConstraint carModel) {
    }

    @Override
    public boolean isValid(ModelDTO carModelDTO, ConstraintValidatorContext cxt) {
        if (carModelDTO == null) {
            return false;
        }

        return carModelDTO.getName() != null && carModelDTO.getName().length() >= 3 && carModelDTO.getName().length() <= 50 &&
                carModelDTO.getImageUrl() != null && !carModelDTO.getImageUrl().isEmpty() &&
                carModelDTO.getStartYear() != null && carModelDTO.getEndYear() != null && carModelDTO.getEndYear() > carModelDTO.getStartYear() &&
                carModelDTO.getBrand_id() != null;
    }
}
