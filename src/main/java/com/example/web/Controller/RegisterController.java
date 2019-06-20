package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private DataProvider dataProvider = new DataProvider();

    @GetMapping("")
    public String index(HttpSession session){
        if(session.getAttribute("user") !=null ){
            return "/countries";
        }
        return "/register";
    }
    @PostMapping("")
    public String addUser(User user, HttpSession session){
        this.dataProvider.addUser(user);
        session.setAttribute("user",user);
        return "countries";
    }

}
