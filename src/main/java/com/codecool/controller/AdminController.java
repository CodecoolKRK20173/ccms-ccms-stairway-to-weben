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
    public AdminController(){
    this.mentorDAO = new MentorDAOFromCSV();
    this.regularEmployeeDAO = new RegularEmployeeDAOFromCSV();
    }

    public void start(){
        adminView.showAdminMenu();
        String actionNumber = adminView.input();
        performAction(actionNumber);
    }
    private void performAction(String actionNumber) {
        switch (actionNumber){
            case "1":
                showRegularEmployeesTable();
                break;
            case "2":
                showMentorsTable();
                break;
            case "3":
                regularEmployeeDAO.createEmployee();
                break;
            case "4":
                mentorDAO.createMentor();
                break;
            case "5":
                String userName;
                adminView.print("Enter employee's nick to delete it");
                userName = adminView.input();
                regularEmployeeDAO.deleteEmployee(userName);
                break;
            case "6":
                mentorDAO.deleteMentor();
                break;
            case "0":
                break;
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
