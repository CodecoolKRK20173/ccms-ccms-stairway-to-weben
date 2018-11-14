package com.codecool.controller;

import com.codecool.dao.StudentDAO;
import com.codecool.dao.StudentDAOFromCSV;
import java.util.List;
import java.util.Map;

public class StudentController {
    private StudentDAO studentDAO;
    
    public StudentController(){
        this.studentDAO = new StudentDAOFromCSV();
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
            if(element.equalsIgnoreCase(name)){
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
}
