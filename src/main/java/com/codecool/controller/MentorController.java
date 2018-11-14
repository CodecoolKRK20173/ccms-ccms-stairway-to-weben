package com.codecool.controller;

import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.Student;
import com.codecool.view.MentorView;

import java.util.List;

public class MentorController {
    private StudentDAO studentDAO;
    private MentorView mentorView = new MentorView();
    public MentorController(){
        this.studentDAO = new StudentDAOFromCSV();
    }
    public void start(){
        mentorView.showMentorMenu();
        String actionNumber = mentorView.input();
        performAction(actionNumber);
    }

    private void performAction(String actionNumber) {
        switch (actionNumber){
            case "1":
                showStudentsTable();
                break;
            case "2":
                mentorView.printUnderConstruction();
                break;
            case "3":
                mentorView.printUnderConstruction();
                break;
            case "4":
                mentorView.printUnderConstruction();
                break;
            case "5":
                mentorView.printUnderConstruction();
                break;
            case "6":
                studentDAO.addStudent();
                break;
            case "7":
                studentDAO.removeStudent();
                break;
            case "8":
                mentorView.printUnderConstruction();
                break;
            case "9":
                mentorView.printUnderConstruction();
                break;
            case "0":
                break;
        }
    }
    private void showStudentsTable(){
        List<Student> studentsData = studentDAO.convertToStudent();
        mentorView.printTable(studentsData);
    }

}
