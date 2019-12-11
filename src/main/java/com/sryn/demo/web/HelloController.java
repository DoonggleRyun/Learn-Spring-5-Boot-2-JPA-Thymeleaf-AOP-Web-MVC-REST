package com.sryn.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {

	@RequestMapping("/basic")
	public String sayHello() {
		return "<h1>hello</h1>";
	}
	
	@RequestMapping("/proper")
	public String sayProperHello() {
		return "<h1>hello there, how are you</h1>";
	}

	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\" method = \"POST\">\r\n" + 
		"  First name:<br>\r\n" + 
		"  <input type=\"text\" name=\"firstName\" >\r\n" + 
		"  <br>\r\n" + 
		"  Last name:<br>\r\n" + 
		"  <input type=\"text\" name=\"lastName\" >\r\n" + 
		"  <br><br>\r\n" + 
		"  <input type=\"submit\" value=\"Submit\">\r\n" + 
		"</form> ";
	}
		
	@RequestMapping(value ="/user_greeting", method = RequestMethod.POST)
	public String printUserGreeting(@RequestParam String firstName, @RequestParam String lastName) {
		return "hello there, "+firstName+" "+lastName;
	}
	
	@RequestMapping(value ="/order/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "order ID:" +id;
	}
}
