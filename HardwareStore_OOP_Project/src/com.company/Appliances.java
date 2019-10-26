package com.company;


/**
 * This class is a simple representation of the items in the appliances list
 * @author Jason Castro
 */



public class Appliances extends Item
{
	String type;


	/**
	 * This constructor initializes the item object. The constructor provides no
	 * user input validation. That should be handled by the class that creates a
	 * item object.
	 *
	 * id a (String) that represents the ID
	 *                 random string of length 5 â€“ can contain letters and numbers
	 *
	 * name(string) that represents the name.
	 *
	 * brand(string) that represents the brand.
	 *
	 * quantity (int) that represents the quantity
	 *
	 * price(double) that represents the price
	 *
	 * type(string) that represents the type of appliance
	 * 					Refrigerators, Washers&Dryers, Ranges&Ovens, Small Appliances
	 */

	public Appliances(String id, String name, String brand, int quantity, double price, String type)
	{
		super(id, name, brand, quantity, price);
		this.type = type;
	}

	/**
	 * This method sets the appliance's type.
	 *
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * This method gets the appliance's type
	 * Returns: type
	 *
	 */
	public String getType()
	{
		return type;
	}
}