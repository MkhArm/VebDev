package org.example.services;

import org.example.services.dtos.input.ModelDTO;
import org.example.services.dtos.output.ModelOutputDTO;

import java.util.List;
import java.util.UUID;

public interface ModelService {
    ModelDTO createCarModel(ModelDTO modelDTO);
    ModelDTO getCarModelById(String id);
    List<ModelDTO> getAllCarModels();
    void deleteCarModel(String id);

    List<ModelOutputDTO> findAll();

    ModelOutputDTO getModelOutputDTOById(String id);
}


