package org.example.repositories;

import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.models.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

    @Query("SELECT new org.example.services.dtos.output.OfferDetailsDTO(o.price, o.year, o.model.brand.name, o.model.name, o.imageUrl, o.engine, o.transmission, o.mileage) FROM Offer o WHERE o.model.brand.name = :brandName")
    List<OfferDetailsDTO> findOfferDetailsByBrandName(String brandName);

    @Query("SELECT new org.example.services.dtos.output.OfferDetailsDTO(o.price, o.year, o.model.brand.name, o.model.name, o.imageUrl, o.engine, o.transmission, o.mileage) FROM Offer o WHERE o.year >= :startYear")
    List<OfferDetailsDTO> findOfferDetailsByStartYear(int startYear);

    void deleteByModel_Id(String modelId);

    void deleteByModel_Brand_Id(String brandId);

}
