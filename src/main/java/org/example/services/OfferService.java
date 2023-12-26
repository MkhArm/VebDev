package org.example.services;

import jakarta.transaction.Transactional;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.services.dtos.output.OfferFullDetailsDTO;
import java.util.List;

public interface OfferService {
    OfferDTO createOffer(OfferDTO offerDTO);
    OfferDTO getOfferById(String id);
    List<OfferDTO> getAllOffers();
    void deleteOffer(String id);

    @Transactional
    void deleteOfferByModelId(String id);

    @Transactional
    void deleteOfferByModelBrandId(String id);

    List<OfferDetailsDTO> getOfferDetails();

    OfferDetailsDTO getOfferDetailsById(String id);

    OfferFullDetailsDTO getOfferFullDetailsById(String id);

    List<OfferDetailsDTO> getOfferDetailsByBrandName(String brandName);

    List<OfferDetailsDTO> getOfferDetailsByStartYear(int startYear);

    @Transactional
    OfferDTO editOffer(String id, OfferDTO offerDTO);
}


