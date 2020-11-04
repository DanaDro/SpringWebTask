package com.dana.springTask2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dana.springTask2.Bean.Employee;
import com.dana.springTask2.Service.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyContorller {
	
	@Autowired
	private CompanyService companyService;
			
	@PostMapping("add")
	public ResponseEntity<?> addEmplpyee(@RequestBody Employee employee){
		try {
			companyService.addEmployee(employee);
			return new ResponseEntity<>("employee added succsefully - id#"+employee.getId(), HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>("cant add employee", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("get-single/{id}")
	public ResponseEntity<?> getOneEmployee(@PathVariable(name = "id") long employeeId){
		return new ResponseEntity<Employee>(companyService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	@GetMapping("findByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable(name = "name") String name){
		return new ResponseEntity<>(companyService.getAllEmployeeByName(name), HttpStatus.OK);
	}
	
	@GetMapping("get-all-employees")
	public ResponseEntity<?> getAllEmployee(){
		return new ResponseEntity<>(companyService.getAllEmployees(), HttpStatus.OK);
	}
	
}
