package org.example.controllers.view;

import org.example.services.ModelService;
import org.example.services.dtos.output.ModelOutputDTO;
import org.example.services.dtos.output.UserOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
public class ModelViewCiontroller {

    private ModelService modelService;
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
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


}

