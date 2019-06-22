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
@RequestMapping("/country-edit")
public class CountryEditController {

    @GetMapping(path = "/{id}")
    public String edit(@PathVariable(name = "id") String id, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        Country country = DataProvider.getCountryById(id,user.getId());
        List<City> cities = country.getCities();
        model.addAttribute("country",country);
        model.addAttribute("cities",cities);

        return "editing-country";

    }

    @PostMapping(path = "/{id}")
    public String update(
    @RequestParam("name")String name,
                         @RequestParam("description") String description,
                         @RequestParam("cityName") String cityName,
                         @RequestParam("places") String places, @PathVariable String id,HttpSession session){
        User user = (User) session.getAttribute("user");
        Country country = DataProvider.getCountryById(id,user.getId());
        if (name == ""){
            country.setName(country.getName());
        }else{
            country.setName(name);
        }

        if (description == ""){
            country.setDescription(country.getDescription());
        }else{

            country.setDescription(description);
        }
        List<City> cities = country.getCities();
        City city = cities.get(0);
        if (cityName == ""){
            city.setName(city.getName());
        }else{

            city.setName(cityName);
        }

        if (places == ""){
            city.setDistrict(city.getDistrict());
        }else{

            city.setDistrict(places);
        }

        return "redirect:/myTripList";
    }

}
