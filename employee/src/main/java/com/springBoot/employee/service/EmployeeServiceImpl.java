package com.springBoot.employee.service;

import com.springBoot.employee.exception.UserAlreadyExistsException;
import com.springBoot.employee.exception.UserNotFoundException;
import com.springBoot.employee.models.Employee;
import com.springBoot.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public static Logger logUser = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addUser(Employee employee) throws UserAlreadyExistsException {
        if(this.employeeRepository.existsByUserName(employee.getUserName())){

            logUser.error("User already exist");
            throw new UserAlreadyExistsException("Username already exist");
        }
        else {
            return employeeRepository.save(employee);
        }

    }

    @Override
    public List<Employee> viewUser() throws UserNotFoundException {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.equals(null)){
            throw new UserNotFoundException("User not found");
        }
        else {
            return employees;
        }

    }

    @Override
    public Employee viewUser(String id) throws UserNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public String deleteUser(String id) throws UserNotFoundException{
        Optional<Employee> employee = employeeRepository.findById(id);
        String message;
        if(employee.isPresent()){
            employeeRepository.deleteById(id);
            message = "User deleted Successfully";
            logUser.error(message);
        }
        else{
            message = "User not found";
            logUser.error(message);
            throw new UserNotFoundException(message);
        }

        return message;
    }

    @Override
    public Employee updateUser(Employee employee) throws UserNotFoundException {
        Optional<Employee> u = employeeRepository.findById(employee.getId());
        if(u.isPresent()){
            return employeeRepository.save(employee);
        }
        else {
            logUser.error("Cannot update user doesnot exist");
            throw new UserNotFoundException("Cannot update user doesnot exist");
        }

    }

    @Override
    public List<Employee> aboveSalary(double salary){
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> emplS = employees.stream().filter(Employee->Employee.getSalary()>salary).collect(Collectors.toList());
        return emplS;
    }
}
