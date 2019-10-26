package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles the management of the users (customers and employees) database. Takes in both
 * customers and employees attributes, and manages their arraylists seperates as customer and employee, respectively.
 * Methods manages these arraylist database.
 *
 * @author Jason Castro
 */

public class UserManager {

	private ArrayList<User> customerDatabase;
	private ArrayList<User> employeeDatabase;

	private static UserManager single_instance = null;

	/*
	 *
	 * This creates the array list of customer and employees, and starts the database for each.
	 */
	private UserManager() {
		customerDatabase = new ArrayList<User>();
		employeeDatabase = new ArrayList<User>();

		loadUserDatabase();
		loadEmployeeDatabase();
	}

	/*
	 *
	 * This method creates the customer file called "customerDatabase.txt"
	 */
	public static void createCustomerFile() throws IOException {
		File file = new File("customerDatabase.txt");

		//Create the file
		if (file.createNewFile()) {
			System.out.println("Customer Database has been created as .txt file!");
		} else {
			System.out.println("Customer Database already exists as .txt file.");
		}
	}

	/*
	 *
	 * This method creates the employee file called "employeeDatabase.dat"
	 */
	public static void createEmployeeFile() throws IOException {
		File file = new File("employeeDatabase.txt");

		//Create the file
		if (file.createNewFile()) {
			System.out.println("Employee Database has been created as .txt file!");
		} else {
			System.out.println("Employee Database already exists as .txt file.");
		}
	}

	/*
	 *
	 *  Loads data from customer file into console accessible database
	 */
	public void loadUserDatabase() {
		File customerFile = new File("customerDatabase.txt");
		try {

			Scanner readIn = new Scanner(customerFile);

			while (readIn.hasNextLine()) {
				String line = readIn.nextLine();
				String field[] = line.split("~");

				Customer customer = new Customer(
						Integer.parseInt(field[0]),
						field[1],
						field[2],
						field[3],
						field[4]);

				customerDatabase.add(customer);
			}
			readIn.close();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException: " + ex.getLocalizedMessage());
		}
	}

	/*
	 *
	 *  Loads data from the employee file into console accessible database
	 */
	public void loadEmployeeDatabase() {

		File employeeFile = new File("employeeDatabase.txt");
		try {

			Scanner readIn = new Scanner(employeeFile);

			while (readIn.hasNextLine()) {
				String line = readIn.nextLine();
				String field[] = line.split("~");
				Employee employee = new Employee(
						Integer.parseInt(field[0]),
						field[1],
						field[2],
						Integer.parseInt(field[3]),
						Double.parseDouble(field[4]));

				employeeDatabase.add(employee);
			}
			readIn.close();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException: " + ex.getLocalizedMessage());
		}
	}

	/*
	 *
	 * This method makes and returns a clone of the customer list array
	 * returns: clone of customer list array : customerDatabase.clone()
	 */
	public ArrayList<User> allCustomerDatabase() {
		return (ArrayList<User>) customerDatabase.clone();
	}

	/*
	 *
	 * This method makes and returns a clone of the employee list array
	 * returns: clone of employee list array : employeeDatabase.clone()
	 */
	public ArrayList<User> allEmployeeDatabase() {
		return (ArrayList<User>) employeeDatabase.clone();
	}

	/*
	 *This method makes and returns a single instance of the User,
	 * making methods and attributes accessible to other classes
	 *return: single_instance
	 */
	public static UserManager sharedInstance() {
		if (single_instance == null) {
			single_instance = new UserManager();
		}

		return single_instance;
	}

	/*
	 *
	 *
	 */
	public void addCustomer(String ID, String firstName, String lastName, String phoneNumber, String address) {
		String field[] = new String[5];
		Customer customer = new Customer(
				Integer.parseInt(field[0] = ID),
				field[1] = firstName,
				field[2] = lastName,
				field[3] = phoneNumber,
				field[4] = address);

		customerDatabase.add(customer);
	}


	/*
	 *
	 *this method takes input from a method outside of the class and adds it to
	 * the employee list.
	 */
	public void addEmployee(String ID, String firstName, String lastName, String SSN, String monthlySalary) {
		String field[] = new String[5];
		Employee employee = new Employee(
				Integer.parseInt(field[0] = ID),
				field[1] = firstName,
				field[2] = lastName,
				Integer.parseInt(field[3] = SSN),
				Double.parseDouble(field[4] = monthlySalary));

		employeeDatabase.add(employee);
	}

	/*
	 *This method searches the customer list for ID that matches input
	 *Input : ID from user input
	 * Return: If True, returns user
	 * 			If False, returns Null
	 */
	public User customerWithID(int id) {
		for (User user : customerDatabase) {
			if (user.getID() == id) {
				return user;
			}
		}

		return null;
	}

	/*
	 *This method searches the employee list for ID that matches input
	 *Input : ID from user input
	 * Return: If True, returns user
	 * 			If False, returns Null
	 */
	public User employeeWithID(int id) {
		for (User user : employeeDatabase) {
			if (user.getID() == id) {
				return user;
			}
		}

		return null;
	}

	public void writeCustomerToDatabaseText() throws IOException {
		FileWriter fileWriter = new FileWriter("customerDatabase.txt");
		for (int i = 0; i < customerDatabase.size(); i++) {
			//String stringID =inventory.get(i).toString();
			//String stringName = inventory.get(i).toString();


			fileWriter.write(customerDatabase.get(i).getID() + "~");
			fileWriter.write(customerDatabase.get(i).getFirstName() + "~");
			fileWriter.write(customerDatabase.get(i).getLastName() + "~");
			fileWriter.write(customerDatabase.get(i).getPhoneNumber() + "~");
			fileWriter.write(customerDatabase.get(i).getAddress() + "\n");
		}
		fileWriter.close();
	}

	/*
	 *
	 * This method writes the arraylist of employees to a "employeeDatabase.txt" file
	 */


	public void writeEmployeeToDatabaseText() throws IOException {
		FileWriter fileWriter = new FileWriter("employeeDatabase.txt");
		for (int i = 0; i < employeeDatabase.size(); i++) {
			//String stringID =inventory.get(i).toString();
			//String stringName = inventory.get(i).toString();


			fileWriter.write(employeeDatabase.get(i).getID() + "~");
			fileWriter.write(employeeDatabase.get(i).getFirstName() + "~");
			fileWriter.write(employeeDatabase.get(i).getLastName() + "~");
			fileWriter.write(employeeDatabase.get(i).getSSN() + "~");
			fileWriter.write(employeeDatabase.get(i).getMonthlySalary() + "\n");
		}
		fileWriter.close();
	}

	/*
	 *
	 * This method writes the arraylist of customers to a "customerDatabase.txt" file
	 */
	public void writeCustomerToDatabase()
	{

		try {
			FileOutputStream fileOut = new FileOutputStream("customerDatabase.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			for (User user : customerDatabase)
			{
				out.writeObject(user.getID());
				out.writeObject(user.getFirstName());
				out.writeObject(user.getLastName());
				out.writeObject(user.getPhoneNumber());
				out.writeObject(user.getAddress());
			}
		} catch(IOException ex){
			System.out.println("IOException: " + ex.getLocalizedMessage());
		}
	}


}
