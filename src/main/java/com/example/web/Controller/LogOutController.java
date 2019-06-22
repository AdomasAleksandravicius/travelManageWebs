package com.example.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("logout")
public class LogOutController {

    @GetMapping(path = "")
    public String logout(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            session.invalidate();
            return "redirect:/login";
        }
        return "redirect:/login";
    }

}
