package com.codecool.controller;

import com.codecool.dao.RegularEmployeeDAO;
import com.codecool.dao.RegularEmployeeDAOFromCSV;
import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.RegularEmployee;
import com.codecool.model.Student;
import com.codecool.util.LogIn;
import com.codecool.util.Util;
import com.codecool.util.UtilFromCSV;
import com.codecool.util.UtilFromSQL;
import com.codecool.view.RegularEmployeeView;

import java.util.List;

public class RegularEmployeeController {

    private RegularEmployeeDAO regularEmployeeDAO = new RegularEmployeeDAOFromCSV();
    private RegularEmployeeView regularEmployeeView = new RegularEmployeeView();
    private StudentDAO studentDAO = new StudentDAOFromCSV();
    private LogIn logIn = new LogIn();
    private Util utilFromCSV = new UtilFromCSV();
    private Util utilFromSQL = new UtilFromSQL();

    public void start() {
        performAction();
    }

    private void performAction() {
        boolean imLogged = true;
        while(imLogged){
                regularEmployeeView.printMenu();
                String actionNumber = regularEmployeeView.input();
            switch (actionNumber) {
                case "1":
                    showStudentsTable();
                    regularEmployeeView.input();
                    break;
                case "2":
                    regularEmployeeView.printUnderConstruction();
                    regularEmployeeView.input();
                    break;
                case "3":
                    regularEmployeeView.printUnderConstruction();
                    regularEmployeeView.input();
                    break;
                case "4":
                    regularEmployeeView.printUnderConstruction();
                    regularEmployeeView.input();
                    break;
                case "5":
                    regularEmployeeView.printUnderConstruction();
                    regularEmployeeView.input();
                    break;
                case "6":
                    regularEmployeeView.printUnderConstruction();
                    regularEmployeeView.input();
                    break;
                case "0":
                    imLogged = false;
                    break;
            }
        }
    }

    private void showStudentsTable() {
        List<Student> studentsData = studentDAO.convertToStudent();
        regularEmployeeView.printTable(studentsData);
    }

    public RegularEmployee createNewEmployee() {
        RegularEmployee regularEmployee = null;
        String id;
        String userName;
        String password;
        String name;
        String surname;
        int group;
//        id = utilFromCSV.getNewId();
        id = utilFromSQL.getNewId();
        do {
            regularEmployeeView.print("Enter user name: ");
            userName = regularEmployeeView.input();
        } while (logIn.doNotDuplicateNickNames(userName));
        regularEmployeeView.print("Enter password: ");
        password = regularEmployeeView.input();
        regularEmployeeView.print("Enter name: ");
        name = regularEmployeeView.input();
        regularEmployeeView.print("Enter surname: ");
        surname = regularEmployeeView.input();
        regularEmployee = new RegularEmployee(id, userName, password, name, surname, 2);
        return regularEmployee;
    }


}

