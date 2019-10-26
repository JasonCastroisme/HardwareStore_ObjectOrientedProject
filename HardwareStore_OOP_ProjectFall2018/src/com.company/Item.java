package com.company;

/**
 * This class is a simple representation of the items in inventory
 * @author Jason Castro
 */

public class Item {

	private String id;
	private String name;
	private String category;
	private int quantity;
	private double price;
	private String type;

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
	 * category(string) that represents the category.
	 *                 Door&Window, Cabinet& Furniture, Fasteners, Structural, Other.
	 *
	 * quantity(int) that represents the quantity
	 *
	 * price(double) that represents the price
	 */
	public Item(String id, String name, String category, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * This method sets the item's id.
	 *
	 */
	public void setID(String id){
		this.id = id;
	}

	/**
	 * This method sets the item's name.
	 *
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * This method sets the item's category.
	 *
	 */
	public void setCategory(String category){
		this.category = category;
	}

	/**
	 * This method sets the item's quantity.
	 *
	 */
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	/**
	 * This method sets the item's price.
	 *
	 */
	public void setPrice(double price){
		this.price = price;
	}

	/**
	 * This method returns the item's id.
	 *
	 * return: the ID number of the item.
	 */
	public String getID(){
		return id;
	}

	/**
	 * This method returns the item's name.
	 *
	 * return: the name of the item.
	 */
	public String getName(){
		return name;
	}

	/**
	 * This method returns the item's category.
	 *
	 * return: the category of the item.
	 */
	public String getCategory(){
		return category ;
	}

	/**
	 * This method returns the item's quantity.
	 *
	 * return: the quantity of the item.
	 */
	public int getQuantity(){
		return quantity;
	}

	/**
	 * This method returns the item's id number.
	 *
	 * return: the price of the item.
	 */
	public double getPrice(){
		return price;
	}

	/**
	 * This method sets the item's type.
	 *
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * This method returns the item's type.
	 *
	 * return: the type of the item.
	 */
	public String getType(){
		return type;
	}


}
