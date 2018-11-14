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

    private StudentDAOFromCSV studentDAOFromCSV;
    private StudentController studentController;
    private Scanner scanner;

    public StudentView(){
        this.studentDAOFromCSV = new StudentDAOFromCSV();
        this.studentController = new StudentController();
        this.scanner = new Scanner(System.in);
    }

    public void showStudentMenu(){
        System.out.println("1. Show my grades");
        System.out.println("2. Choose assignment to evaluation");
        System.out.println("3. Display available assignments");
        System.out.println("4. Show average of my grades");
        System.out.println("0. Exit from menu");
    }

    public void switchStudentMenu(int choice) throws Exception {
        switch(choice){
            case 1:
                showMyGradesView();
                break;
            case 2:
                System.out.print("Enter assignment to evaluation");
                String name = scanner.nextLine();
                String answer = studentController.chooseAssignments(name);
                System.out.println("Your assignment to evaluation: " + answer);
                break;
            case 3:
                showAvailableAssaignmentsView();
                break;
            case 4:
                getAverageFromMyGradesView();
                break;
            case 0:
                // TO DO
                break;
        }
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

    public void showMyGradesView(){
        Map<String, Integer> mapGrades = studentController.showMyGrades();

        for (Map.Entry<String, Integer> entry : mapGrades.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " grade");
        }
    }

    public void showAvailableAssaignmentsView(){
        List<String> list = studentController.showAvailableAssignments();

        for(String element: list){
            System.out.println(element);
        }
    }

    public void getAverageFromMyGradesView(){
        double average = studentController.getAverageFromGrades();
        System.out.println("Average of your grades: " + average);
    }

    //-------------- FOR MENTOR -----------------

    public void showAllInformationAboutStudents(){
        List<Student> result = studentDAOFromCSV.convertToStudent();

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showListOfStudents(){
        List<Student> result = studentDAOFromCSV.getListOfStudents();

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showAddressesOfStudents(){
        List<Student> result = studentDAOFromCSV.getAddresses();

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showStudentInSpecifiedGroup(){
        System.out.print("Enter group class: ");
        String groupClass = scanner.next();
        List<Student> result = studentDAOFromCSV.getListOfStudentsByGroup(groupClass);

        for(Student student: result){
            System.out.println(student);
        }
    }

    public void showSystemOfEditStudent(){
        System.out.print("Enter id of record: ");
        String idOld = scanner.next();
        System.out.print("Enter new id: ");
        String idNew = scanner.next();
        System.out.print("Enter new login: ");
        String login = scanner.next();
        System.out.print("Enter new password: ");
        String password = scanner.next();
        System.out.print("Enter new name: ");
        String name = scanner.next();
        System.out.print("Enter new surname: ");
        String surname = scanner.next();
        System.out.print("Enter new group class: ");
        String groupClass = scanner.next();
        System.out.print("Enter new address: ");
        String address = scanner.next();
        System.out.print("Enter new email: ");
        String email = scanner.next();

        List<Student> result = studentDAOFromCSV.editStudent(idOld, idNew, login, password, name, surname, groupClass, address, email);

        for(Student student: result){
            System.out.println(student);
        }
    }
}
