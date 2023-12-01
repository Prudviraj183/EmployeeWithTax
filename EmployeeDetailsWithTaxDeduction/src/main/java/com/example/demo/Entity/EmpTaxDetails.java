package com.example.demo.Entity;

public class EmpTaxDetails {
	int id;
	String firstName;
	String lastName;
	Long yearlySalary;
	String taxAmount;
	double cessAmount;
	public EmpTaxDetails(int id, String firstName, String lastName, Long yearlySalary, String taxAmount,
			double cessAmount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(Long yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public String getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public String toString() {
		return "EmpTaxDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearlySalary="
				+ yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}
	
	
}
