package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.models.entities.Model;
import org.example.models.entities.Offer;
import org.example.models.entities.OfferView;
import org.example.models.entities.User;
import org.example.repositories.ModelRepository;
import org.example.repositories.OfferRepository;
import org.example.repositories.OfferViewRepository;
import org.example.repositories.UserRepository;
import org.example.services.OfferService;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.services.dtos.output.OfferFullDetailsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class OfferServiceImpl implements OfferService {
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final OfferViewRepository offerViewRepository;

    @Autowired
    public OfferServiceImpl(ModelRepository modelRepository, UserRepository userRepository, OfferRepository offerRepository, ModelMapper modelMapper, OfferViewRepository offerViewRepository) {
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.offerViewRepository = offerViewRepository;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public OfferDTO createOffer(OfferDTO offerDTO) {

        Model model = modelRepository.findById(offerDTO.getModel_id())
                .orElseThrow(() -> new EntityNotFoundException("CarModel not found: " + offerDTO.getModel_id()));

        User seller = userRepository.findById(offerDTO.getSeller_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + offerDTO.getSeller_id()));

        Offer offer = modelMapper.map(offerDTO, Offer.class);
        offer.setModel(model);
        offer.setSeller(seller);

        Offer savedOffer = offerRepository.save(offer);
        OfferView offerView = new OfferView(savedOffer, 0);
        offerViewRepository.save(offerView);
        return modelMapper.map(savedOffer, OfferDTO.class);
    }


    @Override
    public OfferDTO getOfferById(String id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Offer not found with id: " + id));
        return modelMapper.map(offer, OfferDTO.class);
    }

    @Override
    @Cacheable("offers")
    public List<OfferDTO> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void deleteOffer(String id) {
        offerViewRepository.deleteByOfferId(id);
        offerRepository.deleteById(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void deleteOfferByModelId(String id) {
        offerViewRepository.deleteByOfferModelId(id);
        offerRepository.deleteByModel_Id(id);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public void deleteOfferByModelBrandId(String id) {
        offerViewRepository.deleteByOfferModelBrandId(id);
        offerRepository.deleteByModel_Brand_Id(id);
    }

    @Override
    @Cacheable("offers")
    public List<OfferDetailsDTO> getOfferDetails() {
        return offerRepository.findAll().stream().map(e -> modelMapper.map(e, OfferDetailsDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Cacheable("offers")
    public OfferDetailsDTO getOfferDetailsById(String id) {
        return modelMapper.map(offerRepository.findById(id), OfferDetailsDTO.class);
    }

    @Override
    public OfferFullDetailsDTO getOfferFullDetailsById(String id) {
        return modelMapper.map(offerRepository.findById(id), OfferFullDetailsDTO.class);
    }

//    @Override
//    public List<OfferDTO> getOfferByBrandName(String brandName) {
//        List<Offer> offers = offerRepository.findByModel_Brand_Name(brandName);
//        List<OfferDTO> offerDTOs = offers.stream()
//                .map(offer -> modelMapper.map(offer, OfferDTO.class))
//                .collect(Collectors.toList());
//        return offerDTOs;
//    }
//
//    @Override
//    public List<OfferDTO> getOfferByModelStartYearGreaterThane(int startYear) {
//        List<Offer> offers = offerRepository.findByModel_StartYearGreaterThan(startYear);
//        List<OfferDTO> offerDTOs = offers.stream()
//                .map(offer -> modelMapper.map(offer, OfferDTO.class))
//                .collect(Collectors.toList());
//        return offerDTOs;
//    }
    @Cacheable("offers")
    public List<OfferDetailsDTO> getOfferDetailsByBrandName(String brandName) {
        List<OfferDetailsDTO> offerDetails = offerRepository.findOfferDetailsByBrandName(brandName);
        return offerDetails;
    }

    @Cacheable("offers")
    public List<OfferDetailsDTO> getOfferDetailsByStartYear(int startYear) {
        List<OfferDetailsDTO> offerDetails = offerRepository.findOfferDetailsByStartYear(startYear);
        return offerDetails;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "offers", allEntries = true)
    public OfferDTO editOffer(String id, OfferDTO offerDTO) {
        Offer existingOffer = offerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Offer not found with id: " + id));

        Model model = modelRepository.findById(offerDTO.getModel_id())
                .orElseThrow(() -> new EntityNotFoundException("CarModel not found: " + offerDTO.getModel_id()));

        User seller = userRepository.findById(offerDTO.getSeller_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + offerDTO.getSeller_id()));

        // Обновление полей сущности Offer
        existingOffer.setModel(model);
        existingOffer.setSeller(seller);
        existingOffer.setDescription(offerDTO.getDescription());
        existingOffer.setEngine(offerDTO.getEngine());
        existingOffer.setImageUrl(offerDTO.getImageUrl());
        existingOffer.setMileage(offerDTO.getMileage());
        existingOffer.setPrice(offerDTO.getPrice());
        existingOffer.setTransmission(offerDTO.getTransmission());
        existingOffer.setYear(offerDTO.getYear());

        // Сохранение обновленной сущности
        Offer updatedOffer = offerRepository.save(existingOffer);

        // Возвращение обновленной сущности в виде DTO
        return modelMapper.map(updatedOffer, OfferDTO.class);
    }

}

