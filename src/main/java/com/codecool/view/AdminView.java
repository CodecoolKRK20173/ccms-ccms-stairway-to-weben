package com.codecool.view;

import java.util.Scanner;

public class AdminView {
    public void showAdminMenu(){
        System.out.println("1. Show list of employees");
        System.out.println("2. Show list of mentors");
        System.out.println("3. Create employee");
        System.out.println("4. Create mentor");
        System.out.println("5. Fire employee");
        System.out.println("6. Fire mentor");
        System.out.println("0. Log out");
    }
    public void printUnderConstruction(){
        System.out.println("Under Construction.");
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
}
