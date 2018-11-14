package com.codecool;

import com.codecool.dao.MentorDAO;
import com.codecool.dao.MentorDAOFromCSV;

public class Main {

    public static void main(String[] args) {
        MentorDAO mentorDAO = new MentorDAOFromCSV();
        mentorDAO.createMentor();
        mentorDAO.deleteMentor();
    }
}
