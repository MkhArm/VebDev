package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.dtos.input.ModelDTO;
import org.example.services.dtos.output.ModelOutputDTO;
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
public class ModelViewController {

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

    @ModelAttribute("modelDto")
    public ModelDTO initCompany() {
        return new ModelDTO();
    }


    @GetMapping("/models")
    public String home(Model model) {
        List<ModelOutputDTO> models = modelService.findAll();
        model.addAttribute("models", models);
        return "models-all";
    }

//    @GetMapping("/model/{id}")
//    public String modelDetails(@PathVariable("id") String id, Model model){
//        ModelOutputDTO cModel = modelService.getModelOutputDTOById(id);
//        model.addAttribute("model",cModel);
//        return "model-details";
//    }

    @GetMapping("/model/delete/{id}")
    public String deleteModel(@PathVariable("id") String id, Model model) {
        offerService.deleteOfferByModelId(id);
        modelService.deleteCarModel(id);
        return "redirect:/models";
    }

    @GetMapping("/model/add")
    public String showAddModelPage(Model model){
        model.addAttribute("ModelDTO", new ModelDTO());
        model.addAttribute("brands", brandService.getAllCarBrands());
        return "model-add";
    }

    @PostMapping("/model/add")
    public String addModel(@Valid ModelDTO modelDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelDto", modelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelDto", bindingResult);
            System.out.println(modelDto);
            return "redirect:/model/add";
        }
        modelService.createCarModel(modelDto);
        return "redirect:/models";
    }
}

