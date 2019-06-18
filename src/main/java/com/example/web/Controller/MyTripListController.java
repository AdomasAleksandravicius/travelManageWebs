package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/myTripList")
public class MyTripListController {


    @GetMapping(path = "")
    public String greeting(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("myTripList", DataProvider.getMyCountryList(user.getId()));
        return "myTripList";
    }
}
