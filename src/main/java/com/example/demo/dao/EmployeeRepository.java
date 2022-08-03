package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
