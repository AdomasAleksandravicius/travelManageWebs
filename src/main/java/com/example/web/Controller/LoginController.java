package com.example.web.Controller;


import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletResponse response,
                        HttpSession session, Model model) {

        for (User user : DataProvider.usersList) {
            if (user.getUserName().equals(email) && user.getPassword().equals(password)) {
                session.setAttribute("user", user);

                Cookie cookie = new Cookie("loggedIn", user.getUserName());
                cookie.setPath("/");
                response.addCookie(cookie);
                return "/countries";
            }
        }
        model.addAttribute("error", "User email is not valid");
        return "/login";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }
}
