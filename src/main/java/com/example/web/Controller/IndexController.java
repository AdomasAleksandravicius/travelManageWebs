package com.example.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;


@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping(path = "")
    public String greeting(Model model){
        model.addAttribute("greeting","Hello");
        return "index";
    }

}
