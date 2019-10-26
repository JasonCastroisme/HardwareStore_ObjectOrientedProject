package com.company;


/**
 * This class is a simple representation of the users in customer list
 * @author Jason Castro
 */


public class Customer extends User
{
	private String phoneNumber;
	private String address;


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
	 * phoneNumber(string) that represents the phone number.
	 *
	 * address(string) that represents the address.
	 *
	 */

	public Customer(int ID, String firstName, String lastName, String phoneNumber, String address)
	{
		super(ID, firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	/**
	 * This method sets the customer's phone number
	 *
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * This method sets the customer's address.
	 *
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * This method gets the customer's phone number
	 * returns: phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * This method gets the address.
	 * returns:address
	 *
	 */
	public String getAddress(){
		return address;
	}

}
