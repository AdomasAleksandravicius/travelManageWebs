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
    private static List<City> cityList;
    private static Map<String, Country> countryMap;
    public static List<User> usersList;
    public static List<Country> myCountryList;
    public static Map<Integer, List<Country>> myTripMap;

    static {
        countryMap = new HashMap<>();
        countryList = new ArrayList<>();
        cityList = new ArrayList<>();
        usersList = new ArrayList<>();
        myCountryList = new ArrayList<>();
        myTripMap = new HashMap<>();

        User user = new User("adomas", "labas123");
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

    public static void addUser(User user) {
        usersList.add(user);
    }

    public static String getString(Country currentCountry) {

        for (String currentVal : countryMap.keySet()) {
            if (countryMap.get(currentVal).getName().contains(currentCountry.getName())) {
                return currentVal;
            }
        }

        return null;
    }

    public static void addMyList(int userId, Country country) {

        if (myTripMap.containsKey(userId)) {
            myTripMap.get(userId).add(country);
        } else {
            List<Country> myCou = new ArrayList<>();
            myCou.add(country);
            myTripMap.put(userId, myCou);
        }
    }

    public static List<Country> getMyCountryList(int userId) {
        if (myTripMap.containsKey(userId)) {
            return myTripMap.get(userId);
        } else {
            return null;
        }
    }

    public static Country getCountryById(String id, int userId) {
        if (myTripMap.containsKey(userId)) {
            List<Country> countries = myTripMap.get(userId);
            for (Country country : countries) {
                if (country.getId().equals(id)) {
                    return country;

                }
            }
        }
        return null;
    }

    public static void deleteCountryFromList(int userId, String countryId) {
        if (myTripMap.containsKey(userId)) {
            List<Country> countries = myTripMap.get(userId);
            for (Country country : countries) {
                if (country.getId().equals(countryId)) {
                    countries.remove(country);

                }
            }
        }
    }


    public static Country getCountry(String countryId) {
        for (Country country : countryList) {
            if (country.getId().equals(countryId)) {
                return country;
            }
        }
        return null;
    }

    public static void replaceCountry(String key, Country country) {
        countryMap.remove(key);
        countryMap.put(key, country);
    }

    public static void addItem(Country country) {
        countryMap.put(country.getId(), country);
    }

    public static Country findCountry(String id) {
        Country country = null;
        for (int i = 0; i < countryMap.size(); i++) {
            if (id.equals(countryMap.get(i).getId())) {
                country = countryMap.get(i);
            }
        }
        return country;
    }

    public static List<Country> findCountries(String query) {

        List<Country> searchResults = new ArrayList<>();

        for (Country country : countryList) {
            if (country.getName().toLowerCase().contains(query.toLowerCase()) || country.getDescription().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(country);
            }
        }
        return searchResults;
    }

    public static List<Country> getCountryList() {
        return countryList;
    }

    private static void prepopulateDataSet() {
        Country australia = new Country("1",
                "Australia",
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of " +
                        "classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin " +
                        "professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, " +
                        "consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical" +
                        " literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and" +
                        " 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, " +
                        "written in 45 BC. This book is a treatise on the theory of ethics, very popular during the" +
                        " Renaissance.",
                "/images/australia.jpg");

        List<City> australiaCities = new ArrayList<>();
        City sidney = new City("Sydney", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City melbourne = new City("Melbourne", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City adelaide = new City("Adelaide", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City perth = new City("Perth", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        australiaCities.add(sidney);
        australiaCities.add(melbourne);
        australiaCities.add(adelaide);
        australiaCities.add(perth);

        australia.setCities(australiaCities);

        Country italy = new Country("2",
                "Italy", "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of " +
                "classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin" +
                " professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words," +
                " consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature," +
                " discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and " +
                "1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written " +
                "in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance.",
                "/images/italy.jpg");

        List<City> italyCities = new ArrayList<>();
        City rome = new City("Rome", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City florence = new City("Florence", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City venice = new City("Venice", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City milan = new City("Milan", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        italyCities.add(rome);
        italyCities.add(florence);
        italyCities.add(venice);
        italyCities.add(milan);

        italy.setCities(italyCities);

        Country india = new Country("3",
                "India",
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical " +
                        "Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a" +
                        " Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure" +
                        " Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the " +
                        "word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from" +
                        " sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good " +
                        "and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics," +
                        " very popular during the Renaissance.",
                "/images/india.jpg");

        List<City> indiaCities = new ArrayList<>();
        City mumbai = new City("Mumbai", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City bengaluru = new City("Bengaluru", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City chennai = new City("Chennai", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City kolkata = new City("Kolkata", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        indiaCities.add(mumbai);
        indiaCities.add(bengaluru);
        indiaCities.add(chennai);
        indiaCities.add(kolkata);

        india.setCities(indiaCities);

        Country lithuania = new Country("4",
                "Lithuania", "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots " +
                "in a piece of classical Latin literature from 45 BC, making it over 2000 years old. " +
                "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one " +
                "of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through " +
                "the cites of the word in classical literature, discovered the undoubtable source. Lorem " +
                "Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" " +
                "(The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on " +
                "the theory of ethics, very popular during the Renaissance.",
                "/images/lithuania.jpg");

        List<City> lithuaniaCities = new ArrayList<>();
        City kaunas = new City("Kaunas", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City vilnius = new City("Vilnius", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City palanga = new City("Palanga", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City taurage = new City("Taurage", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        lithuaniaCities.add(kaunas);
        lithuaniaCities.add(vilnius);
        lithuaniaCities.add(palanga);
        lithuaniaCities.add(taurage);

        lithuania.setCities(lithuaniaCities);

        Country romania = new Country("5",
                "Romania", "Contrary to popular belief, Lorem Ipsum is not simply random text. It has" +
                " roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. " +
                "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of " +
                "the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites " +
                "of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes " +
                "from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil)" +
                " by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during" +
                " the Renaissance.",
                "/images/romania.jpg");

        List<City> romaniaCities = new ArrayList<>();
        City bucharest = new City("Bucharest", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City brasov = new City("Brasov", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City sibiu = new City("Sibiu", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City iasi = new City("Iasi", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        romaniaCities.add(bucharest);
        romaniaCities.add(brasov);
        romaniaCities.add(sibiu);
        romaniaCities.add(iasi);

        romania.setCities(romaniaCities);

        Country russia = new Country("6",
                "Russia",
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a " +
                        "piece of classical Latin literature from 45 BC, making it over 2000 years old. " +
                        "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked " +
                        "up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage," +
                        " and going through the cites of the word in classical literature, discovered the undoubtable " +
                        "source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus" +
                        " Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This " +
                        "book is a treatise on the theory of ethics, very popular during the Renaissance.",
                "/images/russia.jpg");

        List<City> russianCities = new ArrayList<>();
        City moscow = new City("Moscow", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City kazan = new City("Kazan", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City omsk = new City("Omsk", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        City novasibirsk = new City("Novasibirsk", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        russianCities.add(moscow);
        russianCities.add(kazan);
        russianCities.add(omsk);
        russianCities.add(novasibirsk);

        russia.setCities(russianCities);

        countryList.add(australia);
        countryList.add(india);
        countryList.add(italy);
        countryList.add(lithuania);
        countryList.add(romania);
        countryList.add(russia);
    }
}
