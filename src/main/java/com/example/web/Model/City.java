package com.example.web.Model;

public class City {

    private String name;
    private String district;

    public City() {
    }

    public City(String name,String district) {
        this.name = name;
        this.district = district;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
