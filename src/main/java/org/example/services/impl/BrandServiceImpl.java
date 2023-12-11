package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.example.services.dtos.output.BrandModelCountDTO;
import org.example.services.dtos.input.BrandDTO;
import org.example.models.entities.Brand;
import org.example.repositories.BrandRepository;
import org.example.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.example.util.ValidationUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@Service
@EnableCaching
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "brands", allEntries = true)
    public BrandDTO createCarBrand(String carBrandName) {

        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(carBrandName);

        if (!this.validationUtil.isValid(brandDTO)) {
            this.validationUtil
                    .violations(brandDTO)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

        } else {
            try {
                brandDTO.setId(this.brandRepository
                        .saveAndFlush(this.modelMapper.map(brandDTO, Brand.class)).getId());
            } catch (Exception e) {
                System.out.println("Some thing went wrong!");
            }
        }

        return brandDTO;
    }

    @Override
    @Cacheable("brands")
    public BrandDTO getCarBrandById(String id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Car brand not found: " + id));
        return modelMapper.map(brand, BrandDTO.class);
    }

    @Override
    @Cacheable("brands")
    public List<BrandDTO> getAllCarBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> modelMapper.map(brand, BrandDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"brands", "models", "offers"}, allEntries = true)
    public void deleteCarBrand(String id) {
        brandRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<BrandModelCountDTO> getBrandModelCounts() {
        List<BrandModelCountDTO> brandModelCounts = brandRepository.getBrandModelCounts();
        return brandModelCounts;
    }

    @Autowired
    public void setCarBrandRepository(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

}


