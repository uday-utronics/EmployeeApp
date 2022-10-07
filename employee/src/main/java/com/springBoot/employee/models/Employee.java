package com.springBoot.employee.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;
    private String Name;
    private String userName;
    private String Department;
    private String Role;
    private LocalDate DOB;
    private LocalDate JoiningDate;
    private double Salary;
    private long Phone;
    private Address Address;
    private BankDetails BankDetails;


}
