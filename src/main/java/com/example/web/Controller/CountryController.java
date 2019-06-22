package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
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
@RequestMapping("/countries")
public class CountryController {

    @PostMapping("/countryAddForm")
    public String addCountry(@RequestParam("name")String name,
                        @RequestParam("description") String description,
                             @RequestParam("cityName") String cityName,
                             @RequestParam("places") String places, Model model,HttpSession session){
        if (session != null){

            User user = (User) session.getAttribute("user");
            Country country = new Country(null,name,description);
            City city = new City(cityName,places);
            System.out.println(country);
            System.out.println(city);
            country.addCity(city);
            DataProvider.addMyList(user.getId(),country);
           return "redirect:/myTripList";
        }else{

            model.addAttribute("error","Add Country");
            return "countryAddForm";
        }


    }


    @GetMapping(path = "/countryAddForm")
    public String addForm(Model model){
        return "countryAddForm";
    }

    @GetMapping(path = "")
    public String countries(Model model) {
        model.addAttribute("countries", DataProvider.getCountryList());
        return "countries";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam(defaultValue = "", value = "search") String search) {
        model.addAttribute("countries", DataProvider.findCountries(search));
        return "countries";
    }
}