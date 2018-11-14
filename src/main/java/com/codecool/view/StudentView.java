package com.codecool.view;

import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.Student;

import java.util.List;

public class StudentView {
    public void printUnderConstruction(){
        System.out.println("Under Construction.");
    }

    private StudentDAOFromCSV studentDAOFromCSV;

    public StudentView(){
        this.studentDAOFromCSV = new StudentDAOFromCSV();
    }

    public void showStudentMenu(){
        System.out.println("1. Show my grades");
        System.out.println("2. Choose assignment to evaluation");
        System.out.println("3. Display available assignments");
        System.out.println("0. Exit from menu");
    }

    public void switchStudentMenu(int choice){
        switch(choice){
            case 1:
                // TO DO
                break;
            case 2:
                // TO DO
                break;
            case 3:
                // TO DO
                break;
            case 0:
                // TO DO
                break;
        }
    }
}
