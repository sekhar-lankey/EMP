package com.api.emp.taxservice;

import java.math.BigDecimal;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonProperty;


@Service
public class EmployeeTaxService {

	 
	private BigDecimal salary,taxSalary ;
	
	EmployeeTaxService()
	{
		this.salary=new BigDecimal("1000000");
		this.taxSalary=new BigDecimal("0.0");
	}
	

	protected BigDecimal calculateTax()
	{
		/*
		 * •	No Tax for <=250000
•	5% Tax for >250000 and <=500000
•	10% Tax for >500000 and <=1000000
•	20% Tax for >1000000

		
		if(salary<=250000)
		{
			taxSalary=salary;
		}
		if(salary > 250000 && salary <=500000)
		{
			
		}
		
		 */
		return taxSalary;
	}
	
}
