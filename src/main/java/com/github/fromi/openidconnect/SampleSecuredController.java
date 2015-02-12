package com.github.fromi.openidconnect;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class SampleSecuredController extends WebMvcConfigurerAdapter {

	
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");

    }
    
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
    
	@RequestMapping("/test")
    public ModelAndView test(Principal principal) {
		 Object auth = ((Authentication) principal)
		.getPrincipal();
        return new ModelAndView("test");
    }
    
//    @RequestMapping("/googleconnect")
//    public String googleconnect() {
//        return "redirect:/test";
//
//    }
}
