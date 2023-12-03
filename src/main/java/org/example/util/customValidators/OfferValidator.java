package org.example.util.customValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.services.dtos.input.OfferDTO;
import org.example.util.customValidators.annotations.OfferConstraint;

public class OfferValidator implements ConstraintValidator<OfferConstraint, OfferDTO> {

    @Override
    public void initialize(OfferConstraint offer) {
    }

    @Override
    public boolean isValid(OfferDTO offerDTO, ConstraintValidatorContext cxt) {
        if (offerDTO == null) {
            return false;
        }

        return offerDTO.getDescription() != null && !offerDTO.getDescription().isEmpty() &&
                offerDTO.getEngine() != null &&
                offerDTO.getImageUrl() != null && !offerDTO.getImageUrl().isEmpty() &&
                offerDTO.getMileage() != null &&
                offerDTO.getPrice() != null &&
                offerDTO.getTransmission() != null &&
                offerDTO.getYear() != null &&
                offerDTO.getModel_id() != null &&
                offerDTO.getSeller_id() != null;
    }
}

