package com.codecool.dao;

import com.codecool.model.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminDAOFromCSV implements AdminDAO{
    private FileParser fileParser;
    private List<String []> listOfArrays;
    private Admin admin;
    private String AdminGroup = "1";
    private int AdminGroupNumber = 1;

    public AdminDAOFromCSV(FileParser fileParser) {
        this.fileParser = new FileParser("ccms-ccms-stairway-to-weben/src/main/java/com/codecool/dao/Workers");
        listOfArrays = new ArrayList<>();
    }

    public String toString(Admin admin){
        String newAdmin = "";
        newAdmin += admin.getId();
        newAdmin += "|";
        newAdmin += admin.getUserName();
        newAdmin += "|";
        newAdmin += admin.getPassword();
        newAdmin += "|";
        newAdmin += admin.getName();
        newAdmin += "|";
        newAdmin += admin.getSurname();
        newAdmin += "|";
        newAdmin += "3";
        newAdmin += "|";
        return  newAdmin;

    }

    public FileParser getFileParser() {
        return fileParser;
    }

    @Override
    public Admin getAdmin() {
        this.listOfArrays = fileParser.listOfUsers();
        for (int i = 0; i < listOfArrays.size(); i++) {
            if (listOfArrays.get(i)[5].equals(AdminGroup)){
                this.admin = new Admin(listOfArrays.get(i)[0],listOfArrays.get(i)[1],listOfArrays.get(i)[2],listOfArrays.get(i)[3],listOfArrays.get(i)[4],AdminGroupNumber);
            }
        }
        return admin;
    }
}
