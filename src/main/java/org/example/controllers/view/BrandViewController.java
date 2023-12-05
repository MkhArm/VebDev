package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.dtos.input.BrandDTO;
import org.example.services.dtos.input.ModelDTO;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.ModelOutputDTO;
import org.example.services.dtos.output.UserOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class BrandViewController {

    private BrandService brandService;
    private ModelService modelService;
    private OfferService offerService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("brandDto")
    public BrandDTO initCompany() {
        return new BrandDTO();
    }

    @GetMapping("/brands")
    public String home(Model model) {
        List<BrandDTO> brands = brandService.getAllCarBrands();
        model.addAttribute("brands", brands);
        return "brands-all";
    }

//    @GetMapping("/model/{id}")
//    public String modelDetails(@PathVariable("id") String id, Model model){
//        ModelOutputDTO cModel = modelService.getModelOutputDTOById(id);
//        model.addAttribute("model",cModel);
//        return "model-details";
//    }

    @GetMapping("/brand/delete/{id}")
    public String deleteBrand(@PathVariable("id") String id, Model model) {
        offerService.deleteOfferByModelBrandId(id);
        modelService.deleteCarModelByBrandId(id);
        brandService.deleteCarBrand(id);
        return "redirect:/brands";
    }

    @GetMapping("/brand/add")
    public String showAddBrandPage(Model model){
        model.addAttribute("BrandDTO", new BrandDTO());
        return "brand-add";
    }

    @PostMapping("/brand/add")
    public String addBrand(@Valid BrandDTO brandDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandDto", brandDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandDto", bindingResult);
            System.out.println(brandDTO);
            return "redirect:/brand/add";
        }
        brandService.createCarBrand(brandDTO.getName());
        return "redirect:/brands";
    }
}

