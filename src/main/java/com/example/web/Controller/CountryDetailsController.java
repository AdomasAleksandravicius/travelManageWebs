package com.example.web.Controller;

import com.example.web.DataProvider.DataProvider;
import com.example.web.Model.Country;
import com.example.web.exceptions.CountryExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/country_details")
public class CountryDetailsController {

    @GetMapping(value = "")
    public String countryDetails(@RequestParam(name="countryId")String countryId, Model model,HttpServletResponse response) {
        Country country = DataProvider.getCountry(countryId);

        model.addAttribute("country", country);
        model.addAttribute("cities", country.getCities());
        if (country != null){

            return "countryDetails";
        }

        CountryExceptions countryExceptions = new CountryExceptions(HttpStatus.NOT_FOUND,
                "Country was not found");
        model.addAttribute("errormessage", countryExceptions);
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return "/exceptions/country-exception-error-page.html";
    }
}
