package com.codecool.model;

import com.codecool.dao.RegularEmployeeDAO;

public class Admin extends User{
    private String userName;
    private String password;
    private String id;
    private int group;
    private String name;
    private String surename;
//    private AdminView adminView;
//    private MentorDAO mentorDAO;
//    private StudentDAO studentDAO;
//    private RegularEmployeeDAO regularEmployeeDAO;
    public Admin(String id, String userName, String password, String name, String surename, int group){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surename = surename;
        this.group = group;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getGroup() {
        return group;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurename() {
        return surename;
    }
}

