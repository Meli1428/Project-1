package com.niit.frontend.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Supplier;



@Controller

public class SupplierController {

	@Autowired
	Supplier supplier;

	@Autowired
	SupplierDAO supplierDAO;

	@ModelAttribute
	public Supplier returnObject2() {
		return new Supplier();

	}

	@RequestMapping("/admin/AddSupplier")
	public ModelAndView ShowAddSupplier(Model model) {
		ModelAndView mv = new ModelAndView("admin/AddSupplier");

		model.addAttribute("supplierList", supplierDAO.list());
		System.out.println("added supplier details  in controller");

		return mv;
	}

	/* action of addsupplier */
	@RequestMapping(value = "/addsupp", method = RequestMethod.POST)
	public String addSupp(@Valid @ModelAttribute("supplier") Supplier su,
	Model model, BindingResult result,
	HttpServletRequest request) throws IOException {
		if (su.getSup_id()==0) {
			// new supplier, add it

			supplierDAO.saveOrUpdate(su);
			System.out.println("adding of new supplier in controller");
		} 
		return "redirect:admin/AddSupplier";

	}

	/* delete supplier... */
	@RequestMapping(value = "/deletesupplier{id}")
	public ModelAndView showDeleteSupplier(@PathVariable("id") String id, Model model) throws Exception {

		int i = Integer.parseInt(id);

		supplier = supplierDAO.get(i);

		System.out.println("supplier deleteeeee");

		ModelAndView mv = new ModelAndView("AddSupplier");

		supplierDAO.delete(i);
		mv.addObject("addsupplier", 0);

		System.out.println("delete Id:" + id);

		return mv;

	}

	/*
	 * /////////////////////////
	 */

	@RequestMapping(value = "/editsupplier{id}")
	public ModelAndView UpdatesuppPage(@PathVariable("id") String id, Model model) throws Exception {
		int i = Integer.parseInt(id);

		model.addAttribute("supplier", supplierDAO.get(i));
		model.addAttribute("SupplierList", supplierDAO.list());
		System.out.println("edit supplier in controller");
		ModelAndView mv = new ModelAndView("AddSupplier");
		return mv;

	}
}
	

