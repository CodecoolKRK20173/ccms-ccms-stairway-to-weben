package com.codecool.dao;

import com.codecool.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAOFromCSV implements StudentDAO{

    private FileParser fileParser;
    private FileParser fileParserForMap;
    private Student student;
    private List<Student> listOfStudents;
    private List<Student> listOfAddresses;
    private List<Student> listOfStudentsByGroup;
    private List<Student> listOfBaseStudents;
    private List<Student> listOfAddStudent;
    private Map<String, Integer> hashMapOfGradesWithAssignments;
    private List<String> listWithNotEvaluatedAssignments;

    public StudentDAOFromCSV(){
        this.listOfStudents = new ArrayList<>();
        this.listOfAddresses = new ArrayList<>();
        this.listOfStudentsByGroup = new ArrayList<>();
        this.listOfBaseStudents = new ArrayList<>();
        this.listOfAddStudent = new ArrayList<>();
        this.hashMapOfGradesWithAssignments = new HashMap<>();
        this.listWithNotEvaluatedAssignments = new ArrayList<>();
        this.student = new Student();
        this.fileParser = new FileParser("/home/hubert/Pulpit/ccms-ccms-stairway-to-weben/src/main/java/com/codecool/student.csv");
        this.fileParserForMap = new FileParser("/home/hubert/Pulpit/ccms-ccms-stairway-to-weben/src/main/java/com/codecool/assignment.csv");
    }

    public List<Student> convertToStudent() {
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result) {
            listOfBaseStudents.add(new Student(element[0], element[1], element[2], element[3], element[4], element[5], element[6], element[7]));
        }
        return listOfBaseStudents;
    }

    public List<Student> getListOfStudents(){
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result){
            listOfStudents.add(new Student(element[0], "", "", element[3], element[4], element[5], "", ""));
        }
        return listOfStudents;
    }

    public List<Student> getAddresses(){
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result){
            listOfAddresses.add(new Student(element[0], "", "", element[3], element[4], "", element[6], ""));
        }
        return listOfAddresses;
    }

    public List<Student> getListOfStudentsByGroup(String groupClass){
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result){
            if(groupClass.equals(element[7])){
                listOfStudentsByGroup.add(new Student(element[0], "", "", element[3], element[4], element[5], "", element[7]));
            }
        }
        return listOfStudentsByGroup;
    }

    public List<Student> removeStudent(String id){
        List<Student> list = convertToStudent();

        for(Student student: list){
            if(student.getId().equalsIgnoreCase(id)){
                list.remove(student);
                break;
            }
        }
        return list;
    }

    public List<Student> editStudent(String idOld, String idNew, String login, String password, String name, String surname, String groupClass, String address, String email){
        List<Student> list = convertToStudent();

        for(Student student: list){
            if(student.getId().equalsIgnoreCase(idOld)){
                list.remove(student);
                break;
            }
        }
        list.add(new Student(idNew, login, password, name, surname, groupClass, address, email));
        return list;
    }

    public Map<String, Integer> getGradesForYourAssignments(){
        List<String[]> result = fileParserForMap.listOfUsers();

        for(String[] element: result){
            if(element[1].equalsIgnoreCase("0")){
                continue;
            }
            hashMapOfGradesWithAssignments.put(element[0], Integer.parseInt(element[1]));
        }
        return hashMapOfGradesWithAssignments;
    }

    public List<String> getNotEvaluatedAssignments(){
        List<String[]> result = fileParserForMap.listOfUsers();

        for(String[] element: result){
            if(element[1].equalsIgnoreCase("0")){
                listWithNotEvaluatedAssignments.add(element[0]);
            }
        }
        return listWithNotEvaluatedAssignments;
    }
}
