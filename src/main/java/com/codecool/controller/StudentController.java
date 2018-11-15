package com.codecool.controller;

import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.model.Student;
import com.codecool.util.LogIn;
import com.codecool.view.StudentView;

import java.util.List;
import java.util.Map;

public class StudentController {
    private StudentDAO studentDAO;
    private StudentView studentView = new StudentView();
    private LogIn logIn = new LogIn();
    
    public StudentController(){
        this.studentDAO = new StudentDAOFromCSV();
    }


    public void switchStudentMenu() {
        String choice;
        boolean imLogged = true;
        while(imLogged){
            studentView.showStudentMenu();
            choice=studentView.input();
            switch(choice){
                case "1":
                    showMyGradesView();
                    studentView.input();
                    break;
                case "2":
                    studentView.print("Enter assignment to evaluation: ");
                    String name = studentView.input();
                    String answer = "";
                    try{
                        answer = chooseAssignments(name);}
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    studentView.print("Your assignment to evaluation: " + answer);
                    studentView.input();
                    break;
                case "3":
                    showAvailableAssaignmentsView();
                    studentView.input();
                    break;
                case "4":
                    getAverageFromMyGradesView();
                    studentView.input();
                    break;
                case "0":
                    imLogged = false;
                    break;
            }
        }
    }
    public Student createNewStudent(){
        Student student = null;
        String id;
        String login;
        String password;
        String name;
        String surname;
        String group;
        String address;
        String email;
        studentView.print("Enter id: ");
        id = studentView.input();
        do {
            studentView.print("Enter user name: ");
            login = studentView.input();
        }while (logIn.doNotDuplicateNickNames(login));
        studentView.print("Enter your password: ");
        password = studentView.input();
        studentView.print("Enter your name: ");
        name = studentView.input();
        studentView.print("Enter your surname: ");
        surname = studentView.input();
        studentView.print("Enter your address: ");
        address = studentView.input();
        studentView.print("Enter your email: ");
        email = studentView.input();
        student = new Student(id,login,password,name,surname,"4",address,email);
        return student;
    }

    public Map<String, Integer> showMyGrades(){
        Map<String, Integer> myGrades = this.studentDAO.getGradesForYourAssignments();

        return myGrades;
    }

    public String nickToRemove(){
        String nick = "";
        studentView.print("Enter student's nick to delete it");
        nick = studentView.input();
        return nick;
    }

    public List<String> showAvailableAssignments(){
        List<String> listOfAvailableAssignments = this.studentDAO.getNotEvaluatedAssignments();

        return listOfAvailableAssignments;
    }

    public String chooseAssignments(String name) throws Exception {
        List<String> listOfAvailableAssignments = this.studentDAO.getNotEvaluatedAssignments();

        for(String element: listOfAvailableAssignments){
            if(element.toLowerCase().contains(name.toLowerCase())){
                return element;
            }
        }
        throw new Exception("Assignment is not available or doesn't exist");
    }

    public double getAverageFromGrades(){
        Map<String, Integer> myGrades = this.studentDAO.getGradesForYourAssignments();

        int sum = 0;

        for (Map.Entry<String, Integer> entry : myGrades.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            sum += value;
        }
        return sum / myGrades.size();
    }
    public void showMyGradesView(){
        Map<String, Integer> mapGrades = showMyGrades();

        for (Map.Entry<String, Integer> entry : mapGrades.entrySet()) {
            studentView.print(entry.getKey() + " - " + entry.getValue() + " grade");
        }
    }

    public void showAvailableAssaignmentsView(){
        List<String> list = showAvailableAssignments();

        for(String element: list){
            studentView.print(element);

        }
    }

    public void getAverageFromMyGradesView(){
        double average = getAverageFromGrades();
        studentView.print("Average of your grades: " + average);
    }
}
