package com.example.ss10_session_cookie.controller;

import com.example.ss10_session_cookie.model.Cart;
import com.example.ss10_session_cookie.model.Product;
import com.example.ss10_session_cookie.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = Optional.ofNullable(productService.findById(id));
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @PostMapping(value = "/update")
    public String updateProduct(@RequestParam("id") Long id,
                                @RequestParam("name") String name,
                                @RequestParam("price") double price,
                                @RequestParam("description") String description,
                                @RequestParam("picture") String picture
    ) {
        Product product = new Product(id, name, price, description, picture);
        productService.updateProduct(product);
        return "redirect:/shop";
    }
}

