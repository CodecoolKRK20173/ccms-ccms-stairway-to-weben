package com.codecool.dao;

import com.codecool.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDAO {

    List<Student> getListOfStudents();
    Map<String, Integer> getGrades();
    List<Student> getAddresses();
    List<Student> getListOfStudentsByGroup();
    List<Student> changeGrade();
    List<Student> getListOfAttendance();
    List<Student> addStudentToGroupClass();
    List<Student> addStudent();
    List<Student> removeStudent();
    List<Student> editStudent();
    List<Student> showListOfGrades();
}
