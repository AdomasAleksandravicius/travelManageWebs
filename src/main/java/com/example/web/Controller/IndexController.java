package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(path = "/")
    public String index(
            @CookieValue(value = "loggedIn", defaultValue = "") String loggedIn,
            HttpSession session,
            Model model
    ) {

        for (User user : DataProvider.usersList) {

            if (user.getUserName().equals(loggedIn)) {
                session.setAttribute("user", user);
                model.addAttribute("user", user);
            }
        }
        return "index";
    }
}
