package com.codecool.dao;

import com.codecool.model.RegularEmployee;

import java.util.List;

public interface RegularEmployeeDAO {

    RegularEmployee getRegularEmployee(int id);

    List<RegularEmployee> getListOfEmployees();

    void createEmployee(RegularEmployee employee);

    void deleteEmployee(int id);

    void updateEmployee(RegularEmployee employee);

}
