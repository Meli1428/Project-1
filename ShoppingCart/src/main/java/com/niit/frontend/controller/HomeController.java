package com.niit.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//this class we have to convert into a controller (MVC)
//we have to use simple annotation

@Controller

public class HomeController {

	@RequestMapping("/") // this is the root which will navigate to the home page
	public String showHome()
	{
		return "HomePage";
	}
	
	@RequestMapping("/login") 
	public ModelAndView showLogin()
	{
		ModelAndView mv=new ModelAndView("HomePage");
		mv.addObject("msg", "You clicked Login link");
		mv.addObject("showLogin", "true");
		
		//in login.jsp we should use "msg" variable with expression variable
		return mv;
	}
	
	@RequestMapping("/registration") 
	public ModelAndView showRegistration()
	{
		ModelAndView mv=new ModelAndView("HomePage");
		mv.addObject("msg", "You clicked on Registration link");
		mv.addObject("showRegistration", "true");

		return mv;
	}
	
	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("id") String id, @RequestParam("password") String pwd)
	{
		System.out.println("In validate method");
		System.out.println("id: "+id);
		System.out.println("password: "+pwd);

		ModelAndView mv=new ModelAndView("HomePage");
		
		//need to validate ie actually we need to write the DAO to get value from tables
		
		//if the credentials are valid then we should show welcome to shopping cart
		//if not correct then message invalid message+login page->both displays in the home page
		
		return mv;
	}
	

}
