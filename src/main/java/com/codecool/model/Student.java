package com.codecool.model;

import java.util.HashMap;
import java.util.Map;

public class Student extends User{

    private String id;
    private String login;
    private String password;
    private final int group = 4;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String attendance;
    private String groupClass;
    private Map<String, Integer> grades;

    public Student(){

    }

    public Student(String id, String login, String password, String name, String surname, String email, String address, String groupClass){
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.groupClass = groupClass;
        this.grades = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
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

    public String getGroupClass(){
        return groupClass;
    }

    public String toString(){
        return id + " " + name + " " + surname + " " + email + " " + address + " " + groupClass;
    }
}
