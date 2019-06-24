package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class RegisterController {
    /**
     * Returns register index page
     *
     * @param session the current session
     * @return register.html
     */

    @GetMapping("")
    public String index(HttpSession session){
        if(session.getAttribute("user") !=null ){
            System.out.println("labas");
            return "redirect:/countries";

        }
        return "/register";
    }
    @PostMapping("")
    public String addUser(User user, HttpSession session){
        DataProvider.addUser(user);
        session.setAttribute("user",user);
        return "redirect:/countries";
    }
}
