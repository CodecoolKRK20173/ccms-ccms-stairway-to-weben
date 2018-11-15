package com.codecool.model;

public class Admin implements User {
    private String userName;
    private String password;
    private String id;
    private int group;
    private String name;
    private String surname;

    public Admin(String id, String userName, String password, String name, String surname, int group) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
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
    public String getSurname() {
        return surname;
    }
}

