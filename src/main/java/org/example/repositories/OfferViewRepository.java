package org.example.repositories;

import org.example.models.entities.OfferView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferViewRepository extends JpaRepository<OfferView, String> {

    OfferView findByOfferId(String offerId);
}

