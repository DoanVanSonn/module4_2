package codegym.vn.controller;

import codegym.vn.bean.Comment;
import codegym.vn.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class CommentController {
    @Autowired
    ICommentService service;

    @GetMapping({"home", ""})
    public String getHome(Model model) {
        model.addAttribute("newComment", new Comment());
        model.addAttribute("list", service.findAll());
        return "home";
    }

    @PostMapping("comment")
    public String comment(Model model, @ModelAttribute("newComment") Comment comment) {
        service.comment(comment);
        model.addAttribute("newComment", new Comment());
        model.addAttribute("list", service.findAll());
        return "home";
    }

    @GetMapping("like")
    public String like(Model model, @RequestParam("id") int id) {
        service.like(id);
        model.addAttribute("newComment", new Comment());
        model.addAttribute("list", service.findAll());
        return "home";
    }
}
