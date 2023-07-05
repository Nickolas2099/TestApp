package com.nickolas.TextBlog.Controllers;

import com.nickolas.TextBlog.Posting.Post;
import com.nickolas.TextBlog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;

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

    @PostMapping("/createPost")
    public String create(@ModelAttribute("post") Post post, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "createPost";
        }
        post.setUserId(1);
        post.setPostTime(new Timestamp(System.currentTimeMillis()));
        postService.create(post);
        return "redirect:/";
    }

    @GetMapping("/{id}/updatePost")
    public String delete(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", postService.getById(id));
        return "updatePost";
    }

}
