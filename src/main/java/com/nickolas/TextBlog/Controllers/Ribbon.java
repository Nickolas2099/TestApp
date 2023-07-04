package com.nickolas.TextBlog.Controllers;

import com.nickolas.TextBlog.Posting.Post;
import com.nickolas.TextBlog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ribbon {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String ribbonPage(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "ribbon";
    }

    @GetMapping("/createPost")
    public String creatingPage(Model model) {
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping()
    public String create(@ModelAttribute("post") Post post, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "create";
        }
        postService.create(post);
        return "redirect:/";
    }

}
