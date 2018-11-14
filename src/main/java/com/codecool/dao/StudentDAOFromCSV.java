package com.codecool.dao;

import com.codecool.model.Student;
import com.codecool.util.LogIn;
import com.codecool.view.StudentView;

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
    private List<String []> listOfArrays;
    private List<Student> listOfStudentsByGroup;
    private List<Student> listOfBaseStudents;
    private List<Student> listOfAddStudent;
    private Map<String, Integer> hashMapOfGradesWithAssignments;
    private List<String> listWithNotEvaluatedAssignments;
    private StudentView studentView;
    private LogIn logIn = new LogIn();

    public StudentDAOFromCSV(){
        this.studentView  = new StudentView();
        this.listOfStudents = new ArrayList<>();
        this.listOfAddresses = new ArrayList<>();
        this.listOfStudentsByGroup = new ArrayList<>();
        this.listOfBaseStudents = new ArrayList<>();
        this.listOfAddStudent = new ArrayList<>();
        this.hashMapOfGradesWithAssignments = new HashMap<>();
        this.listWithNotEvaluatedAssignments = new ArrayList<>();
        this.student = new Student();
        this.fileParser = new FileParser("src/main/java/com/codecool/student.csv");
        this.fileParserForMap = new FileParser("src/main/java/com/codecool/assignment.csv");
    }

    @Override
    public List<Student> convertToStudent() {

        List<String[]> result = this.fileParser.listOfUsers();
        this.listOfBaseStudents = new ArrayList<>();
        for(String[] element: result) {
            listOfBaseStudents.add(new Student(element[0], element[1], element[2], element[3], element[4], element[5], element[6], element[7]));
        }
        return listOfBaseStudents;
    }

    @Override
    public List<Student> getListOfStudents(){
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result){
            listOfStudents.add(new Student(element[0], "", "", element[3], element[4], element[5], "", ""));
        }
        return listOfStudents;
    }

    @Override
    public List<Student> getAddresses(){
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result){
            listOfAddresses.add(new Student(element[0], "", "", element[3], element[4], "", "", element[7]));
        }
        return listOfAddresses;
    }

    @Override
    public List<Student> getListOfStudentsByGroup(String groupClass){
        List<String[]> result = this.fileParser.listOfUsers();

        for(String[] element: result){
            if(groupClass.equals(element[7])){
                listOfStudentsByGroup.add(new Student(element[0], "", "", element[3], element[4], element[5], "", element[7]));
            }
        }
        return listOfStudentsByGroup;
    }
    public String toString(Student student){
        String newStudent = "";
        newStudent += student.getId();
        newStudent += "|";
        newStudent += student.getUserName();
        newStudent += "|";
        newStudent += student.getPassword();
        newStudent += "|";
        newStudent += student.getName();
        newStudent += "|";
        newStudent += student.getSurname();
        newStudent += "|";
        newStudent += "4";
        newStudent += "|";
        newStudent += student.getAddress();
        newStudent += "|";
        newStudent += student.getEmail();
        newStudent += "|";
        return  newStudent;
    }

    @Override
    public void addStudent(){
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
        String toStringMentor = toString(student);
        fileParser.addNewRecord(toStringMentor);
    }

    @Override
    public void removeStudent() {
        String nick = "";
        studentView.print("Enter student's nick to delete it");
        nick = studentView.input();
        this.listOfArrays = fileParser.listOfUsers();
        for (int i = 0; i <listOfArrays.size() ; i++) {
            if(listOfArrays.get(i)[1].equals(nick)){
                listOfArrays.remove(i);
            }
        }
        fileParser.saveUploadedListInFile(listOfArrays);


    }

    @Override
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

    @Override
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

    @Override
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
