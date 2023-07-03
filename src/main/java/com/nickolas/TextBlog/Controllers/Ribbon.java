package com.nickolas.TextBlog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ribbon {

    @GetMapping("/")
    public String ribbonPage() {
        return "ribbon";
    }

    @GetMapping("/createPost")
    public String creatingPage() {
        return "createPost";
    }

}
