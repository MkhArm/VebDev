package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.dtos.input.UserRegistrationDto;
import org.example.services.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto initForm() {
        return new UserRegistrationDto();
    }

    @GetMapping("/sign/up")
    public String register() {
        return "sign-up";
    }

    @PostMapping("/sign/up")
    public String doRegister(@Valid UserRegistrationDto userRegistrationDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        System.out.println("doRegister");
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);

            return "redirect:/sign/up";
        }

        this.authService.register(userRegistrationDto);

        return "redirect:/home";
    }

    @GetMapping("/sign/in")
    public String signIn() {
        return "sign-in";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/sign/in";
    }

//    @GetMapping("/profile")
//    public String profile(Principal principal, Model model) {
//        String username = principal.getName();
//        User user = authService.getUser(username);
//
//        UserProfileView userProfileView = new UserProfileView(
//                username,
//                user.getEmail(),
//                user.getFullName(),
//                user.getAge()
//        );
//
//        model.addAttribute("user", userProfileView);
//
//        return "profile";
//    }
}
