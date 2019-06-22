package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.City;
import com.example.web.Model.Country;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/myTripList")
public class MyTripListController {

    @GetMapping(value = "")
    public String processForm(String q, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Country> newList = DataProvider.getMyCountryList(user.getId());
        model.addAttribute("myTripList", newList);
        return "myTripList";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(name="countryId")String countryId,HttpSession session){
        User user = (User) session.getAttribute("user");
        DataProvider.deleteCountryFromList(user.getId(),countryId);

        return "redirect:/myTripList";
    }

}
