package com.example.web.Controller;


import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;

@Controller
public class LoginController {

    /**
     * Logs in an existing user
     *
     * @param email    from the user
     * @param password password from the user
     * @param session  user attribute
     * @param model    error message
     * @param response NOT_FOUND
     * @return platform-index.html if user valid, login-index.html if user invalid
     */
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
                return "redirect:/countries";
            }else if (!user.getUserName().equals(email) || !user.getPassword().equals(password)){
                model.addAttribute("errormessage",
                        "Username or Password is not valid please re-enter!");
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }


        return "login";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }
}
