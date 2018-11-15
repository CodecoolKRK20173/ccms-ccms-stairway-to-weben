package com.codecool.controller;

import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.Mentor;
import com.codecool.model.Student;
import com.codecool.util.LogIn;
import com.codecool.view.MentorView;

import java.util.ArrayList;
import java.util.List;

public class MentorController {
    private StudentDAO studentDAO;
    private MentorView mentorView;
    private LogIn logIn;
    private StudentController studentController ;

    public MentorController(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
        this.logIn  = new LogIn();
        this.studentController = new StudentController();
        this.mentorView = new MentorView();
    }

    public void start(){
        performAction();
    }

    public Mentor createNewMentor(){
        Mentor mentor = null;
        String id;
        String userName;
        String password;
        String name;
        String surname;
        int group;
        mentorView.print("Enter id: ");
        id = mentorView.input();
        do {
            mentorView.print("Enter user name: ");
            userName = mentorView.input();
        }while (logIn.doNotDuplicateNickNames(userName));
        mentorView.print("Enter your password: ");
        password = mentorView.input();
        mentorView.print("Enter your name: ");
        name = mentorView.input();
        mentorView.print("Enter your surname: ");
        surname = mentorView.input();
        mentor = new Mentor(id,userName,password,name,surname,3);
        return mentor;
    }
    public String nickToRemove(){
        String nick = "";
        mentorView.print("Enter mentor's nick to delete it");
        nick = mentorView.input();
        return nick;
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
                    studentDAO.addStudent(studentController.createNewStudent());
                    break;
                case "7":
                    studentDAO.removeStudent(studentController.nickToRemove());
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
        List<Student> studentsData = new ArrayList<>();
        studentsData = studentDAO.convertToStudent();
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
