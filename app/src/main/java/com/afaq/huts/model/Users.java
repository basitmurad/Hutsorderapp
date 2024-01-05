package com.afaq.huts.model;

public class Users {
    private String name ,email , number , password ,userId ,userFcmToken;

    public Users() {
    }


    public Users(String name, String email, String number, String password, String userId, String userFcmToken) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
        this.userId = userId;
        this.userFcmToken = userFcmToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFcmToken() {
        return userFcmToken;
    }

    public void setUserFcmToken(String userFcmToken) {
        this.userFcmToken = userFcmToken;
    }
}
