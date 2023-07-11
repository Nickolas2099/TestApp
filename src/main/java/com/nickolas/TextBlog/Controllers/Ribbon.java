package com.nickolas.TextBlog.Controllers;

import com.nickolas.TextBlog.Posting.Post;
import com.nickolas.TextBlog.Services.PostService;
import com.nickolas.TextBlog.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Controller
public class Ribbon {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String ribbonPage(Model model) {

        List<Post> posts = postService.getAll();
        for(Post post : posts) {
            post.setNickname(userService.getById(post.getUserId()).getNickname());
        }
        model.addAttribute("posts", posts);
        return "ribbon";
    }

    @GetMapping("/createPost")
    public String creatingPage(Model model) {
        model.addAttribute("post", new Post());
        return "createPost";
    }

    @PostMapping("/createPost")
    public String create(@ModelAttribute("post") @Validated Post post, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "createPost";
        }
        post.setUserId(1);
        post.setPostTime(new Timestamp(System.currentTimeMillis()));
        postService.create(post);
        return "redirect:/";
    }

    @GetMapping("/{id}/updatePost")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("post", postService.getById(id));
        return "updatePost";
    }

    @PatchMapping("/{id}/updatePost")
    public String edit(@ModelAttribute("post") @Validated Post post, @PathVariable("id") int id,
                       BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.info("Something went wrong in the post update module");
            return "/{id}/updatePost";
        }
        Post origPost = postService.getById(id);
        post.setUserId(origPost.getUserId());
        post.setPostTime(origPost.getPostTime());
        postService.update(id, post);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        postService.delete(id);
        return "redirect:/";
    }

}
