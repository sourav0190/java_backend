package com.example.thymeleafdemo.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class usercontroller {

    @GetMapping("/home/{user}")
    public String getdata(@PathVariable int user, Model model) {
        List<Integer> table = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            table.add(user *i);


        }
        model.addAttribute("number", user);
        model.addAttribute("table", table);
        return "index";
    }
}
