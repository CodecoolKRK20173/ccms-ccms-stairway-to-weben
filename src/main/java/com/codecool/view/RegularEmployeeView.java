package com.codecool.view;

import com.codecool.model.RegularEmployee;
import com.codecool.model.Student;

import java.util.List;
import java.util.Scanner;

public class RegularEmployeeView {

    Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("Welcome!");
        System.out.println("Please choose and option: ");
        System.out.println("1. View list of students with contacts");
        System.out.println("2. Check coffee status");
        System.out.println("3. Check office supplies");
        System.out.println("4. Billing system");
        System.out.println("5. Business trips");
        System.out.println("6. Outsourcing");
        System.out.println("0. Log out");
    }

    public void printUnderConstruction() {
        System.out.println("Under Construction.");
    }

    public int getUsersChoice() {
        return scanner.nextInt();
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

    public void print(String text) {
        System.out.println(text);
    }

    public String input() {
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return input;
    }

    public void printRegularEmployeeTable(List<RegularEmployee> regularEmployeesList) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%15s %15s %15s %20s", "ID", "LOGIN", "NAME", "SURNAME");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        for (RegularEmployee regularEmployee : regularEmployeesList) {
            System.out.format("%15s %15s %15s %20s",
                regularEmployee.getId(), regularEmployee.getUserName(), regularEmployee.getName(), regularEmployee.getSurname());
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
}

