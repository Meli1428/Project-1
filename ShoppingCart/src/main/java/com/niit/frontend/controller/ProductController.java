package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.model.Category;
import com.niit.shoppingbackend.model.Product;
import com.niit.shoppingbackend.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@ModelAttribute
	public Product returnObject()

	{
		return new Product();
	}

	

	@RequestMapping("/AddProduct")
	public ModelAndView showAddProducts(Model model) {
		ModelAndView mv= new ModelAndView("AddProduct");
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList",supplierDAO.list());
		return mv;
		}
	
	@RequestMapping(value = "/addprod", method = RequestMethod.POST)
	public String ShowAddProduct(@ModelAttribute("product")Product product,
			Model model, BindingResult result, HttpServletRequest request) throws IOException {
		System.out.println(product.getProd_name());
		System.out.println("image upload");
		System.out.println("myproduct controller called");
		MultipartFile image = product.getImg();
		Path path;/* belong to nio package */
		path = Paths.get(
				"C:/Users/Administrator/git/Project-1V1/ShoppingCart/src/main/webapp/resources/images" + product.getProd_name() + ".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name" + product.getImg().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e)

			{
				e.printStackTrace();
				System.out.println("Image not saved");

			}
		}
		/*product.setCat_Id(1);
		product.setSupp_Id(1);
		Supplier sup=new Supplier();
		product.setSupplier(sup);
		Category cat= new Category();
		product.setCategory(cat);*/
		Supplier supplier = supplierDAO.get(product.getSupplier().getSup_id());
		supplierDAO.saveOrUpdate(supplier);

		 Category category = categoryDAO.get(product.getCategory().getCat_id());
		categoryDAO.save(category);
		/*Category category = categoryDAO.getByName(product.getCategory().getCatname());
		categoryDAO.saveOrUpdate(category);  // why to save??

		Supplier supplier = supplierDAO.getByName(product.getSupplier().getSupname());
		supplierDAO.saveOrUpdate(supplier); // Why to save??
*/		
		
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCat_id(category.getCat_id());
		product.setSup_id(supplier.getSup_id());
		productDAO.saveOrUpdate(product);



		// product.setSupplier((Set<Supplier>) supplier);
		System.out.println("set");
		
		
		model.addAttribute("message", "Product added successully");
		model.addAttribute("productList", productDAO.list());
		return "Products";

	}
	@RequestMapping(value = "/DeleteProduct")
	public ModelAndView Deleteproduct(@RequestParam("id") String id) throws Exception {
		System.out.println("deleting prod");
		int i=Integer.parseInt(id);
		Product product = productDAO.get(i);
		ModelAndView mv = new ModelAndView("AdminProducts");
		productDAO.delete(i);
		mv.addObject("AdminProducts", 0);
		
		return mv;
	}

	
	@RequestMapping(value = "pupdate{id}", method = RequestMethod.GET)
	public String updateSupplier(@PathVariable("id") String id, Model model) {
		ModelAndView mv = new ModelAndView("product");
		int i=Integer.parseInt(id);
		System.out.println("update product");
		model.addAttribute("product", this.productDAO.get(i));
		model.addAttribute("listProducts", this.productDAO.list());
		mv.addObject("productList", productDAO.list());

		return "product";

	}

}
