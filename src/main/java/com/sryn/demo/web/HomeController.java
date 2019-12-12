package com.sryn.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sryn.demo.domain.User;

@Controller
public class HomeController {
	
	/** 
	this controller handles all the requests that go to root url& Root Url method(=home)
	which is supposed to render the index template indexed at html.
	And so when it renders this information it also sends along with it a model.
	model.addAttribute("formData", new User()); <- this is essentially just a map. A key-vlaue pair map. 
	with an empty User object
	 * **/
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	

//	@RequestMapping(value="/create", method = RequestMethod.POST)
//	public String processFormData(User user) {	
//		return "result";
//	}

	//Insert data submitted in the form to the database.
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attr) {	
		//RedirectAttributes <- this was introduced in spring 4.
		//This is a much better way to redirect the data attributes
		
		attr.addFlashAttribute("user", user);
		return "redirect:/display";
	}
	
	
	@RequestMapping(value="/display", method = RequestMethod.GET)
	public String displayFormData(User user) {		
		return "result";
	}
	
}
