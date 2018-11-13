package com.codecool;

import com.codecool.dao.MentorDAOFromCSV;

public class Main {

    public static void main(String[] args) {
        MentorDAOFromCSV mentorDAOFromCSV = new MentorDAOFromCSV();
        mentorDAOFromCSV.createMentor();
        mentorDAOFromCSV.deleteMentor();
    }
}
