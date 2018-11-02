package ar.com.proyectoPecos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// Login form
	  @RequestMapping("/logen.html")
	  public String login() {
	    return "login";
	  }

	  // Login form with error
	  @RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login.html";
	  }

}
