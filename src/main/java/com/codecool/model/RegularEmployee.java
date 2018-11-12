package com.codecool.model;

public class RegularEmployee {

    private String id;
    private String userName;
    private String password;
    private String name;
    private String surename;
    private int group;

    public RegularEmployee(String id, String userName, String password, String name, String surename, int group){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surename = surename;
        this.group = group;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurename() {
        return surename;
    }

    public int getGroup() {
        return group;
    }


}
