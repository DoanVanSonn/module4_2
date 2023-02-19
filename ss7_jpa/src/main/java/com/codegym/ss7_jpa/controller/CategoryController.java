package com.codegym.ss7_jpa.controller;

import com.codegym.ss7_jpa.bean.Category;
import com.codegym.ss7_jpa.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("category")
public class CategoryController {
    private IService categoryService;
    @Autowired
    public CategoryController(IService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("create")
    public String createCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addAttribute("category", new Category());
        redirectAttributes.addAttribute("mess2", "Category created");
        return "redirect:/blog/list";
    }

    @GetMapping("update")
    public String showUpdate(Model model, @RequestParam("id") int id) {
        model.addAttribute("category", categoryService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addAttribute("category", new Category());
        redirectAttributes.addAttribute("mess2", "Category updated.");
        return "redirect:blog/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addAttribute("category", new Category());
        redirectAttributes.addAttribute("mess2", "Category deleted.");
        return "redirect:/blog/list";
    }
}
