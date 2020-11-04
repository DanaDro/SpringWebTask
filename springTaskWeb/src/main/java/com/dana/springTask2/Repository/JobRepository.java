package com.dana.springTask2.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dana.springTask2.Bean.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

	List<Job> findByEndDate(Date endDate);
	
	List<Job> findByEndDateBetween(Date startDate, Date endDate);
}
