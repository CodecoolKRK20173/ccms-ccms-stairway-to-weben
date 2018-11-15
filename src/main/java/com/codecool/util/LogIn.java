package com.codecool.util;

import com.codecool.dao.FileParser;
import com.codecool.view.MasterView;

import java.util.ArrayList;
import java.util.List;

public class LogIn {

    private FileParser fileWorkers;
    private FileParser fileStudents;
    private MasterView masterView;

    private List<String[]> listOfAllHumans;

    public LogIn() {
        this.listOfAllHumans = new ArrayList<>();
        this.masterView = new MasterView();
    }

    public String findGroupByLogin(String nick, String password) {
        this.fileWorkers = new FileParser("src/main/java/com/codecool/resources/Workers");
        this.fileStudents = new FileParser("src/main/java/com/codecool/resources/student.csv");
        int nickPosition = 1;
        int passwordPosition = 2;
        int groupPosition = 5;
        listOfAllHumans.addAll(fileWorkers.listOfUsers());
        listOfAllHumans.addAll(fileStudents.listOfUsers());
        for (String[] user : listOfAllHumans) {
            if (user[nickPosition].equals(nick) && user[passwordPosition].equals(password)) {
                return user[groupPosition];
            }
        }
        masterView.print("Wrong login or password");
        return "0";
    }

    public Boolean doNotDuplicateNickNames(String nick) {
        listOfAllHumans = new ArrayList<>();
        this.fileWorkers = new FileParser("src/main/java/com/codecool/resources/Workers");
        this.fileStudents = new FileParser("src/main/java/com/codecool/resources/student.csv");
        int nickPosition = 1;
        listOfAllHumans.addAll(fileWorkers.listOfUsers());
        listOfAllHumans.addAll(fileStudents.listOfUsers());
        for (String[] user : listOfAllHumans) {
            if (user[1].equals(nick)) {
                masterView.print("This nick already exist.");
                return true;
            }
        }
        return false;
    }
}
