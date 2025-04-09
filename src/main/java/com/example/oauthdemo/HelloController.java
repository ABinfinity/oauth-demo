package com.example.oauthdemo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {

//    @GetMapping("/")
//    public String greet(){
//        return "<html><body>Welcome. You have been authenticated. Click on the link to see your details \uD83D\uDC49 <a href='http://localhost:8080/user'>User Details</a></body></html>";
//    }

    @GetMapping("/user")
    public String user(Model model, @AuthenticationPrincipal OAuth2User principal) {
//        return principal.getAttributes();
        model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("email", principal.getAttribute("email"));
        model.addAttribute("picture", principal.getAttribute("picture")); // Google
        model.addAttribute("avatar_url", principal.getAttribute("avatar_url")); // GitHub

        String source;
        if (principal.getAttribute("sub") != null) {
            source = "Google";
        } else if (principal.getAttribute("id") != null) {
            source = "GitHub";
        } else {
            source = "Unknown";
        }

        model.addAttribute("source", source);
        return "user";
    }
}
