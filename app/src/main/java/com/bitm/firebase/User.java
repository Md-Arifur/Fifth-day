package com.bitm.firebase;

//For write multiple data using pojo class.
public class User {
    private String name;
    private int age;
    private String gender;
    private String userId;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
//Constructor for take data.
    public User(String name, int age, String gender, String userId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.userId = userId;
    }
//Setter method For set user id.
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getUserId() {
        return userId;
    }
}
