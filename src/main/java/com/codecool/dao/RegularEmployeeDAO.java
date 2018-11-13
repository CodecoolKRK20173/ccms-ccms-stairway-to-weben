package com.codecool.dao;

import com.codecool.model.RegularEmployee;

import java.util.List;

public interface RegularEmployeeDAO {

    RegularEmployee getRegularEmployee(String id);

    List<RegularEmployee> getListOfEmployees();

    void createEmployee();

    void deleteEmployee(String id);

    void updateEmployee(RegularEmployee employee);

}
