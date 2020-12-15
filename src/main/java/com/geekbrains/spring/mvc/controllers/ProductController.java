package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts (Model model){
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteOnId(@PathVariable Integer id){
        productService.deleteOnId(id);
        return "redirect:/products/all";
    }

    @GetMapping("/removeAll")
    public String deleteAll(){
        productService.deleteAll();
        return "redirect:/products/all";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/products/all";
    }
}
