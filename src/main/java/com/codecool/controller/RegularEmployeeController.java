package com.codecool.controller;

import com.codecool.dao.RegularEmployeeDAO;
import com.codecool.dao.RegularEmployeeDAOFromCSV;
import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.RegularEmployee;
import com.codecool.model.Student;
import com.codecool.view.RegularEmployeeView;

import java.util.List;

public class RegularEmployeeController {

    private RegularEmployeeDAO regularEmployeeDAO = new RegularEmployeeDAOFromCSV();
    private RegularEmployeeView regularEmployeeView = new RegularEmployeeView();
    private StudentDAO studentDAO= new StudentDAOFromCSV();

    public void start(){
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

    private void showStudentsTable(){
        List<Student> studentsData = studentDAO.convertToStudent();
        regularEmployeeView.printTable(studentsData);
    }


}

