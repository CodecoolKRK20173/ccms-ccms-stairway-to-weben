package com.codecool.view;

import com.codecool.model.Mentor;
import com.codecool.model.Student;

import java.util.List;
import java.util.Scanner;

public class MentorView {
    public void showMentorMenu() {
        System.out.println("1. Show list of students");
        System.out.println("2. Show grades of one student");
        System.out.println("3. Show addresses of students");
        System.out.println("4. Show list of attendance");
        System.out.println("5. Show grades of students");
        System.out.println("6. Add student");
        System.out.println("7. Remove student");
        System.out.println("8. Edit student");
        System.out.println("9. Edit list of assigments");
        System.out.println("0. Log out");
    }

    public void print(String text) {
        System.out.println(text);
    }

    public String input() {
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return input;
    }

    public void printUnderConstruction() {
        System.out.println("Under Construction.");
    }

    public void printTable(List<Student> studentsData) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %20s %20s %10s", "ID", "NAME", "SURNAME", "CONTACT", "GROUP");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        for (Student student : studentsData) {
            System.out.format("%10s %15s %20s %20s %10s",
                student.getId(), student.getName(), student.getSurname(), student.getEmail(), student.getGroup());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void printMentorTable(List<Mentor> mentorsList) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%10s %15s %20s", "ID", "NAME", "SURNAME");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        for (Mentor mentor : mentorsList) {
            System.out.format("%10s %15s %20s",
                mentor.getId(), mentor.getName(), mentor.getSurname());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
}
