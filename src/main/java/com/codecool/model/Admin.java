package com.codecool.model;

import com.codecool.dao.RegularEmployeeDAO;

public class Admin {
    private String login;
    private String password;
    private String id;
    private int group;
//    private AdminView adminView;
//    private MentorDAO mentorDAO;
//    private StudentDAO studentDAO;
//    private RegularEmployeeDAO regularEmployeeDAO;
    public Admin(String id, String login, String password, int group){
        this.group = group;
        this.id= id;
        this.login = login;
        this.password = password;
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

    public String getId() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}

