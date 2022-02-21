package com.product.controller;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.model.ProductModel;
import com.product.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	public ProductRepository prodRepo;

	@GetMapping("/")
	public String addProduct(ProductModel product) {
	return ("add-product");
	}
	
	
	@PostMapping ("/addproduct")
	public String addProduct(ProductModel pro, BindingResult result, Model model ) {
		prodRepo.save(pro);
		return "redirect:/displayallproduct";
	}
	
	@GetMapping ("/displayallproduct")
	public String displayProduct(Model model) {
		model.addAttribute ("productModel", prodRepo.findAll());

		String search_param = "";
		model.addAttribute("search_param", search_param);
		return ("display-all-product");
	}
	
	 @GetMapping("/edit/{id}")
	  public String showUpdateBook(@PathVariable("id") long id, Model model) {
		 ProductModel pro = prodRepo.findById(id).get();
	      model.addAttribute("pro", pro);
	      return "edit-product";
	
	}
	 
	 
	 @PostMapping("/update/{id}")
	 public String updateProduct(@PathVariable("id") long id, @Valid ProductModel pro,
	  BindingResult result, Model model) {
		 prodRepo.save(pro);
		 return "redirect:/displayallproduct";
	 }
	 

	  @GetMapping("/delete/{id}")
	  public String deleteUser(@PathVariable("id") long id, Model model) {
		  
		 ProductModel pro = prodRepo.findById(id).get();
		  prodRepo.delete(pro);
		  
		  return "redirect:/displayallproduct";
	  }
	  
	  @GetMapping("/view-single-product/{id}")
	  public String showSingleProduct(@PathVariable("id") long id, Model model) {
		  ProductModel pro = prodRepo.findById(id).get();
	      model.addAttribute("pro", pro);
	      return "single-product";
	  }
	  
	  @GetMapping("/search")
		 public String searchByCategory(@RequestParam( value = "search_param") String search_param, Model model) {
			 List<ProductModel> pro = prodRepo.findByProductCategory(search_param);
			 model.addAttribute ("productModel", pro);
			 return "display-all-product";
		 }
}