package com.dana.springTask2.Clr;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dana.springTask2.Bean.Employee;
import com.dana.springTask2.Bean.Job;
import com.dana.springTask2.Service.CompanyService;
import com.dana.springTask2.utils.Headers;
import com.dana.springTask2.utils.printTable;

@Component
@Order(1)
public class CompanyServiceTesting implements CommandLineRunner {

	@Autowired
	private CompanyService companyService;

	@Override
	public void run(String... args) throws Exception {

		Headers.companyTesting();
		
		Employee e1 = new Employee("Dana Drosvit", 20000.0);
		Employee e2 = new Employee("Kobi Shasha", 35000.0);

		Job j1 = new Job("Math", Date.valueOf("2020-10-31"));
		Job j2 = new Job("Computer", Date.valueOf("2020-11-15"));
		Job j3 = new Job("Lab", Date.valueOf("2020-11-01"));
		Job j4 = new Job("Sport", Date.valueOf("2020-12-01"));
		Job j5 = companyService.getOneJob(5);
		
		Headers.employee();
		
		System.out.println("---------add employee---------");
		e1.addJob(j1);
		e1.addJob(j2);
		e2.addJob(j3);
		e2.addJob(j4);
		companyService.addEmployee(e1);
		companyService.addEmployee(e2);
		printTable.print(companyService.getAllEmployees());
		System.out.println("---------get employee by Id---------");
		printTable.print(companyService.getEmployeeById(1));
		System.out.println("---------get all employees by name---------");
		printTable.print(companyService.getAllEmployeeByName("Kobi Shasha"));
		System.out.println("---------get all employees---------");
		printTable.print(companyService.getAllEmployees());
		Headers.job();
		System.out.println("---------get all jobs---------");
		printTable.print(companyService.getAllJobs());
		System.out.println("---------get jobs by end date---------");
		printTable.print(companyService.getJobsByEndDate(Date.valueOf("2020-11-01")));
		System.out.println("---------get jobs between dates---------");
		printTable.print(companyService.getJobsByDates(Date.valueOf("2020-10-27"), Date.valueOf("2020-11-04")));
	
		e2.addJob(j5);
	}
}
