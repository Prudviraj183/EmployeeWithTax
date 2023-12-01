package com.example.demo.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public Employee fetchEmpById(int id) {
		return employeeRepo.findById(id).orElse(null);
	}
	
	public List<Employee> fetchAllEmp() {
		return employeeRepo.findAll();
	}
	
	public String calculateTax(LocalDate startDate,Long salary) {
		Long totalDaysPerYear = ChronoUnit.DAYS.between(startDate, LocalDate.of(2024, 3, 21));
		Long months = totalDaysPerYear/30;//For Months Calcuations
		Long day= totalDaysPerYear % 30;//For Days counting
		Long years= totalDaysPerYear/360;
		Long tax,ctc;
		//Calculating CTC
		if(years >=1 ) {
			ctc = 12 * salary;
		}else {
			ctc= (months * salary) + (day * salary/30);
		}
		//Calculating Tax
		if(500000 >= ctc && ctc >= 250000) {
			tax = (long) (0.05 * (ctc - 250000));
			return ""+tax;
		}else if(1000000 >= ctc && ctc >= 500000) {
			tax = (long) (0.05 * (500000 - 250000) + 0.1 *(ctc-500000));
			return ""+tax;
		}else if(ctc > 1000000) {
			tax = (long) (0.05 * (500000 - 250000) + 0.1 *(1000000-500000) + 0.2 * (ctc-1000000));
			return ""+tax;
		}else {
			return "NO TAX";
		}
	}
	
	public double cessCalc(double ctc) {
		if(ctc > 2500000) {
			return ctc*0.02;
		}else {
			return ctc;
		}
	}
}
