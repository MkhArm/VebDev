package org.example.controllers.view;

import org.example.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.services.dtos.output.OfferDetailsDTO;
import java.util.List;

@Controller
public class HomeController {

    private OfferService offerService;

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<OfferDetailsDTO> offers = offerService.getOfferDetails();
        model.addAttribute("offers", offers);
        return "home";
    }
}
