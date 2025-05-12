package com.myapp.service;

import java.util.List;

import com.myapp.entity.Employee;

public interface EmployeeManager {
	public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
