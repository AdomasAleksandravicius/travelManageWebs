package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.City;
import com.example.web.Model.Country;
import com.example.web.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/countries")
public class CountryController {

    /**
     * Countries controller
     *
     * @param name    country name
     * @param description country description
     * @param cityName citi Name
     * @param places city most visited places
     * @param session  user attribute
     * @param model    error message
     * @return country add form, country list
     */
    @PostMapping("/countryAddForm")
    public String addCountry(@RequestParam("name")String name,
                        @RequestParam("description") String description,
                             @RequestParam("cityName") String cityName,
                             @RequestParam("places") String places, Model model,HttpSession session){
        if (session != null){

            User user = (User) session.getAttribute("user");
            Country country = new Country(null,name,description, "");
            City city = new City(cityName,places);
            country.addCity(city);
            DataProvider.addMyList(user.getId(),country);
           return "redirect:/myTripList";
        }else{

            model.addAttribute("error","Add Country");
            return "countryAddForm";
        }


    }

    @RequestMapping(value = "/add-country-to-my-List", method = RequestMethod.GET)
    public String addCountryToMyList(@RequestParam(name="countryId")String countryId,HttpSession session){
        User user = (User) session.getAttribute("user");
        Country country = DataProvider.getCountry(countryId);
        DataProvider.addMyList(user.getId(),country);

        return "redirect:/countries";

    }

    @GetMapping(path = "/countryAddForm")
    public String addForm(){

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