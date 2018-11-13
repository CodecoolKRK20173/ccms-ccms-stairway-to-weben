package com.codecool.dao;

import com.codecool.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private FileParser fileParser;
    private Student student;
    private List<Student> listOfStudents;
    private List<Student> listOfAddresses;
    private List<Student> listOfStudentsByGroup;
    private List<Student> listOfBaseStudents;
    private List<Student> listOfAddStudent;

    public StudentDAO(){
        this.listOfStudents = new ArrayList<>();
        this.listOfAddresses = new ArrayList<>();
        this.listOfStudentsByGroup = new ArrayList<>();
        this.listOfBaseStudents = new ArrayList<>();
        this.listOfAddStudent = new ArrayList<>();
        this.student = new Student();
        this.fileParser = new FileParser("/home/hubert/Pulpit/ccms-ccms-stairway-to-weben/src/main/java/com/codecool/student.csv");
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
            listOfStudents.add(new Student(element[0], "", "", element[3], element[4], "", "", element[7]));
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
                listOfStudentsByGroup.add(new Student(element[0], "", "", element[3], element[4], "", "", element[7]));
            }
        }
        return listOfStudentsByGroup;
    }

    public List<Student> addStudentToGroupClass(String id, String login, String password, String name, String surname, String email, String address, String groupClass){
        List<Student> listAfterConverting = convertToStudent();

        listAfterConverting.add(new Student(id, login, password, name, surname, email, address, groupClass));

        return listAfterConverting;
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

    public List<Student> editStudent(String idOld, String idNew, String login, String password, String name, String surname, String email, String address, String groupClass){
        List<Student> list = convertToStudent();

        for(Student student: list){
            if(student.getId().equalsIgnoreCase(idOld)){
                list.remove(student);
                break;
            }
        }
        list.add(new Student(idNew, login, password, name, surname, email, address, groupClass));
        return list;
    }

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();


    }
}
