package com.codecool.dao;

import com.codecool.model.RegularEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegularEmployeeDAOFromSQL implements RegularEmployeeDAO {

    private DataBaseConnector dataBaseConnector = new DataBaseConnector();

    @Override
    public RegularEmployee getRegularEmployee(String id) {
        return null;
    }

    @Override
    public List<RegularEmployee> getListOfEmployees() {
        ResultSet rs = dataBaseConnector.query("SELECT ID, UserName, Password, Surname, Group FROM Users GROUP BY Group WHERE Group = 2");
        List<RegularEmployee> listOfEmployees = new ArrayList<>();
        try {
            while (rs.next()) {

                String id = rs.getString("ID");
                String user = rs.getString("UserName");
                String password = rs.getString("Password");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                int group = rs.getInt("Group");


                RegularEmployee regularEmployee = new RegularEmployee(id, user, password, name, surname, group);
                listOfEmployees.add(regularEmployee);
            }
            return listOfEmployees;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createEmployee(RegularEmployee employee) {

    }

    @Override
    public void deleteEmployee(String userName) {

    }

    @Override
    public void updateEmployee(RegularEmployee employee) {

    }

}

