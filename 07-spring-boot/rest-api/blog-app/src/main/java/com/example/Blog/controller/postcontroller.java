package com.example.Blog.controller;

import com.example.Blog.Repo.postrepo;
import com.example.Blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class postcontroller {

    @Autowired
    private postrepo repo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("posts", repo.findAll());
        return "index";
    }
    @GetMapping("/new")
    public String savepost(Model model) {
        model.addAttribute("post", new Post());
        return "new_post";
    }
    @PostMapping("/save")
    public String savepost(@ModelAttribute Post post) {
        repo.save(post);
        return "redirect:/";

    }
    @GetMapping("edit/{id}")
    public String editpost(@PathVariable int id, Model model) {
        model.addAttribute("post", repo.findById(id));
        return "edit_post";

    }
    @GetMapping("/delete/{id}")
    public String deletepost(@PathVariable int id, Model model) {
        repo.deleteById(id);
        return "redirect:/";

    }
    public String update(@ModelAttribute("post") Post post){
      repo.save(post);
      return "redirect:/";
    }



}
