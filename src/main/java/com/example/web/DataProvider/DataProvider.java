package com.example.web.DataProvider;

import com.example.web.Model.City;
import com.example.web.Model.Country;
import com.example.web.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    private static List<Country> countryList;
    private static  List<City> cityList;
    private static Map<String,Country> countryMap;
    public static List<User> usersList;
    public static List<Country> myCountryList;
    public static Map<Integer,List<Country>> myTripMap;

    static {
        countryMap = new HashMap<>();
        countryList = new ArrayList<>();
        cityList = new ArrayList<>();
        usersList = new ArrayList<>();
        myCountryList = new ArrayList<>();
        myTripMap = new HashMap<>();

        User user = new User("adomas","labas123");
        usersList.add(user);

        prepopulateDataSet();

    //        Country australia = new Country(null,"Australia","daug visokiu zodziu apie sia sali", "australia.png");
    //        City viena = new City("Viena","kalnas, kepure,namas");
    //        cityList.add(viena);
    //        australia.setCities(cityList);
    //        countryMap.put("2", australia);
    //
    //        Country austria = new Country(null,"Austria","noriu noriu", "austria.png");
    //        City viena1 = new City("Viena1","kalnas, kepure,namas");
    //        cityList.add(viena1);
    //        austria.setCities(cityList);
    //        countryMap.put("3", austria);
    //
    //        Country brazil = new Country(null,"Brazil","Very big country, very hot one too", "brazil.png");
    //        City sanPaulo = new City("San Paulo","A lot of bueatiful places ");
    //        cityList.add(sanPaulo);
    //        brazil.setCities(cityList);
    //        countryMap.put("4", brazil);
    //
    //        Country bulgaria = new Country(null,"austria","Very big country, very hot one too", "bulgaria.png");
    //        City sofia = new City("Sofia","A lot of bueatiful places ");
    //        cityList.add(sofia);
    //        bulgaria.setCities(cityList);
    //        countryMap.put("5", bulgaria);

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

    public static void addMyList(int userId,Country country){

        if(myTripMap.containsKey(userId)){
            myTripMap.get(userId).add(country);
        }else{
            List<Country> myCou = new ArrayList<>();
            myCou.add(country);
            myTripMap.put(userId,myCou);
        }
    }

    public static List<Country> getMyCountryList(int userId){
        if (myTripMap.containsKey(userId)){
            return myTripMap.get(userId);
        }else{
            return null;
        }
    }

    public static Country getCountryById(String id,int userId){
        if (myTripMap.containsKey(userId)){
            List<Country> countries = myTripMap.get(userId);
            for (Country country:countries){
                if (country.getId().equals(id)){
                    return country;

                }
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

    public static List<Country> getCountryList() {
        return countryList;
    }

    private static void prepopulateDataSet() {
        Country countryOne = new Country("","Australia","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countryTwo = new Country("","Italy","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countryThree = new Country("","India","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countryFour = new Country("","Lithuania","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countryFive = new Country("","Romania","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countrySix = new Country("", "Russia","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countrySeven = new Country("", "United Kingdom","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countryEight = new Country("", "Belgium","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");
        Country countryNine = new Country("", "Netherlands","Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.");


        countryList.add(countryOne);
        countryList.add(countryTwo);
        countryList.add(countryThree);
        countryList.add(countryFour);
        countryList.add(countryFive);
        countryList.add(countrySix);
        countryList.add(countrySeven);
        countryList.add(countryEight);
        countryList.add(countryNine);
    }
}
