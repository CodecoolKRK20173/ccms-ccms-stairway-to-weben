package com.codecool.dao;

import com.codecool.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

    List<Student> getListOfStudents();

    List<Student> getAddresses();

    List<Student> getListOfStudentsByGroup(String groupClass);

    void removeStudent(String nick);

    List<Student> editStudent(String idOld, String idNew, String login, String password, String name, String surname, String groupClass, String address, String email);

    Map<String, Integer> getGradesForYourAssignments();

    List<String> getNotEvaluatedAssignments();

    void addStudent(Student student);

    List<Student> convertToStudent();
}
