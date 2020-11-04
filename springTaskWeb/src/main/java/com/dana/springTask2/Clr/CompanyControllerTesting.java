package com.dana.springTask2.Clr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.dana.springTask2.Bean.Employee;


@Component
@Order(2)
public class CompanyControllerTesting implements CommandLineRunner {


	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		
		Employee employee1 = new Employee("Daniel Ram", 30000);
		Employee employee2 = new Employee("Leo Hermon", 15000);
		
		System.out.println("---------add employee---------");
		System.out.println(restTemplate.postForEntity("http://localhost:8080/company/add", employee1, String.class));
		System.out.println(restTemplate.postForEntity("http://localhost:8080/company/add", employee2, String.class));
		
		System.out.println("---------get one employee---------");
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "3");
		System.out.println(restTemplate.getForObject("http://localhost:8080/company/get-single/{id}", String.class, params));
		
		System.out.println("---------get all employees---------");
		ResponseEntity<String> res = restTemplate.getForEntity("http://localhost:8080/company/get-all-employees", String.class);
		System.out.println(res);
		
		System.out.println("---------get employees by name---------");
		params.put("name", "Kobi Shasha");
		System.out.println(restTemplate.getForObject("http://localhost:8080/company/findByName/{name}", String.class, params));
		
	}
	
	
}
