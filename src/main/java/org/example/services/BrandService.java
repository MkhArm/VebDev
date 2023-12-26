package org.example.services;

import jakarta.transaction.Transactional;
import org.example.services.dtos.output.BrandModelCountDTO;
import org.example.services.dtos.input.BrandDTO;
import java.util.List;

public interface BrandService {
    BrandDTO createCarBrand(String carBrandName);
    BrandDTO getCarBrandById(String id);
    List<BrandDTO> getAllCarBrands();
    void deleteCarBrand(String id);

    @Transactional
    List<BrandModelCountDTO> getBrandModelCounts();

}


