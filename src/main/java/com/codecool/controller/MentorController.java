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
        performAction();
    }

    private void performAction() {
        boolean imLogged = true;
        while(imLogged){
            mentorView.showMentorMenu();
            String actionNumber = mentorView.input();
            switch (actionNumber) {
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
                    imLogged = false;
                    break;
            }
        }
    }
    private void showStudentsTable(){
        List<Student> studentsData = studentDAO.convertToStudent();
        mentorView.printTable(studentsData);
    }

    public void showAllInformationAboutStudents(){
        List<Student> result = studentDAO.convertToStudent();

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showListOfStudents(){
        List<Student> result = studentDAO.getListOfStudents();

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showAddressesOfStudents(){
        List<Student> result = studentDAO.getAddresses();

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showStudentInSpecifiedGroup(){
        System.out.print("Enter group class: ");
        String groupClass = mentorView.input();
        List<Student> result = studentDAO.getListOfStudentsByGroup(groupClass);

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showSystemOfEditStudent(){
        System.out.print("Enter id of record: ");
        String idOld = mentorView.input();
        System.out.print("Enter new id: ");
        String idNew = mentorView.input();
        System.out.print("Enter new login: ");
        String login = mentorView.input();
        System.out.print("Enter new password: ");
        String password = mentorView.input();
        System.out.print("Enter new name: ");
        String name = mentorView.input();
        System.out.print("Enter new surname: ");
        String surname = mentorView.input();
        System.out.print("Enter new group class: ");
        String groupClass = mentorView.input();
        System.out.print("Enter new address: ");
        String address = mentorView.input();
        System.out.print("Enter new email: ");
        String email = mentorView.input();

        List<Student> result = studentDAO.editStudent(idOld, idNew, login, password, name, surname, groupClass, address, email);

        for(Student student: result){
            System.out.println(student);
        }
    }

}
