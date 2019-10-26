package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handles the management of the transactions completed, holding data from completed methods
 * within the program, and writes completed transactions to "transactionsDatabase.txt" at the end of the program.
 *
 * @author Jason Castro
 */



public class TransactionManager {

	private ArrayList<Transactions> transactionDatabase;

	private static TransactionManager single_instance = null;

	/*
	 *
	 * This creates the array list of transactions and starts the database.
	 */
	private TransactionManager() {
		transactionDatabase = new ArrayList<Transactions>();
		loadDatabase();
	}

	/*
	 *
	 *  Creates transaction file for when the program file closes and saves
	 */
	public static void createTransactionFile() throws IOException {
		File file = new File("transactionDatabase.txt");

		//Create the file
		if (file.createNewFile()) {
			System.out.println("Transaction Database has been created as a .txt file!");
		} else {
			System.out.println("Transaction Database already exists as a .txt file.");
		}
	}

	/*
	 *
	 *  Loads data from file into console accessible database
	 */
	public void loadDatabase() {
		File file = new File("transactionDatabase.txt");

		try {

			Scanner readIn = new Scanner(file);

			while (readIn.hasNextLine()) {
				String line = readIn.nextLine();

				String field[] = line.split("~");
				if (field.length == 5) {
					Transactions transaction = new Transactions(
							field[0],
							field[1],
							Integer.parseInt(field[2]),
							Integer.parseInt(field[3]),
							Integer.parseInt(field[4]));

					transactionDatabase.add(transaction);
				}
			}
			readIn.close();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException: " + ex.getLocalizedMessage());
		}
	}



	/*
	 *	Adds transactions to arraylist : transactionDatabase
	 */
	public void addTransaction(String ID, String date, String saleQuantity, String customerID, String employeeID) {
		String field[] = new String[5];
		Transactions transaction = new Transactions(
				field[0] = ID,
				field[1] = date,
				Integer.parseInt(field[2] = saleQuantity),
				Integer.parseInt(field[3] = customerID),
				Integer.parseInt(field[4] = employeeID));

		transactionDatabase.add(transaction);
	}

	/*
	 *
	 *  Creates and instance of transaction manager to be accessed by other class's methods
	 */
	public static TransactionManager sharedInstance() {
		if (single_instance == null) {
			single_instance = new TransactionManager();
		}

		return single_instance;
	}

	/*
	 * Clones the transaction array list for access
	 */
	public ArrayList<Transactions> allInventoryItems() {
		return (ArrayList<Transactions>) transactionDatabase.clone();
	}

	/*
	 * Saves transaction database to "transactionDatabase.txt"
	 *
	 */

	public void writeTransactionsToDatabaseText() throws IOException {
		FileWriter fileWriter = new FileWriter("transactionDatabase.txt");
		for (int i = 0; i < transactionDatabase.size(); i++) {
			//String stringID =inventory.get(i).toString();
			//String stringName = inventory.get(i).toString();


			fileWriter.write(transactionDatabase.get(i).getItemID() + "~");
			fileWriter.write(transactionDatabase.get(i).getDate() + "~");
			fileWriter.write(transactionDatabase.get(i).getSaleQuantity() + "~");
			fileWriter.write(transactionDatabase.get(i).getCustomerID() + "~");
			fileWriter.write(transactionDatabase.get(i).getEmployeeID() + "\n");


		}
		fileWriter.close();
	}



}