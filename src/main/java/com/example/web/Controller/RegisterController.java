package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addUser(@RequestParam("email")String email,
                            @RequestParam("password") String password, HttpSession session){
        User user = new User(email,password);
        this.dataProvider.addUser(user);
        session.setAttribute("user",user);
        return "/countries";
    }

}
