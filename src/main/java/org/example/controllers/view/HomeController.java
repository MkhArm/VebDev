package org.example.controllers.view;

import org.example.services.OfferService;
import org.example.services.OfferViewCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.services.dtos.output.OfferDetailsDTO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@Controller
@EnableCaching
public class HomeController {

    private OfferService offerService;
    private OfferViewCounterService offerViewCounterService;

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @Autowired
    public void setOfferViewCounterService(OfferViewCounterService offerViewCounterService) {
        this.offerViewCounterService = offerViewCounterService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Получение списка предложений
        List<OfferDetailsDTO> offers = offerService.getOfferDetails();

        // Сортировка списка предложений по количеству просмотров
        Collections.sort(offers, Comparator.comparingLong(offer ->
                offerViewCounterService.getViews(offer.getId())));
        Collections.reverse(offers);

        model.addAttribute("offers", offers);

        // Вывод в консоль информации о просмотрах
//        List<OfferViewCounterService.OfferViewCountPair> offerViewCounts = offerViewCounterService.getAllOfferViews();
//        System.out.println();
//        for (OfferViewCounterService.OfferViewCountPair pair : offerViewCounts) {
//            System.out.println("Offer ID: " + pair.getOfferId() + ", Views: " + pair.getViewCount());
//        }

        return "home";
    }
}
