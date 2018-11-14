package com.codecool.view;

import com.codecool.model.Mentor;

import java.util.Scanner;

public class MentorView {
    public void showMentorMenu(){
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
    public void print(String text){
        System.out.println(text);
    }
    public String input(){
        String input = "";
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        return  input;
    }
    public void printUnderConstruction(){
        System.out.println("Under Construction.");
    }
}
