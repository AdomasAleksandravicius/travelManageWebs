package com.example.web.Model;

import java.util.List;

public class User {
    private int id;
    private String userName;
    private String password;
    private List<Country> myCountryList;


    public User(String userName, String password) {
        this.id = 0;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Country> getMyCountryList() {
        return myCountryList;
    }

    public void setMyCountryList(List<Country> myCountryList) {
        this.myCountryList = myCountryList;
    }
}
