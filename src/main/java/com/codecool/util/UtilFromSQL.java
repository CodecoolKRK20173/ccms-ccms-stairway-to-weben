package com.codecool.util;

import com.codecool.dao.DataBaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilFromSQL extends Util{

    private DataBaseConnector dataBaseConnector = new DataBaseConnector();

    protected boolean checkIfIdIsUnique(String id) {

        try {
            ResultSet rs = dataBaseConnector.query("SELECT id FROM Users WHERE id = \"" + id + "\"");
            if(!rs.next()) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
