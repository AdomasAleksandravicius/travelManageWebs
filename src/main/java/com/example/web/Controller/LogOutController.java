package com.example.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("logout")
public class LogOutController {

    @GetMapping(path = "")
    public String logout(HttpSession session,HttpServletResponse response, HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            Cookie cookie[] =  request.getCookies();
            cookie[0].setValue("");
            response.addCookie(cookie[0]);
            session.invalidate();
            return "redirect:/login";
        }
        return "redirect:/login";
    }

}
