package org.example.repositories;

import org.example.services.dtos.output.BrandModelCountDTO;
import org.example.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    @Query("SELECT NEW org.example.services.dtos.output.BrandModelCountDTO(b.name, COUNT(m)) " +
            "FROM Brand b LEFT JOIN b.models m GROUP BY b.id, b.name")
    List<BrandModelCountDTO> getBrandModelCounts();

    Optional findByName(String name);
}
