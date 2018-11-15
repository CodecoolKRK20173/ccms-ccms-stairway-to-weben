package com.codecool.view;

import java.util.Scanner;

public class StudentView {
    public void printUnderConstruction() {
        System.out.println("Under Construction.");
    }

    private Scanner scanner = new Scanner(System.in);
    ;

    public void showStudentMenu() {
        System.out.println("1. Show my grades");
        System.out.println("2. Choose assignment to evaluation");
        System.out.println("3. Display available assignments");
        System.out.println("4. Show average of my grades");
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


}
