package ar.com.proyectoPecos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	
	@RequestMapping("/home")
    public String home() {
		
        return "home";
    }
	
	@RequestMapping("/")
    public String main() {
		
        return "home";
    }
	
	@RequestMapping("/user")
    public String userIndex() {
        return "user/index";
    }

	@RequestMapping("/login")
    public String login() {
        return "login";
    }

	@RequestMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
	
}
