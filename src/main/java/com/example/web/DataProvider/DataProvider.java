package com.example.web.DataProvider;

import com.example.web.Model.City;
import com.example.web.Model.Country;
import com.example.web.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static List<Country> countryList;
    public static  List<City> cityList;
    public static Map<String,Country> countryMap;
    public static List<User> usersList;

    static {
        countryMap = new HashMap<>();
        countryList = new ArrayList<>();
        cityList = new ArrayList<>();
        usersList = new ArrayList<>();

        //countryList = new ArrayList<>();

//        addItem(new Country(null,"Japonija","geras salis daug visko pamatyt galima"),new City("hakamora"));
//        addItem(new Country(null,"Anglija","geras salis daug visko pamatyt galima,normaliai"),new City("hakamora"));
//        addItem(new Country(null,"Rusija","geras salis daug visko pamatyt galima keliaut"),new City("hakamora"));
//        addItem(country);

        User user = new User("adomas","labas123");
        usersList.add(user);

        Country australia = new Country(null,"Australia","daug visokiu zodziu apie sia sali", "australia.png");
        City viena = new City("Viena","kalnas, kepure,namas");
        cityList.add(viena);
        australia.setCities(cityList);
        countryMap.put("2", australia);

        Country austria = new Country(null,"Austria","noriu noriu", "austria.png");
        City viena1 = new City("Viena1","kalnas, kepure,namas");
        cityList.add(viena1);
        austria.setCities(cityList);
        countryMap.put("3", austria);

        Country brazil = new Country(null,"Brazil","Very big country, very hot one too", "brazil.png");
        City sanPaulo = new City("San Paulo","A lot of bueatiful places ");
        cityList.add(sanPaulo);
        brazil.setCities(cityList);
        countryMap.put("4", brazil);

        Country bulgaria = new Country(null,"austria","Very big country, very hot one too", "bulgaria.png");
        City sofia = new City("Sofia","A lot of bueatiful places ");
        cityList.add(sofia);
        bulgaria.setCities(cityList);
        countryMap.put("5", bulgaria);

    }

    public static void addUser(User user){
        usersList.add(user);
    }

    public static String getString(Country currentCountry){

        for (String currentVal: countryMap.keySet()){
            if (countryMap.get(currentVal).getName().contains(currentCountry.getName())){
                return currentVal;
            }
        }

        return null;
    }



    public static void replaceCountry(String key, Country country){
        countryMap.remove(key);
        countryMap.put(key, country);
    }

    public static void addItem(Country country){
        countryMap.put(country.getId(),country);
    }

    public static Country findCountry(String id){
        Country country = null;
        for (int i = 0; i <countryMap.size() ; i++) {
            if (id.equals(countryMap.get(i).getId())){
                country = countryMap.get(i);
            }
        }
        return country;
    }
}
