package com.example.web.Controller;

import com.example.web.Model.City;
import com.example.web.Model.Country;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller
public class CountryController {

    @PostMapping("/countryAddForm")
    public String addCountry(@RequestParam("name")String name,
                        @RequestParam("description") String description,
                             @RequestParam("cityName") String cityName,
                             @RequestParam("places") String places, Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        Country country = new Country(null,name,description);
        City city = new City(cityName,places);
        country.addCity(city);

            if (country != null){

                return "/myCountryList";
            }


        model.addAttribute("error","Add Country");
        return "/countryAddForm";
    }

    @GetMapping(path = "/countryAddForm")
    public String addForm(Model model){
        model.addAttribute("greeting","Hello");
        return "countryAddForm";
    }
}
