package org.example.controllers.rest;

import jakarta.validation.Valid;
import org.example.services.dtos.input.BrandDTO;
import org.example.services.BrandService;
import org.example.services.dtos.input.BrandRequest;
import org.example.services.dtos.output.BrandModelCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/car-brands")
public class BrandController {

    private BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<BrandDTO> createCarBrand(@RequestBody @Valid BrandRequest brandRequest) {
        // Используем новый класс CarBrandRequest для передачи параметров
        BrandDTO brandDTO = brandService.createCarBrand(brandRequest.getName());
        return new ResponseEntity<>(brandDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getCarBrandById(@PathVariable String id) {
        BrandDTO brandDTO = brandService.getCarBrandById(id);
        return ResponseEntity.ok(brandDTO);
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllCarBrands() {
        List<BrandDTO> carBrands = brandService.getAllCarBrands();
        return ResponseEntity.ok(carBrands);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarBrand(@PathVariable String id) {
        brandService.deleteCarBrand(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/model-counts")
    public ResponseEntity<List<BrandModelCountDTO>> getBrandModelCounts() {
        List<BrandModelCountDTO> brandModelCounts = brandService.getBrandModelCounts();
        return ResponseEntity.ok(brandModelCounts);
    }
}
