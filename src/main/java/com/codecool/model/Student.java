package com.codecool.model;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private String id;
    private String login;
    private String password;
    private int group;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String attendance;
    private Map<String, Integer> grades;

    public Student(String id, String login, String password, int group, String name, String surname, String email, String address){
        this.id = id;
        this.login = login;
        this.password = password;
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.grades = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroup() {
        return group;
    }

    public String getAttendance(){
        return attendance;
    }

    public void setAttendance(String attendance){
        this.attendance = attendance;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Integer> grades) {
        this.grades = grades;
    }
}
