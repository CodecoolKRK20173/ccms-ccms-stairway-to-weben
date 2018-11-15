package com.codecool.view;

import java.util.Scanner;

public class MasterView {
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
