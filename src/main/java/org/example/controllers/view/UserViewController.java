package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.UserService;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.example.services.dtos.output.UserOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserViewController {

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

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<UserOutputDTO> users = userService.getUserOutputDTO();
        model.addAttribute("users", users);
        System.out.println(users.get(0).toString());
        return "users-all";
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable("id") String id, Model model){
        UserOutputDTO user = userService.getUserOutputDTOById(id);
        System.out.println(user.toString());
        model.addAttribute("user",user);
        return "user-details";
    }

}
