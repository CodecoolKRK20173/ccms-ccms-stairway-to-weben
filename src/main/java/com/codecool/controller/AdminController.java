package com.codecool.controller;

import com.codecool.dao.MentorDAO;
import com.codecool.dao.MentorDAOFromCSV;
import com.codecool.dao.RegularEmployeeDAO;
import com.codecool.dao.RegularEmployeeDAOFromCSV;
import com.codecool.model.Mentor;
import com.codecool.model.RegularEmployee;
import com.codecool.view.AdminView;
import com.codecool.view.MentorView;
import com.codecool.view.RegularEmployeeView;

import java.util.List;

public class AdminController {
    private MentorDAO mentorDAO;
    private RegularEmployeeDAO regularEmployeeDAO;
    private AdminView adminView = new AdminView();
    private RegularEmployeeView regularEmployeeView = new RegularEmployeeView();
    private MentorView mentorView = new MentorView();
    private MentorController mentorController = new MentorController();
    private RegularEmployeeController regularEmployeeController = new RegularEmployeeController();
    public AdminController(){
    this.mentorDAO = new MentorDAOFromCSV();
    this.regularEmployeeDAO = new RegularEmployeeDAOFromCSV();
    }

    public void start(){
        performAction();
    }
    private void performAction() {
        boolean imLogged = true;
        while(imLogged){
            adminView.showAdminMenu();
            String actionNumber = adminView.input();
            switch (actionNumber) {
                case "1":
                    showRegularEmployeesTable();
                    adminView.input();
                    break;
                case "2":
                    showMentorsTable();
                    adminView.input();
                    break;
                case "3":
                    regularEmployeeDAO.createEmployee(regularEmployeeController.createNewEmployee());
                    adminView.input();
                    break;
                case "4":
                    mentorDAO.createMentor(mentorController.createNewMentor());
                    adminView.input();
                    break;
                case "5":
                    String userName;
                    adminView.print("Enter employee's nick to delete it");
                    userName = adminView.input();
                    regularEmployeeDAO.deleteEmployee(userName);
                    adminView.input();
                    break;
                case "6":
                    mentorDAO.deleteMentor(mentorController.nickToRemove());
                    adminView.input();
                    break;
                case "0":
                    imLogged = false;
                    break;
            }
        }
    }
    private void showRegularEmployeesTable(){
        List<RegularEmployee> regularEmployeesData = regularEmployeeDAO.getListOfEmployees();
        regularEmployeeView.printRegularEmployeeTable(regularEmployeesData);
    }
    private void showMentorsTable(){
        List<Mentor> mentorData = mentorDAO.getListOfMentors();
        mentorView.printMentorTable(mentorData);
    }
}
