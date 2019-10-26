package com.company;


/**
 * This class is a simple representation of the users in customer list
 * @author Jason Castro
 */


public class User {

	int ID;
	int SSN;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
	double monthlySalary;

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
	 *
	 */

	public User(int ID, String firstName, String lastName)
	{
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * This method sets the user's id
	 *
	 */
	public void setID(int ID){
		this.ID = ID;
	}

	/**
	 * This method sets the user's first name.
	 *
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	/**
	 * This method sets the user's last name
	 *
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	/**
	 * This method sets the users phone number
	 *
	 */
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	/**
	 * This method sets the users address
	 *
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * This method sets the employee's SSN.
	 *
	 */
	public void setSSN(int SSN){
		this.SSN = SSN;
	}

	/**
	 * This method sets the employee's monthly salary.
	 */
	public void setMonthlySalary(double monthlySalary){
		this.monthlySalary = monthlySalary;
	}

	/**
	 * This method gets the user's ID
	 * returns:ID
	 *
	 */
	public int getID(){
		return ID;
	}

	/**
	 * This method gets the user's first name.
	 * return: firstName
	 *
	 */
	public String getFirstName(){
		return firstName;
	}

	/**
	 * This method gets the user's last name.
	 * return: lastName
	 *
	 */
	public String getLastName(){
		return lastName;
	}

	/**
	 * This method gets the customer's phone number
	 * returns: phone number
	 *
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method sets the customer's address
	 * returns: address
	 */
	public String getAddress(){
		return address;
	}

	/**
	 * This method gets the employee's ssn
	 * returs:SSN
	 *
	 */
	public int getSSN(){
		return SSN;
	}

	/**
	 * This method gets the employee's monthly salary
	 * return: MonthlySalary
	 *
	 */
	public double getMonthlySalary(){
		return monthlySalary;
	}


}
