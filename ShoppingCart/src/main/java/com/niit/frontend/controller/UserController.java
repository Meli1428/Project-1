package com.niit.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.model.User;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/isValidUser")
	public ModelAndView isValidUser(@RequestParam(value="name")String name,@RequestParam(value="password")String password)
	{
		System.out.println("in controller");
		@SuppressWarnings("unused")
		String message="";
		ModelAndView mv;
		if(userDAO.isValid(name, password))
		{
			message="valid credentials";
			mv=new ModelAndView("adminHome");
		}
		else
		{
			message="invalid credentials";
			mv=new ModelAndView("login");
		}
		return mv;
	}
	
	@RequestMapping("/registration")
	public ModelAndView ShowRegister(@ModelAttribute("user")User user,BindingResult result,HttpServletRequest request)
	{
		System.out.println("registered");
		ModelAndView mv=new ModelAndView("registration"); 
		return mv;
	}
	
	@ModelAttribute
	public User returnObject()
	{
		return new User(); 
	}
	 //After clicking submit this page with data is opened and is sent to addus page
	@RequestMapping(value= "/addus",method=RequestMethod.POST) 
	public String addUser(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest request)
{
	System.out.println(user.getConfirmpassword());
	System.out.println(user.getPassword());
	user.setEnabled("true");
	user.setRole("ROLE_USER");
	if(user.getConfirmpassword().equals(user.getPassword()))
	{
		userDAO.saveOrUpdate(user);
	}
	
	return "login";
}

}
