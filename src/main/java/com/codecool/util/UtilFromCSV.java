package com.codecool.util;

import com.codecool.dao.FileParser;

import java.util.List;


public class UtilFromCSV extends Util{

    private List<String[]> usersList;
    private FileParser fileParser;

    protected boolean checkIfIdIsUnique(String id) {
        fileParser = new FileParser("src/main/java/com/codecool/resources/Workers");
        usersList = fileParser.listOfUsers();

        for (String[] user : usersList) {
            if (user[0].equals(id)) {
                return false;
            }
        }
        return true;
    }
}
