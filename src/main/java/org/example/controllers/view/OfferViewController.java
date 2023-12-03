package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.UserService;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferViewController {
    private OfferService offerService;
    private BrandService brandService;
    private ModelService modelService;
    private UserService userService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public String showSearchOfferPage(Model model) {
        return "offers-search";
    }

    @GetMapping("/add-offer")
    public String showAddOfferPage(Model model){
        model.addAttribute("models",modelService.findAll());
        model.addAttribute("users",userService.findAll());
        System.out.println("ПОКАЗЫВАЮ");
        return "offer-add";
    }

    @GetMapping("/offer/{id}")
    public String offerDetails(@PathVariable("id") String id, Model model){
        OfferDetailsDTO offer = offerService.getOfferDetailsById(id);
        model.addAttribute("offer",offer);
        return "offer-details";
    }

    @ModelAttribute("offerDto")
    public OfferDTO initCompany() {
        return new OfferDTO();
    }

    @PostMapping("/add-offer")
    public String addOffer(@Valid OfferDTO offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            System.out.println(offerDto);
            System.out.println("ПОКАЗЫВАЮ2");
            return "redirect:/add-offer";
        }
        System.out.println("СОХРАНЯЯЯЯЯЯЮЮЮЮ");
        offerService.createOffer(offerDto);
        return "redirect:/home";
    }

}
