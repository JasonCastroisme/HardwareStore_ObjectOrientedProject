package com.company;

/**
 * This class is a simple representation of the users in customer list
 * @author Jason Castro
 */


public class Transactions {

	String itemID;
	String date;
	int saleQuantity;
	int customerID;
	int employeeID;

	/**
	 * This constructor initializes the transaction object. The constructor provides no
	 * user input validation. That should be handled by the class that creates a
	 * transaction object.
	 *
	 * itemID a (String) that represents the ID
	 *                 random string of length 5 â€“ can contain letters and numbers
	 *
	 * Date(string) that represents the name.
	 *
	 * saleQuantity(int) that represents the sale quantity.
	 *
	 * customerID(int) that represents the customer ID
	 *
	 * employeeID(int) that represents the employee ID
	 *
	 */

	public Transactions(String itemID, String date, int saleQuantity, int customerID, int employeeID)
	{
		this.itemID = itemID;
		this.date = date;
		this.saleQuantity = saleQuantity;
		this.customerID = customerID;
		this.employeeID = employeeID;
	}

	/**
	 * This method sets the ItemID.
	 *
	 */
	public void setItemID(){
		this.itemID = itemID;
	}

	/**
	 * This method sets the date
	 *
	 */
	public void setDate(){
		this.date = date;
	}

	/**
	 * This method sets the sale quantity
	 *
	 */
	public void setSaleQuantity(){
		this.saleQuantity = saleQuantity;
	}

	/**
	 * This method sets the customer ID
	 *
	 */
	public void setCustomerID(){
		this.customerID = customerID;
	}

	/**
	 * This method sets the Employee ID
	 *
	 */
	public void setEmployeeID(){
		this.employeeID = employeeID;
	}

	/**
	 * This method gets the item ID
	 * returns: itemID
	 *
	 */
	public String getItemID()
	{
		return itemID;
	}

	/**
	 * This method gets the date
	 * returns: date
	 *
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * This method gets the sale Quantity
	 * returns: sale quantity
	 *
	 */
	public int getSaleQuantity()
	{
		return saleQuantity;
	}

	/**
	 * This method gets the customer ID
	 * returns: Customer ID
	 *
	 */
	public int getCustomerID()
	{
		return customerID;
	}

	/**
	 * This method gets the employeeID
	 * returns: employeeID
	 *
	 */
	public  int getEmployeeID()
	{
		return employeeID;
	}
}
