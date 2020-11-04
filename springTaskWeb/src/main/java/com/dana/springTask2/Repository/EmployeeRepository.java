package com.dana.springTask2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dana.springTask2.Bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String name);
}
