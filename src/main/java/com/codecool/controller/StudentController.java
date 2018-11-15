package com.codecool.controller;

import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import com.codecool.view.StudentView;

import java.util.List;
import java.util.Map;

public class StudentController {
    private StudentDAO studentDAO;
    private StudentView studentView = new StudentView();
    
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
                    System.out.print("Enter assignment to evaluation: ");
                    String name = studentView.input();
                    String answer = "";
                    try{
                        answer = chooseAssignments(name);}
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Your assignment to evaluation: " + answer);
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

    public Map<String, Integer> showMyGrades(){
        Map<String, Integer> myGrades = this.studentDAO.getGradesForYourAssignments();

        return myGrades;
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
            System.out.println(entry.getKey() + " - " + entry.getValue() + " grade");
        }
    }

    public void showAvailableAssaignmentsView(){
        List<String> list = showAvailableAssignments();

        for(String element: list){
            System.out.println(element);

        }
    }

    public void getAverageFromMyGradesView(){
        double average = getAverageFromGrades();
        System.out.println("Average of your grades: " + average);
    }
}
