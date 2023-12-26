package org.example.controllers.rest;

import jakarta.validation.Valid;
import org.example.services.dtos.input.ModelDTO;
import org.example.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/car-models")
public class ModelController {

    private  ModelService modelService;
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ResponseEntity<ModelDTO> createCarModel(@RequestBody @Valid ModelDTO modelDTO) {
        ModelDTO createdCarModel = modelService.createCarModel(modelDTO);
        return new ResponseEntity<>(createdCarModel, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> getCarModelById(@PathVariable String id) {
        ModelDTO modelDTO = modelService.getCarModelById(id);
        return ResponseEntity.ok(modelDTO);
    }

    @GetMapping
    public ResponseEntity<List<ModelDTO>> getAllCarModels() {
        List<ModelDTO> carModels = modelService.getAllCarModels();
        return ResponseEntity.ok(carModels);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarModel(@PathVariable String id) {
        modelService.deleteCarModel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
