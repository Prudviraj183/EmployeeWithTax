package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.EmpTaxDetails;
import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmpTaxDetails empTaxDetails;
	
	@PostMapping("/addEmp")
	public Employee addEmpDetails(@RequestBody Employee emp) {
		try {
			if(emp.getPhoneNumber().isEmpty()) {
				throw new InvalidPhoneNumberException("Please Enter Minimum 10 Digit Numbers");
			}else if(emp.getPhoneNumber().length() > 10) {
				throw new InvalidPhoneNumberException("Please Enter 10 Digit Number only");
			}
		}catch(InvalidPhoneNumberException ex){
			ex.getMessage();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employeeService.saveEmployee(emp);
	}
	
	@GetMapping("/emp/{id}")
	public Employee fetchEmpDetailsById(@PathVariable int id) {
		return  employeeService.fetchEmpById(id);
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> fetchAllEmpDetails() {
		return  employeeService.fetchAllEmp();
	}
	
	@GetMapping("/empTaxDeduction/{id}")
	public EmpTaxDetails empTaxDeductionCaliculation(@PathVariable int id) {
		//Long ctc= 360 * day
		double ctc=10.0;
		Employee empDetails = fetchEmpDetailsById(id);
		empTaxDetails.setId(empDetails.getId());
		empTaxDetails.setFirstName(empDetails.getFirstName());
		empTaxDetails.setLastName(empDetails.getLastName());
		empTaxDetails.setYearlySalary((12 * empDetails.getSalary()));
		empTaxDetails.setTaxAmount(employeeService.calculateTax(empDetails.getDOJ(), empDetails.getSalary()));
		empTaxDetails.setCessAmount(employeeService.cessCalc(ctc));
;		return empTaxDetails;
	}
}
