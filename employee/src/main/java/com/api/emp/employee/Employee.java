package com.api.emp.employee;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	/*
	•	Employee ID
	•	FirstName
	•	LastName
	•	Email
	•	PhoneNumber(May have multiple phone numbers)
	•	DOJ
	•	Salary(per month)
*/
	@Id
    @GeneratedValue
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id,
			@NotNull @Size(min = 2, message = "First name should have at least 2 characters") String fname,
			@NotNull @Size(min = 2, message = "Last name should have at least 2 characters") String lname, String eMail,
			@Size(min = 10, message = "Name should have at least 2 characters") String phoneNumber, Date dOJ,
			BigDecimal salary) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
		DOJ = dOJ;
		this.salary = salary;
	}

	@NotNull
    @Size(min = 2, message = "First name should have at least 2 characters")
    private String fname;
    
    @NotNull
    @Size(min = 2, message = "Last name should have at least 2 characters")
    private String lname;

    private String eMail;
    
   
    @Size(min = 10, message = "Name should have at least 2 characters")
    private String phoneNumber;
    
    private Date DOJ;
    
    private BigDecimal salary;
    
}
