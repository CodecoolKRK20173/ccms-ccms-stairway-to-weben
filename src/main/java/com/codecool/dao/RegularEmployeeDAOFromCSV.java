package com.codecool.dao;

import com.codecool.model.RegularEmployee;
import com.codecool.util.LogIn;
import com.codecool.view.RegularEmployeeView;

import java.util.ArrayList;
import java.util.List;

public class RegularEmployeeDAOFromCSV implements RegularEmployeeDAO {

    private List<String[]> usersList;
    private String REGULAR_EMPLOYEE_GROUP = "2";
    private int REGULAR_EMPLOYEE_GROUP_NUMBER = 2;
    private FileParser fileParser;
    private RegularEmployeeView regularEmployeeView = new RegularEmployeeView();
    private LogIn logIn = new LogIn();

    public RegularEmployeeDAOFromCSV(){
        fileParser = new FileParser("Workers");
        usersList = fileParser.listOfUsers();
    }

    @Override
    public RegularEmployee getRegularEmployee(String id) {
        String userName;
        String password;
        String name;
        String surname;
        int group = REGULAR_EMPLOYEE_GROUP_NUMBER;

        for (String[] user : usersList) {
            if(user[0].equals(id) && user[5].equals(REGULAR_EMPLOYEE_GROUP)){
                userName = user[1];
                password = user[2];
                name = user[3];
                surname = user[4];
                RegularEmployee regularEmployee = new RegularEmployee(id, userName, password, name, surname, group);
                return regularEmployee;
            }
        }
        throw new IllegalArgumentException("There is no Regular Employee with given ID.");
    }

    @Override
    public List<RegularEmployee> getListOfEmployees() {
        List<RegularEmployee> regularEmployees = new ArrayList<>();

        for (String[] user : usersList) {
            if(user[5].equals(REGULAR_EMPLOYEE_GROUP)){
                String id = user[0];
                String userName = user[1];
                String password = user[2];
                String name = user[3];
                String surname = user[4];
                int group = REGULAR_EMPLOYEE_GROUP_NUMBER;
                regularEmployees.add(new RegularEmployee(id, userName, password, name, surname, group));
            }
        }
        return regularEmployees;
    }

    @Override
    public void createEmployee() {
        RegularEmployee regularEmployee = null;
        String id;
        String userName;
        String password;
        String name;
        String surname;
        int group;
        regularEmployeeView.print("Enter id: ");
        id = regularEmployeeView.input();
        do {
            regularEmployeeView.print("Enter user name: ");
            userName = regularEmployeeView.input();
        }while (logIn.doNotDuplicateNickNames(userName));
        regularEmployeeView.print("Enter your password: ");
        password = regularEmployeeView.input();
        regularEmployeeView.print("Enter your name: ");
        name = regularEmployeeView.input();
        regularEmployeeView.print("Enter your surname: ");
        surname = regularEmployeeView.input();
        regularEmployee = new RegularEmployee(id,userName,password,name,surname,2);
        String toStringRegularEmployee = toString(regularEmployee);
        fileParser.addNewRecord(toStringRegularEmployee);
    }
    public String toString(RegularEmployee regularEmployee){
        String newEmployee = "";
        newEmployee += regularEmployee.getId();
        newEmployee += "|";
        newEmployee += regularEmployee.getUserName();
        newEmployee += "|";
        newEmployee += regularEmployee.getPassword();
        newEmployee += "|";
        newEmployee += regularEmployee.getName();
        newEmployee += "|";
        newEmployee += regularEmployee.getSurname();
        newEmployee += "|";
        newEmployee += "3";
        newEmployee += "|";
        return  newEmployee;
    }

    private String[] createRecordFromEmployee(RegularEmployee employee) {
        String[] newEmployee = new String[6];
        newEmployee[0] = employee.getId();
        newEmployee[1] = employee.getUserName();
        newEmployee[2] = employee.getPassword();
        newEmployee[3] = employee.getName();
        newEmployee[4] = employee.getSurname();
        newEmployee[5] = REGULAR_EMPLOYEE_GROUP;
        return newEmployee;
    }

    @Override
    public void deleteEmployee(String userName) {
        for (int i = 0; i < usersList.size(); i++) {
            if(usersList.get(i)[1].equals(userName)){
                usersList.remove(i);
                break;
            }
        }
        fileParser.saveUploadedListInFile(usersList);
    }

    @Override
    public void updateEmployee(RegularEmployee employee) {

        for (int i = 0; i < usersList.size(); i++) {
            if(usersList.get(i)[1].equals(employee.getUserName())){
                usersList.set(i, createRecordFromEmployee(employee));
                break;
            }
        }
        fileParser.saveUploadedListInFile(usersList);
    }
}