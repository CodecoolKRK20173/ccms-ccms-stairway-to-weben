package com.codecool;

import com.codecool.controller.MasterController;
import com.codecool.dao.MentorDAO;
import com.codecool.dao.MentorDAOFromCSV;

public class Main {

    public static void main(String[] args) {
//        MentorDAO mentorDAO = new MentorDAOFromCSV();
//        mentorDAO.createMentor();
//        mentorDAO.deleteMentor();
        MasterController masterController = new MasterController();
        masterController.start();
    }
}
////java -cp target/ccms-ccms-stairway-to-weben.jar com.codecool.Main
