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
        ResultSet rs = dataBaseConnector.query("SELECT ID, UserName, Password, Name, Surname, [Group] FROM Users WHERE [Group] = 2;");
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
        String sql = "INSERT INTO Users (ID, UserName, Password, Name, Surname, [Group]) " +
            "VALUES (\"" + employee.getId() + "\", \"" + employee.getUserName() + "\", \"" + employee.getPassword() +
            "\", \"" + employee.getName() + "\", \"" + employee.getSurname() + "\", " + employee.getGroup() + ");";

        dataBaseConnector.update(sql);
    }

    @Override
    public void deleteEmployee(String userName) {
        String sql = "DELETE FROM Users WHERE UserName = \"" + userName + "\";";

        dataBaseConnector.update(sql);
    }

    @Override
    public void updateEmployee(RegularEmployee employee) {

    }

}

