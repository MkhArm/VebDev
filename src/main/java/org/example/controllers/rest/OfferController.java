package org.example.controllers.rest;

import jakarta.validation.Valid;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.OfferService;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private OfferService offerService;
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<OfferDTO> createOffer(@RequestBody @Valid OfferDTO offerDTO) {
        OfferDTO createdOffer = offerService.createOffer(offerDTO);
        return new ResponseEntity<>(createdOffer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable String id) {
        OfferDTO offerDTO = offerService.getOfferById(id);
        return ResponseEntity.ok(offerDTO);
    }

    @GetMapping
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        List<OfferDTO> offers = offerService.getAllOffers();
        return ResponseEntity.ok(offers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String id) {
        offerService.deleteOffer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/details")
    public ResponseEntity<List<OfferDetailsDTO>> getOfferDetails() {
        List<OfferDetailsDTO> offerDetails = offerService.getOfferDetails();
        return ResponseEntity.ok(offerDetails);
    }

    @GetMapping("/details/brand")
    public ResponseEntity<List<OfferDetailsDTO>> getOfferDetailsByBrandName(@RequestParam String brandName) {
        List<OfferDetailsDTO> offerDetails = offerService.getOfferDetailsByBrandName(brandName);
        return ResponseEntity.ok(offerDetails);
    }

    @GetMapping("/details/start-year")
    public ResponseEntity<List<OfferDetailsDTO>> getOfferDetailsByStartYear(@RequestParam int startYear) {
        List<OfferDetailsDTO> offerDetails = offerService.getOfferDetailsByStartYear(startYear);
        return ResponseEntity.ok(offerDetails);
    }

}
