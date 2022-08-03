package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.EmployeeNotFountException;
import com.example.demo.Service.EmployeeService;
import com.example.demo.entities.Employee;
@CrossOrigin

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;
	@PostMapping("/save")
	public Employee ajouter( @RequestBody  Employee e) {
		return service.Ajouter(e);
		
	}
	@GetMapping("/findById/{idE}")
	private Employee Trouver(@PathVariable(name="idE") Long id) throws EmployeeNotFountException {
		return service.TrouverParId(id);
	}
	@PutMapping("/update/{idE}")
	private Employee putEmplyee(@RequestBody   Employee e,@PathVariable(name="idE") Long id) throws EmployeeNotFountException {
		return service.Modifier(e, id);
	}
	@DeleteMapping("/delete/{idE}")
	private void Delete(@PathVariable(name="idE")    Long id) {
		service.Supprimer(id);	}
	@GetMapping("/getAll")
	private List<Employee> list(){
		return service.ToutEmployee();
	}

}
