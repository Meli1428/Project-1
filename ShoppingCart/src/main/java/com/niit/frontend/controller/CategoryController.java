package com.niit.frontend.controller;

import javax.servlet.http.HttpServlet;
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

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.model.Category;
@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;
	// Creates empty obj and takes values frm user

	@ModelAttribute
	public Category returnObject1() {
		return new Category();

	}
		@RequestMapping("/AddCategory")
		public ModelAndView ShowAddCategory(Model model) {
			ModelAndView mv = new ModelAndView("AddCategory");

			model.addAttribute("categoryList", categoryDAO.list());
			System.out.println("added category details  in controller");

			return mv;
		}

		
/*		 * action of addcategory
*/		 
		
		
		@RequestMapping(value = "/addcat", method = RequestMethod.POST)
		public String addCate(@ModelAttribute("category") Category cate,Model model,BindingResult result, HttpServletRequest request) {
			

				categoryDAO.saveOrUpdate(cate);
				ModelAndView mv=new ModelAndView("AddCategory");
				model.addAttribute("categoryList",categoryDAO.list());
				System.out.println("adding of new category in controller");
				return "AddCategory";
				
				
	

		}
		

/*		 delete category... 
*/		@RequestMapping(value = "/deletecategory{id}")
		public ModelAndView showDeleteCategory(@PathVariable("id") String id, Model model,BindingResult result,HttpServlet request) throws Exception {

			int i = Integer.parseInt(id);

			category = categoryDAO.get(i);

			System.out.println("category delete");

			ModelAndView mv = new ModelAndView("addCategory");

			//categoryDAO.delete(i);
			mv.addObject("addcategory", 0);

			System.out.println("delete Id:" + id);

			return mv;

		}

		@RequestMapping(value = "/editcategory{id}")
		public ModelAndView updateCatPage(@PathVariable("id") String id, Model model,BindingResult result,HttpServlet request) throws Exception {
			int i = Integer.parseInt(id);

			model.addAttribute("category", categoryDAO.get(i));
			model.addAttribute("CategoryList", categoryDAO.list());
			System.out.println("edit category in controller");
			ModelAndView mv = new ModelAndView("addCategory");
			return mv;

		}


	/*@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;
	// Creates empty obj and takes values frm user

		@ModelAttribute
		public Category returnObject1() {
			return new Category();

		}

		@RequestMapping("/AddCategory")
		public ModelAndView ShowAddCategory(Model model) {
			ModelAndView mv = new ModelAndView("AddCategory");

			model.addAttribute("categoryList", categoryDAO.list());
			System.out.println("added category details  in controller");

			return mv;
		}

		
		 * action of addcategory
		 

		@RequestMapping(value = "/addcat", method = RequestMethod.POST)
		public String addCate(@ModelAttribute("category") Category cate,Model model, BindingResult result,
				HttpServletRequest request) {
			categoryDAO.saveOrUpdate(cate);
			ModelAndView mv = new ModelAndView("AddCategory");

			model.addAttribute("categoryList", categoryDAO.list());
			System.out.println("adding of new category in controller");

			return "AddCategory";

		}

		

		 delete category... 
		@RequestMapping(value ="/category/deletecategory{id}")
		public ModelAndView showDeleteCategory(@PathVariable("id") String id, Model model) throws Exception {
			System.out.println("in delete category");
			int i = Integer.parseInt(id);

			category = categoryDAO.get(i);

			System.out.println("category delete");

			ModelAndView mv = new ModelAndView("addCategory");

			categoryDAO.delete(category);
			mv.addObject("addcategory", 0);

			System.out.println("delete Id:" + id);

			return mv;

		}

		@RequestMapping(value = "/editcategory{id}")
		public ModelAndView updateCatPage(@PathVariable("id") String id, Model model) throws Exception {
			int i = Integer.parseInt(id);

			model.addAttribute("category", categoryDAO.get(i));
			model.addAttribute("CategoryList", categoryDAO.list());
			System.out.println("edit category in controller");
			ModelAndView mv = new ModelAndView("addCategory");
			return mv;

		}
*/



}
