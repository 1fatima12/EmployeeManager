package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.EmployeeNotFountException;
import com.example.demo.Service.EmployeeService;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entities.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
private EmployeeRepository rep;
	@Override
	public Employee Ajouter(Employee e) {
		Employee em=new Employee();
		em=rep.save(e);
		return e;
	}

	@Override
	public Employee Modifier(Employee e, Long id) throws EmployeeNotFountException {
	
		Employee em=rep.findById(id).orElse(null);
		if(em==null) {
			throw new EmployeeNotFountException("Employee not found");
		
		}
		e.setId(em.getId());
		return rep.save(e);
	}

	@Override
	public void Supprimer(Long id) {
		rep.deleteById(id);
	}

	@Override
	public List<Employee> ToutEmployee() {
		return rep.findAll();
	}

	@Override
	public Employee TrouverParId(Long id) throws EmployeeNotFountException {
		Optional<Employee> em=rep.findById(id);
		if(em.isPresent()) {
		    return em.get();
		}else {
			throw new EmployeeNotFountException("Employee Not Found");
		}
	    
	}

}
