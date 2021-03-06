package com.holinvan.web.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holinvan.web.model.User;

@Controller
public class MainController {

	  @RequestMapping("/login")
	  public String login() {
	    return "user/login";
	  }
	  
	  @RequestMapping("/registration-error")
	  public String registrationError() {
	    return "user/registration-error";
	  }
	  
	  @RequestMapping("/registration-success")
	  public String registrationSuccess() {
	    return "user/registration-success";
	  }
	  
	  @RequestMapping("/activation-success")
	  public String activationSuccess() {
	    return "user/activation-success";
	  }

	  @RequestMapping("/activation-error")
	  public String activationError() {
	    return "user/activation-error";
	  }
	  
	  @RequestMapping("/login-error")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "user/login";
	  }
	  
	  @RequestMapping("/403")
	  public String accessDenied(Model model) {
	    return "403";
	  }
	  
	  @RequestMapping("/")
	  public String hello(Model model) {
	      return "hello";
	  }
	  
	  @Secured("ROLE_ADMIN")
	  @RequestMapping("/admin")
	  public String helloAdmin(@AuthenticationPrincipal User activeUser, Model model) {
		  model.addAttribute("name", activeUser.getUsername());
	      return "hello";
	  }
	  
	  @Secured("ROLE_USER")
	  @RequestMapping("/user")
	  public String helloUser(@AuthenticationPrincipal User activeUser, Model model) {
		  model.addAttribute("name", activeUser.getUsername());
	      return "hello";
	  }
	  
	  @Secured({"ROLE_USER", "ROLE_ADMIN"})
	  @RequestMapping("/userAdmin")
	  public String helloUserAdmin(@AuthenticationPrincipal User activeUser, Model model) {
		  model.addAttribute("name", activeUser.getUsername());
	      return "hello";
	  }

}
