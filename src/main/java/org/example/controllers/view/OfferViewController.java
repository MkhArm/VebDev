package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.UserService;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.input.UserDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.services.dtos.output.OfferFullDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

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

    @ModelAttribute("offerDto")
    public OfferDTO initCompany() {
        return new OfferDTO();
    }

    @GetMapping("/offer/search")
    public String showSearchOfferPage(Model model) {
        return "offers-search";
    }

    @GetMapping("/offer/view/{id}")
    public String offerDetails(@PathVariable("id") String id, Model model, Principal principal){
        OfferFullDetailsDTO offer = offerService.getOfferFullDetailsById(id);
        System.out.println(offer.toString());
        model.addAttribute("offer",offer);
        String currentUserId = principal != null ? userService.getUserByUsername(principal.getName()).getId() : null;
        model.addAttribute("currentUserId",currentUserId);
        return "offer-details";
    }

    @GetMapping("/offer/add")
    public String showAddOfferPage(Model model){
        model.addAttribute("OfferDTO", new OfferDTO());
        model.addAttribute("models",modelService.findAll());
        model.addAttribute("users",userService.findAll());
        return "offer-add";
    }

    @PostMapping("/offer/add")
    public String addOffer(@Valid OfferDTO offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            System.out.println(offerDto);
            return "redirect:/offer/add";
        }
        offerService.createOffer(offerDto);
        return "redirect:/home";
    }

    @GetMapping("/offer/edit/{id}")
    public String showEditOfferPage(@PathVariable("id") String id, Model model) {
        OfferDTO offer = offerService.getOfferById(id);
        model.addAttribute("offer", offer);
        System.out.println(offer.toString());
        model.addAttribute("models",modelService.findAll());
        model.addAttribute("users",userService.findAll());
        return "offer-edit";
    }

    @PostMapping("/offer/edit/{id}")
    public String editOffer(@PathVariable("id") String id, @Valid OfferDTO offerDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            return "redirect:/offer/edit/" + id;
        }

        offerService.editOffer(id, offerDto);
        return "redirect:/home";
    }

    @GetMapping("/offer/delete/{id}")
    public String showDeleteOfferPage(@PathVariable("id") String id, Model model) {
        offerService.deleteOffer(id);
        return "redirect:/home";
    }

}
