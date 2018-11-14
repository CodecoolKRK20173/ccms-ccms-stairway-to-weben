package com.codecool.view;

import com.codecool.controller.StudentController;
import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.Student;

import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.Scanner;

public class StudentView {
    public void printUnderConstruction(){
        System.out.println("Under Construction.");
    }

//    private StudentDAO studentDAO;
//    private StudentController studentController = new StudentController();;
    private Scanner scanner = new Scanner(System.in);;

//    public StudentView(){
//        this.studentDAO = new StudentDAOFromCSV();
//        this.studentController = new StudentController();
//        this.scanner =  new Scanner(System.in);
//    }

    public void showStudentMenu(){
        System.out.println("1. Show my grades");
        System.out.println("2. Choose assignment to evaluation");
        System.out.println("3. Display available assignments");
        System.out.println("4. Show average of my grades");
        System.out.println("0. Exit from menu");
    }


    public void print(String text){
        System.out.println(text);
    }
    public String input(){
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return  input;
    }



}
