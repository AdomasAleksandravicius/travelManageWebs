package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/country_details")
public class CountryDetailsController {

    @GetMapping(value = "")
    public String countryDetails(@RequestParam(name="countryId")String countryId, Model model) {
        Country country = DataProvider.getCountry(countryId);

        model.addAttribute("country", country);
        model.addAttribute("cities", country.getCities());

        return "countryDetails";
    }
}
