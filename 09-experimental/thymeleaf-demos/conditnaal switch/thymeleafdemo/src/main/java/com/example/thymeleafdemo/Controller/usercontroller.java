package com.example.thymeleafdemo.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class usercontroller {
@GetMapping("/show/{age}")
    public String show( @PathVariable int age, Model model){
//        String channel = "hum or code";
//        model.addAttribute("channel", channel);
    int student_age = age ;
    model.addAttribute("student_age",student_age);


        return "show";

    }
}
