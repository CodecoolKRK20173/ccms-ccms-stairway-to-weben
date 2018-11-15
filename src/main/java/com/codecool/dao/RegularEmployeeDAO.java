package com.codecool.dao;

import com.codecool.model.RegularEmployee;

import java.util.List;

public interface RegularEmployeeDAO {

    RegularEmployee getRegularEmployee(String id);

    List<RegularEmployee> getListOfEmployees();

    void createEmployee(RegularEmployee employee);

    void deleteEmployee(String userName);

    void updateEmployee(RegularEmployee employee);

}
