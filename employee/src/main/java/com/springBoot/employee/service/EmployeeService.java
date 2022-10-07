package com.springBoot.employee.service;

import com.springBoot.employee.exception.UserAlreadyExistsException;
import com.springBoot.employee.exception.UserNotFoundException;
import com.springBoot.employee.models.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addUser(Employee employee) throws UserAlreadyExistsException;
    public List<Employee> viewUser() throws UserNotFoundException;
    public Employee viewUser(String id) throws UserNotFoundException;

    public String deleteUser(String id) throws UserNotFoundException;
    public Employee updateUser(Employee employee) throws UserNotFoundException;

    public List<Employee> aboveSalary(double salary);
}
