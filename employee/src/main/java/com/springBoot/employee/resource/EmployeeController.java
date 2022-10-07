package com.springBoot.employee.resource;

import com.springBoot.employee.models.Employee;
import com.springBoot.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/adduser")
    public Employee addUser(@RequestBody Employee employee){
        return employeeService.addUser(employee);
    }

    @GetMapping("/findall")
    public List<Employee> findAllUsers(){
        return employeeService.viewUser();
    }

    @GetMapping("/find/{id}")
    public Employee findUserById(@PathVariable String id){
        return employeeService.viewUser(id);
    }

    @PutMapping("/update")
    public Employee updateUser(@RequestBody Employee employee){
        return employeeService.updateUser(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        return employeeService.deleteUser(id);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> salaryGreaterThan(@PathVariable double salary){
        return employeeService.aboveSalary(salary);
    }

}
