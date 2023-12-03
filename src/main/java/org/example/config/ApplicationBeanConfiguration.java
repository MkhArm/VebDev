package org.example.config;

import org.example.models.entities.Model;
import org.example.services.dtos.output.ModelOutputDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.validation.Validation;
import jakarta.validation.Validator;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Validator validator(){
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Model, ModelOutputDTO> typeMapModelOutput = modelMapper.createTypeMap(Model.class, ModelOutputDTO.class);
        typeMapModelOutput.addMappings(m->m.map(src -> src.getBrand().getName(), ModelOutputDTO::setBrand_name));

        return modelMapper;
    }

}
