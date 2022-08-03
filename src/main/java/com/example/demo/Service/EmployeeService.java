package com.example.demo.Service;

import java.util.List;

import com.example.demo.Exception.EmployeeNotFountException;
import com.example.demo.entities.Employee;

public interface EmployeeService {
	public Employee Ajouter(Employee e);
	public Employee Modifier(Employee e, Long id)throws EmployeeNotFountException ;
	public void Supprimer(Long id);
	public List<Employee> ToutEmployee();
	public Employee TrouverParId(Long id) throws EmployeeNotFountException ;

}
