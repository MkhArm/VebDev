package org.example.config;

import org.example.models.entities.Model;
import org.example.models.entities.Offer;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.ModelOutputDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.services.dtos.output.OfferFullDetailsDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Validator validator1(){
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        return validatorFactoryBean;
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Model, ModelOutputDTO> typeMapModelOutput = modelMapper.createTypeMap(Model.class, ModelOutputDTO.class);
        typeMapModelOutput.addMappings(m->m.map(src -> src.getBrand().getName(), ModelOutputDTO::setBrand_name));
        TypeMap<Offer, OfferDetailsDTO> typeOfferDetailsDTO = modelMapper.createTypeMap(Offer.class, OfferDetailsDTO.class);
        typeOfferDetailsDTO.addMappings(m->m.map(src -> src.getModel().getBrand().getName(), OfferDetailsDTO::setBrandName));
        TypeMap<Offer, OfferFullDetailsDTO> typeOfferFullDetailsDTO = modelMapper.createTypeMap(Offer.class, OfferFullDetailsDTO.class);
        typeOfferFullDetailsDTO.addMappings(m->m.map(src -> src.getModel().getBrand().getName(), OfferFullDetailsDTO::setBrandName));
        typeOfferFullDetailsDTO.addMappings(m->m.map(src -> src.getSeller().getId(), OfferFullDetailsDTO::setSeller_id));
        typeOfferFullDetailsDTO.addMappings(m->m.map(src -> src.getSeller().getUsername(), OfferFullDetailsDTO::setSeller_username));
        TypeMap<Offer, OfferDTO> typeOfferDTO = modelMapper.createTypeMap(Offer.class, OfferDTO.class);
        typeOfferDTO.addMappings(m->m.map(src -> src.getModel().getId(), OfferDTO::setModel_id));
        typeOfferDTO.addMappings(m->m.map(src -> src.getSeller().getId(), OfferDTO::setSeller_id));

        return modelMapper;
    }

}
