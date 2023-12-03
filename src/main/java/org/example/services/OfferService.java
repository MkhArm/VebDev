package org.example.services;

import org.example.models.enums.EngineType;
import org.example.models.enums.TransmissionType;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.input.UserDTO;
import org.example.services.dtos.output.OfferDetailsDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OfferService {
    OfferDTO createOffer(OfferDTO offerDTO);
    OfferDTO getOfferById(String id);
    List<OfferDTO> getAllOffers();
    void deleteOffer(String id);

    List<OfferDetailsDTO> getOfferDetails();

    OfferDetailsDTO getOfferDetailsById(String id);

    List<OfferDetailsDTO> getOfferDetailsByBrandName(String brandName);

    List<OfferDetailsDTO> getOfferDetailsByStartYear(int startYear);

}


