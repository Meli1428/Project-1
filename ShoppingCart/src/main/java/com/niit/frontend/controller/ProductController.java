package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Category;
import com.niit.shoppingbackend.model.Product;
import com.niit.shoppingbackend.model.Supplier;
@Controller
public class ProductController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Product product;
	@Autowired
	Category category;
	
	@RequestMapping("/AddProduct" )
	public ModelAndView addp(Model model)
	{
		System.out.println("in add prod page");
		ModelAndView mv = new ModelAndView("AddProduct");
		model.addAttribute("productList",productDAO.list());
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("supplierList",supplierDAO.list());
		return mv;
	}
	@ModelAttribute
	public Product returnObject()
	{
		return new Product();
	}
	
		
		@RequestMapping(value="/addprod", method = RequestMethod.POST)
	public String Productregister(@Valid @ModelAttribute("product") Product prod,Model model, BindingResult result,
						HttpServletRequest request) throws IOException {
					//ModelAndView mv = new ModelAndView("bootstrap");
			
					@SuppressWarnings("unused")
					String filename;
					@SuppressWarnings("unused")
					byte[] bytes;
					System.out.println(prod.getProd_name());
			
				System.out.println("image uploaded");
			
					System.out.println("myproduct controller called");
					MultipartFile image = prod.getImg();
					Path path;
					path = Paths.get(
							"D:/new project/ShoppingCart/src/main/webapp/resources/images/" + prod.getProd_name() + ".jpg");
			
					System.out.println("Path = " + path);
					System.out.println("File name = " + prod.getImg().getOriginalFilename());
					if (image != null && !image.isEmpty()) {
						try {
							image.transferTo(new File(path.toString()));
							System.out.println("Image Saved in:" + path.toString());
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Image not saved");
						}
					}
					
					Supplier supplier = supplierDAO.getByName(prod.getSupplier().getSupname());
					
					supplierDAO.saveOrUpdate(supplier);

					Category category = categoryDAO.getName(prod.getCategory().getCatname());
					
					categoryDAO.saveOrUpdate(category);

					prod.setCategory(category);
					prod.setSupplier(supplier);
					
					System.out.println("set");
					
					prod.setCat_id(category.getCat_id());
					prod.setSupplier_id(supplier.getSup_id());		
					
					productDAO.saveOrUpdate(prod);
					System.out.println("product added");

					model.addAttribute("message", "Products added successfully");
					model.addAttribute("productList", productDAO.list());

					return "AddProduct";
					
				}

		/*@RequestMapping("/product/remove/{id}")
		public ModelAndView deleteProduct(@ModelAttribute("product") Product prod,@PathVariable("id") String id,Model model) throws Exception {
			int i=Integer.parseInt(id);
			prod = productDAO.get(i);
			System.out.println(prod.getProd_id());
			System.out.println("in delete");
			ModelAndView mv = new ModelAndView("addProduct");
			if (prod == null) {
				mv.addObject("errorMessage", "Could not delete");
			} else {
			productDAO.delete(prod);
			//}
			model.addAttribute("productList",productDAO.list());
			return mv;
		}*/
		@RequestMapping("/product/edit/{id}") // @ModelAttribute("category"),Category
		// category
		public String editCategory(@ModelAttribute("id") Product prod, BindingResult result,
				HttpServletRequest request, Model model) {
			System.out.println("in product editpage ");
			
			prod = productDAO.get(product.getProd_id());
			System.out.println(product.getProd_id());
			if (category != null) {
				productDAO.saveOrUpdate(prod);
				model.addAttribute("message", "Successfully updated");
			} else {
				model.addAttribute("errorMessage", "Could not be updated");
			}
			model.addAttribute("product", product);
			model.addAttribute("productList", productDAO.list());
			return "redirect:/addProduct";
		}
		String setName;
		List<Product> plist;

		@RequestMapping("GsonCon")
		// @ResponseBody is used whenever angularjs is used
		// for filtering and sorting -angular js
		// (google)gson converts java obj into json(java script obj)

		public @ResponseBody String getValues() throws Exception {
			String result = "";
			plist = productDAO.list();
			Gson gson = new Gson();
			result = gson.toJson(plist);
			return result;
		}
		@RequestMapping(value = "/productdetail")
		public ModelAndView showViewDetails(@RequestParam("id") String id, Model model) {
			// RequestParam is used to get values in string format

			System.out.println("product details page");
			System.out.println("Id:" + id);

			// converting string to int
			int i = Integer.parseInt(id);
			model.addAttribute("productlist", productDAO.list());

			/* get product by id */
			Product product1 = productDAO.get(i);
			return new ModelAndView("productdetail", "product", product1);

		}


}
