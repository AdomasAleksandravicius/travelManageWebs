package com.example.web.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Country {
    private  String imgString;
    private String id;
    private String name;
    private String description;
    private List<City> cities;
    private int travelTime;
    public Country() {
    }

    public Country(String id ,String name, String description, String image) {

        if (id == null){
            id = UUID.randomUUID().toString();
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgString = image;
        cities=new ArrayList<>();
    }

    public String getImgString() {
        return imgString;
    }

    public void setImgString(String imgString) {
        this.imgString = imgString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<City> getCities() {
        return cities;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public List<City> returnCities(){

        return cities;
    }


    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void addCity(City city){
        cities.add(city);
    }
}
