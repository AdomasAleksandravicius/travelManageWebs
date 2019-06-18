package com.example.web.Controller;


import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    private DataProvider dataProvider = new DataProvider();

    public String index(HttpSession session){

        if(session.getAttribute("user") !=null ){
            return "redirect:/countries";
        }
        return "/login";
    }

    @PostMapping("")
    public String login(@RequestParam("email")String email,
                        @RequestParam("password") String password, HttpSession session, Model model){
        for(User user:this.dataProvider.usersList){
            if (user.getUserName().equals(email) && user.getPassword().equals(password)){
                session.setAttribute("user",user);
                return "redirect:/countries";
            }

        }
        model.addAttribute("error","User email is not valid");
        return "/login";
    }

    @GetMapping(path = "")
    public String greeting(Model model){
        model.addAttribute("greeting","Hello");
        return "login";
    }

}
