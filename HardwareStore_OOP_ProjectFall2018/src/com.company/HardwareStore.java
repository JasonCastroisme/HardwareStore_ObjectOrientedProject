package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *
 * This class handles the management of the hardware store's Item inventory. Takes in both
 * small hardware items and appliances items and manages their arraylists seperates as inventory
 * and appliances, respectively. Methods manages these arraylist inventories.
 * @author Jason Castro
 */


public class HardwareStore {


	private ArrayList<Item> inventory;
	private ArrayList<Item> appliances;


	private static HardwareStore single_instance = null;

	/*
	 *
	 *This creates the array list of inventory and appliances
	 *and starts the database for both small hardware items and appliances, respectively.
	 */
	private HardwareStore()
	{
		inventory = new ArrayList<Item>();
		appliances = new ArrayList<Item>();
		loadSmallHardwareDatabase();
		loadAppliancesDatabase();
	}

	/*
	 *
	 * This method creates the small hardware database file called "smallHardwareDatabase.dat"
	 */
	public static void createFile() throws IOException
	{
		File file = new File("smallHWDatabase.txt");
		File appliancesFile = new File("appliancesDatabase.txt");

		//Create the file
		if (file.createNewFile()) {
			System.out.println("Small Hardware Database has been created as .txt file.");
		} else {
			System.out.println("Small Hardware Database already exists as .txt file.");
		}

		if (appliancesFile.createNewFile()) {
			System.out.println("Appliances Database has been created as .txt file!");
		} else {
				System.out.println("Appliances Database already exists as .txt file.");
			}
		}

	/*
	 *
	 * Tis integer method returns size of inventory array
	 * returns: size of inventory array(int)
	 */
	public Integer getLength(ArrayList<Item> inventory){
		return HardwareStore.sharedInstance().inventory.size();
	}

	/*public void ReadObjectFromFile() {

		try {

			FileInputStream fileIn = new FileInputStream(smallHWfilepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			int size = objectIn.readInt();
			for (int i = 0; i < size; i++) {
				Item item = (Item) objectIn.readObject();
				inventory.add(item);
			}
			System.out.println("The Object has been read from the file");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/


	/*
	 *
	 * This method loads from the file smallHWdatabase and populates the inventory array.
	 */
	public void loadSmallHardwareDatabase()
	{
		File file = new File("smallHWDatabase.txt");

		try {

			Scanner readIn = new Scanner(file);

			while (readIn.hasNextLine())
			{
				String line = readIn.nextLine();

				String field[] = line.split("~");
					Item item = new Item(
							field[0],
							field[1],
							field[2],
							Integer.parseInt(field[3]),
							Double.parseDouble(field[4]));

					inventory.add(item);
				}

				readIn.close();
			}catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException: " + ex.getLocalizedMessage());
		}
	}

	/*
	 *
	 *This method loads from the file appliancesDatabase and populates the appliances array.
	 */
	public void loadAppliancesDatabase() {



		File appliancesFile = new File("appliancesDatabase.txt");
		try {

			Scanner readIn = new Scanner(appliancesFile);


			while (readIn.hasNextLine()) {
				String line = readIn.nextLine();
				String field[] = line.split("~");

				Appliances app = new Appliances(
						field[0],
						field[1],
						field[2],
						Integer.parseInt(field[3]),
						Double.parseDouble(field[4]),
						field[5]);
				appliances.add(app);
			}
			readIn.close();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException: " + ex.getLocalizedMessage());
		}
	}

	/*
	 *
	 * This method makes and returns a clone of the small hardware inventory array
	 * returns: clone of small hardware inventory :inventory.clone
	 */
	public ArrayList<Item> allInventoryItems()
	{
		return (ArrayList<Item>) inventory.clone();
	}

	/*
	 *
	 * This method makes and returns a clone of the appliances inventory array
	 * returns: clone of appliances inventory : appliances.clone
	 */
	public ArrayList<Item> allApplianceItems()
	{
		return (ArrayList<Item>) appliances.clone();
	}

	/*
	 *This method makes and returns a single instance of the hardware store,
	 * making methods and attributes accessible to other classes
	 *return: single_instance
	 */
	public static HardwareStore sharedInstance()
	{
		if (single_instance == null) {
			single_instance = new HardwareStore();
		}

		return single_instance;
	}

	/*
	 *This method searches the small hardware item list for ID that matches input
	 *Input : ID from user input
	 * Return: If True, returns Item
	 * 			If False, returns Null
	 */
	public Item itemWithID(String id)
	{
		for (Item item : inventory) {
			if (item.getID().toLowerCase().equals(id.toLowerCase())) {
				return item;
			}
		}

		return null;
	}
	/*
	 *This method searches the appliances item list for ID that matches input
	 *Input : ID from user input
	 * Return: If True, returns Item
	 * 			If False, returns Null
	 */
	public Item applianceWithID(String id)
	{
		for (Item item : appliances) {
			if (item.getID().toLowerCase().equals(id.toLowerCase())) {
				return item;
			}
		}

		return null;
	}

	/*
	 *
	 * this method removes an entire small hardware item
	 */
	public void removeItem(Item item){
		inventory.remove(item);
	}

	/*
	 *
	 * this method removes an entire appliance item
	 */
	public void removeAppliance(Item item){
		appliances.remove(item);
	}

	/*
	 *
	 *this method takes input from a method outside of the class and adds it to
	 * the small hardware item list.
	 */
	public void addItem(String ID, String name, String Category, String quantity, String price)
	{
		String field[] = new String[5];
		Item item = new Item(
				field[0] = ID,
				field[1] = name,
				field[2] = Category,
				Integer.parseInt(field[3] = quantity),
				Double.parseDouble(field[4] = price));

		try {

			int intValue = Integer.parseInt(quantity);
		}catch (NumberFormatException e) {
			System.out.println("Input is not a valid quantity");
		}

		try{
		double intValue = Double.parseDouble(price);
	}catch (NumberFormatException e) {
		System.out.println("Input is not a valid price");
		}


		inventory.add(item);
	}


	/*
	 *
	 *this method takes input from a method outside of the class and adds it to
	 * the appliance item list.
	 */
	public void addApplianceItem(String ID, String name, String brand, String quantity, String price, String type)
	{
		String field[] = new String[6];
		Appliances app = new Appliances(
				field[0] = ID,
				field[1] = name,
				field[2] = brand,
				Integer.parseInt(field[3] = quantity),
				Double.parseDouble(field[4] = price),
				field[5] = type);

		appliances.add(app);
	}

	/*
	 *This method searches the small hardware item list for name that matches input
	 *Input : name from user input(string)
	 *Return: If True, returns results
	 *
	 */
	public ArrayList<Item> itemWithName(String name)
	{
		ArrayList<Item> results = new ArrayList<Item>();

		for (Item item : inventory) {
			if (item.getName().toLowerCase().contains(name.toLowerCase()))
			{
				results.add(item);
			}
		}
		return results;
	}

	/*
	 *This method searches the app item list for name that matches input
	 *Input : name from user input(string)
	 *Return: returns results
	 *
	 */
	public ArrayList<Item> appWithName(String name)
	{
		ArrayList<Item> results = new ArrayList<Item>();

		for (Item item : appliances) {
			if (item.getName().toLowerCase().contains(name.toLowerCase()))
			{
				results.add(item);
			}
		}
		return results;
	}

	/*
	 *
	 * This method searches array list for a quantity that is below a certain integer,and returns that item
	 * Return: returns results
	 */
	public ArrayList<Item> itemBelow(int quantity)
	{
		ArrayList<Item> results = new ArrayList<Item>();

		for(Item item : inventory) {
			if(item.getQuantity() < quantity)
			{
				results.add(item);
			}
		}
		return results;
	}

	/*
	 *
	 * This method writes the arraylist of smallhardware to a "smallHardwareDatabase.dat" file
	 */

	public void writeSmallHardwaretoDatabaseText() throws IOException {
			FileWriter fileWriter = new FileWriter("smallHWDatabase.txt");
			for (int i = 0; i < inventory.size(); i++)
			{
				//String stringID =inventory.get(i).toString();
				//String stringName = inventory.get(i).toString();


				fileWriter.write(inventory.get(i).getID() + "~");
				fileWriter.write(inventory.get(i).getName() + "~");
				fileWriter.write(inventory.get(i).getCategory() + "~");
				fileWriter.write(inventory.get(i).getQuantity() + "~");
				fileWriter.write(inventory.get(i).getPrice() + "\n");




			}
		fileWriter.close();
	}

	/*
	 *
	 *  This method writes the arraylist of appliances to a "smallHardwareDatabase.dat" file
	 */
	public void writeAppliancesToDatabaseText() throws IOException {
		FileWriter fileWriter = new FileWriter("appliancesDatabase.txt");
		for (int i = 0; i < appliances.size(); i++) {
			//String stringID =inventory.get(i).toString();
			//String stringName = inventory.get(i).toString();


			fileWriter.write(appliances.get(i).getID() + "~");
			fileWriter.write(appliances.get(i).getName() + "~");
			fileWriter.write(appliances.get(i).getCategory() + "~");
			fileWriter.write(appliances.get(i).getQuantity() + "~");
			fileWriter.write(appliances.get(i).getPrice() + "~");
			fileWriter.write(appliances.get(i).getType() + "\n");


		}
		fileWriter.close();
	}
}

