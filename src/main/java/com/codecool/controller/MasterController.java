package com.codecool.controller;


import com.codecool.util.LogIn;
import com.codecool.view.MasterView;
import com.codecool.view.StudentView;

public class MasterController {
    private StudentController studentController;
    private MentorController mentorController;
    private RegularEmployeeController regularEmployeeController;
    private AdminController adminController;
    private LogIn logIn;
    private MasterView masterView;


    public MasterController() {
        this.studentController = new StudentController();
        this.mentorController = new MentorController();
        this.regularEmployeeController = new RegularEmployeeController();
        this.adminController = new AdminController();
        this.logIn = new LogIn();
        this.masterView = new MasterView();
    }
    public String logIn(){
        String groupNumber = "0";
        while(groupNumber.equals("0")) {
            masterView.print("Enter login: ");
            String login = masterView.input();
            masterView.print("Enter password: ");
            String password = masterView.input();
            groupNumber = logIn.findGroupByLogin(login, password);
        }return  groupNumber;
    }
    public void start(){
        boolean isWorking = true;
        while(isWorking){
            String groupNumber = logIn();
            switch (groupNumber) {
                case "1":
                    adminController.start();
                    break;
                case "2":
                    regularEmployeeController.start();
                    break;
                case "3":
                    mentorController.start();
                    break;
                case "4":
                    studentController.switchStudentMenu();
                    break;
                case "0":
                    isWorking = false;
                    break;
                }
        }
    }
}
