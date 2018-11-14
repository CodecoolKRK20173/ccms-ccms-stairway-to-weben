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
        regularEmployeeView.printMenu();
        int actionNumber = regularEmployeeView.getUsersChoice();
        performAction(actionNumber);
    }

    private void performAction(int actionNumber) {
        switch (actionNumber){
            case 1:
                showStudentsTable();
                break;
            case 2:
                regularEmployeeView.printUnderConstruction();
                break;
            case 3:
                regularEmployeeView.printUnderConstruction();
                break;
            case 4:
                regularEmployeeView.printUnderConstruction();
                break;
            case 5:
                regularEmployeeView.printUnderConstruction();
                break;
            case 6:
                regularEmployeeView.printUnderConstruction();
                break;
            case 0:
                break;
        }
    }

    private void showStudentsTable(){
        List<Student> studentsData = studentDAO.convertToStudent();
        regularEmployeeView.printTable(studentsData);
    }


}

