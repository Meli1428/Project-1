package com.niit.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.model.User;


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
		System.out.println("Logged in");
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("msg", "You clicked Login link");
		mv.addObject("showLogin", "true");
		
		//in login.jsp we should use "msg" variable with expression variable
		return mv;
	}
	
	@RequestMapping("/HomePage") 
	public ModelAndView showHomePage()
	{
		ModelAndView mv=new ModelAndView("HomePage");
		mv.addObject("msg", "You clicked Home link");
		mv.addObject("showHomePage", "true");
		
		//in login.jsp we should use "msg" variable with expression variable
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
	@RequestMapping("/AboutUs")
	public ModelAndView ShowAboutUs(@ModelAttribute("user")User user,BindingResult result,HttpServletRequest request)
	{
		System.out.println("Aboutus");
		ModelAndView mv=new ModelAndView("AboutUs"); 
		return mv;
	}
	
	@RequestMapping("/products")
	public ModelAndView ShowProducts()
	{
		System.out.println("products");
		ModelAndView mv=new ModelAndView("products"); 
		mv.addObject("msg","you clicked products link");
		mv.addObject("ShowProducts","true");
		return mv;
	}
	
	/*@RequestMapping("/productdetail")
	public ModelAndView ShowProductDetail()
	{
		System.out.println("product details ");
		ModelAndView mv=new ModelAndView("productdetail"); 
		mv.addObject("msg","you clicked productdetail link");
		mv.addObject("ShowProductDetail","true");
		return mv;
	}*/
	

}
