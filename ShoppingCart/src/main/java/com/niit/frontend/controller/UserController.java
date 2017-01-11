package com.niit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.UserDAO;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/isValidUser")
	public ModelAndView isValidUser(@RequestParam(value="name")String name,@RequestParam(value="password")String password)
	{
		System.out.println("in controller");
		String message;
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

}
