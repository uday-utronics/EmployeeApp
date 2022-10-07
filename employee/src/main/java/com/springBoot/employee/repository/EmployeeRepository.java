package com.springBoot.employee.repository;

import com.springBoot.employee.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository  extends MongoRepository<Employee, String> {

    boolean existsByUserName(String userName);
    @Query("{userName:'?0'}")
    Employee findByUserName(String userName);
}
