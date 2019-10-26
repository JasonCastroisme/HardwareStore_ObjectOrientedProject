package com.company;

/**
 * This class is a simple representation of the users in employee list
 * @author Jason Castro
 */

public class Employee extends User {

	private int SSN;
	private double monthlySalary;


	/**
	 * This constructor initializes the user(employee) object. The constructor provides no
	 * user input validation. That should be handled by the class that creates a
	 * user(employee) object.
	 *
	 * id a (int) that represents the ID
	 *                 random int of 5 numbers.
	 *
	 * firstName(string) that represents the first name.
	 *
	 * lastName(string) that represents the last name.
	 *
	 * SSN(int) that represents the social security number.
	 *
	 * monthlySalary(double) that represents the monthly salary.
	 *
	 */

	public Employee(int ID, String firstName, String lastName, int SSN, double monthlySalary)
	{
		super(ID, firstName, lastName);
		this.SSN = SSN;
		this.monthlySalary = monthlySalary;
	}

	/**
	 * This method sets the employee's SSN.
	 *
	 */
	public void setSSN(int SSN)
	{
		this.SSN = SSN;
	}

	/**
	 * This method sets the employee's monthly salary.
	 *
	 */
	public void setMonthlySalary(double monthlySalary)
	{
		this.monthlySalary = monthlySalary;
	}

	/**
	 * This method gets the ssn
	 * Returns: SSN
	 *
	 */
	public int getSSN(){
		return SSN;
	}

	/**
	 * This method gets the monthly salary
	 * Returns:Monthly Salary
	 *
	 */
	public double getMonthlySalary(){
		return monthlySalary;
	}

}
