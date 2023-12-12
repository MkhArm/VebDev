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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Controller
@RequestMapping("/")
public class AuthController {
    private static final Logger LOG = LogManager.getLogger(Controller.class);
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
        System.out.println(userRegistrationDto.toString());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", userRegistrationDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDto", bindingResult);

            return "redirect:/sign/up";
        }

        this.authService.register(userRegistrationDto);

        String logMessage = String.format("A user %s has registered.", userRegistrationDto.getUsername());
        LOG.log(Level.INFO, logMessage);

        return "redirect:/sign/in";
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
