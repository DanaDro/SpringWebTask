package com.dana.springTask2.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dana.springTask2.Bean.Employee;
import com.dana.springTask2.Bean.EmployeeList;
import com.dana.springTask2.Bean.Job;
import com.dana.springTask2.Repository.EmployeeRepository;
import com.dana.springTask2.Repository.JobRepository;

@Service
public class CompanyService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private JobRepository jobRepository;
	
	
	
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);
	}
	
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	public Employee getEmployeeById(long employeeId) {
		return employeeRepository.getOne(employeeId);
	}
	
	public List<Employee> getAllEmployeeByName(String name){
		return employeeRepository.findByName(name);
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		EmployeeList employeeLists = new EmployeeList(employees); 
		return employeeLists.getEmployees();
	}
	
	public List<Job> getAllJobs(){
		return jobRepository.findAll();
	}
	
	public List<Job> getJobsByEndDate(Date endDate){
		return jobRepository.findByEndDate(endDate);
	}
	
	public List<Job> getJobsByDates(Date startDate , Date endDate){
		return jobRepository.findByEndDateBetween(startDate, endDate);
	}
	
	public void addJob(Job job) {
		jobRepository.save(job);
	}
	
	public Job getOneJob(long id) {
		return jobRepository.getOne(id);
	}
	
	public void updateJob(Job job) {
		jobRepository.saveAndFlush(job);
	}
	
//	public List<Employee> getEmployeesFromListEmployees(){
//		List<Employee> employees = 
//		EmployeeList employeeList = new EmployeeList(employeeRepository.findAll());
//		return employeeList.getEmployees();
//	}
	
}
