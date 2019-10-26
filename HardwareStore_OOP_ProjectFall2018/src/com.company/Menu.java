package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * This class handles the menu management of the program, and the methods within the menu.
 *
 * @author Jason Castro
 */

public class Menu {

	/*
	* Starts the menu and other methods after; the start of the program
	*
	*/
	public void start() throws IOException {
		showMenu();
	}

	/*
	* This method Reads out the menu; Takes in the input choice from the user.
	*
	*/
	private void showMenu() throws IOException {

		System.out.println("\n1. Show all existing items in stock and their quantities.\n" +
				"2. Add a new item or quantity to database.\n" +
				"3. Remove an item from the database.\n" +
				"4. Search for an item (given its name or part of its name).\n" +
				"5. Show a list of users in the database.\n" +
				"6. Add a new user to database.\n" +
				"7. Update user info(given its ID)\n" +
				"8. Complete a sale transaction\n" +
				"9. Show completed sale transactions\n" +
				"10. Exit program.\n");

		System.out.print("Enter option number here :");

		Scanner menuOption = new Scanner(System.in);
		String userSelectedOption = menuOption.next();
		try {

			int intValue = Integer.parseInt(userSelectedOption);
		}catch (NumberFormatException e) {
			System.out.println("Input is not a valid integer");
			showMenu();
		}
		menuChoice(userSelectedOption);
	}

	/*
	 *
	 *this method takes in the User Selected Option taken from the showMenu method
	 * and moves to other methods according to this user input.
	 */
	private void menuChoice(String userSelectedOption) throws IOException {
		switch (Integer.parseInt(userSelectedOption)) {
			case 1:
				//System.out.println("This is interacting with choice 1\n");
				System.out.println("SMALL HARDWARE ITEMS");
				display(HardwareStore.sharedInstance().allInventoryItems());
				System.out.println("APPLIANCES");
				displayAppliances(HardwareStore.sharedInstance().allApplianceItems());
				showMenu();
				break;

			case 2:
				promptAddItem();
				showMenu();
				break;

			case 3:
				deleteItem();
				showMenu();
				break;

			case 4:
				searchItem();
				showMenu();
				break;

			case 5:
				System.out.println("This is interacting with choice 5\n");
				//5. Show a list of users in the database.
				System.out.println("CUSTOMER DATABASE LIST:\n");
				displayCustomers(UserManager.sharedInstance().allCustomerDatabase());

				System.out.println("EMPLOYEE DATABASE LIST:\n");
				displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());

				showMenu();
				break;

			case 6:
				//6. Add new user to the database
				addUser();
				showMenu();
				break;

			case 7:
				//7. Update user info (given their id).
				changeUserInfo();
				showMenu();
				break;

			case 8:
				//8. Complete a sale transaction.
				createTransaction();
				showMenu();
				break;

			case 9:
				//9. Show completed sale transactions.
				displayTransactions(TransactionManager.sharedInstance().allInventoryItems());
				showMenu();
				break;

			case 10:
				System.out.println("Exiting Menu.....");
				//HardwareStore.sharedInstance().writeSmallHardwareToDatabase();
				HardwareStore.sharedInstance().writeSmallHardwaretoDatabaseText();
				HardwareStore.sharedInstance().writeAppliancesToDatabaseText();
				//HardwareStore.sharedInstance().writeAppliancesToDatabase();
				//UserManager.sharedInstance().writeCustomerToDatabase();
				UserManager.sharedInstance().writeCustomerToDatabaseText();
				//UserManager.sharedInstance().writeEmployeeToDatabase();
				UserManager.sharedInstance().writeEmployeeToDatabaseText();
				//TransactionManager.sharedInstance().writeTransactionsToDatabase();
				TransactionManager.sharedInstance().writeTransactionsToDatabaseText();
				break;

			default:
				System.out.println("Please Enter a valid Option [Enter 1-10]\n");
				showMenu();
				break;
		}

	}

	/*
	*
	* Displays the Item inventory list to console as a displayed menu.
	*/
	public void display(ArrayList<Item> items)
	{
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("| ");
		System.out.printf("%20s", " ID #");
		System.out.printf("        | ");
		System.out.printf("%20s", "Name");
		System.out.print("      | ");
		System.out.printf("%20s", "Category");
		System.out.print("  | ");
		System.out.printf("%20s", "Quantity");
		System.out.print("                     | ");
		System.out.printf("%20s", "Price");
		System.out.println("                    |");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (Item item : items) {
			{
				System.out.print("| ");;
				System.out.printf("%20s", item.getID());
				System.out.print("        | ");
				System.out.printf("%20s", item.getName());
				System.out.print("      | ");
				System.out.printf("%20s", item.getCategory());
				System.out.print("  | ");
				System.out.printf("%20s", item.getQuantity());
				System.out.print(" 	                 | ");
				System.out.printf("%20s", item.getPrice());
				System.out.println("   		           |");
			}
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	/*
	 *
	 *Displays the Appliances list to console as a displayed menu.
	 */
	public void displayAppliances(ArrayList<Item> items)
	{
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("| ");
		System.out.printf("%20s", " ID #");
		System.out.printf("        | ");
		System.out.printf("%20s", "NAME");
		System.out.print("      | ");
		System.out.printf("%20s", "BRAND");
		System.out.print("  | ");
		System.out.printf("%20s", "Type");
		System.out.print("     | ");
		System.out.printf("%20s", "QUANTITY");
		System.out.print("       | ");
		System.out.printf("%20s", "PRICE");
		System.out.print("        | ");
		System.out.println("\n ------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (Item item : items) {
			{
				System.out.print("| ");
				System.out.printf("%20s", item.getID());
				System.out.print("        | ");
				System.out.printf("%20s", item.getName());
				System.out.print("      | ");
				System.out.printf("%20s", item.getCategory());
				System.out.print("  | ");
				System.out.printf("%20s", item.getType());
				System.out.print(" 	  | ");
				System.out.printf("%20s", item.getQuantity());
				System.out.print(" 	  | ");
				System.out.printf("%20s", item.getPrice());
				System.out.println("        |");
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	/*
	 *
	 *Displays the Customers list to console as a displayed menu.
	 */
	public void displayCustomers(ArrayList<User> users)
	{
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("| ");
		System.out.printf("%20s", " ID #");
		System.out.printf("        | ");
		System.out.printf("%20s", "First Name");
		System.out.print("      | ");
		System.out.printf("%20s", "Last Name");
		System.out.print("  | ");
		System.out.printf("%20s", "Phone Number");
		System.out.print("     | ");
		System.out.printf("%20s", "Address");
		System.out.println("                                      |");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

		for (User user : users) {
			System.out.print("| ");
			System.out.printf("%20s", user.getID());
			System.out.print("        | ");
			System.out.printf("%20s", user.getFirstName());
			System.out.print("      | ");
			System.out.printf("%20s", user.getLastName());
			System.out.print("  | ");
			System.out.printf("%20s", user.getPhoneNumber());
			System.out.print(" 	  | ");
			System.out.printf("%20s", user.getAddress());
			System.out.println("                                     |");

		}
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	/*
	 *
	 *Displays the Employee list to console as a displayed menu.
	 */
	public void displayEmployee(ArrayList<User> users) {
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("| ");
		System.out.printf("%20s", " ID #");
		System.out.printf("                                | ");
		System.out.printf("%20s", "First Name");
		System.out.print("      | ");
		System.out.printf("%20s", "Last Name");
		System.out.print("  | ");
		System.out.printf("%20s", "Social Security Number");
		System.out.print("    | ");
		System.out.printf("%20s", "Monthly Salary");
		System.out.println("            |");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");

		for (User user : users) {
			System.out.print("| ");
			System.out.printf("%20s", user.getID());
			System.out.print("                                | ");
			System.out.printf("%20s", user.getFirstName());
			System.out.print("      | ");
			System.out.printf("%20s", user.getLastName());
			System.out.print("  | ");
			System.out.printf("%20s", user.getSSN());
			System.out.print(" 	  | ");
			System.out.printf("%20s", user.getMonthlySalary());
			System.out.println("   		    |");
		}
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	/*
	 *
	 *Displays the transactions list to console as a displayed menu.
	 */
	public void displayTransactions(ArrayList<Transactions> transaction) {
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("| ");
		System.out.printf("%20s", " Item ID");
		System.out.printf("           | ");
		System.out.printf("%20s", "Date");
		System.out.print("      | ");
		System.out.printf("%20s", "Sale Quantity");
		System.out.print("  | ");
		System.out.printf("%20s", "Purchasing Customer ID");
		System.out.print("       | ");
		System.out.printf("%20s", "Employee ID");
		System.out.println("      |");
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------");

		for (Transactions transactions : transaction) {
			System.out.print("| ");
			System.out.printf("%20s", transactions.getItemID());
			System.out.print("           | ");
			System.out.printf("%20s", transactions.getDate());
			System.out.print("      | ");
			System.out.printf("%20s", transactions.getSaleQuantity());
			System.out.print("  | ");
			System.out.printf("%20s", transactions.getCustomerID());
			System.out.print(" 	    | ");
			System.out.printf("%20s", transactions.getEmployeeID());
			System.out.println("      |");
		}
		System.out.println("|------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	/*
	 *
	 *This method adds a certain integer value to the selected qty of an item (small hardware and/or appliances)
	 */
	private void addQTY() throws IOException {
		display(HardwareStore.sharedInstance().allInventoryItems());
		displayAppliances(HardwareStore.sharedInstance().allApplianceItems());


		System.out.println("Enter ID of item you would like to add quantity to: ");
		Scanner consoleIn = new Scanner(System.in);
		String userInput = consoleIn.nextLine();

		Item matchingID = HardwareStore.sharedInstance().itemWithID(userInput);
		Item matchingApp = HardwareStore.sharedInstance().applianceWithID(userInput);


		if (matchingID != null) {
			display(new ArrayList<Item>(Arrays.asList(matchingID)));
			System.out.println("How many would you like to add? ");
			String quantity = consoleIn.nextLine();

			if (! isInteger(quantity)) {
				System.out.println("Invalid quantity to add ");
				addQTY();
			} else if (isInteger(quantity)) {
				matchingID.setQuantity(matchingID.getQuantity() + Integer.parseInt(quantity));
			}
			}

			else if (matchingApp != null) {
			display(new ArrayList<Item>(Arrays.asList(matchingApp)));
			System.out.println("How many would you like to add? ");
			String quantity = consoleIn.nextLine();
			if (! isInteger(quantity)) {
				System.out.println("Invalid quantity to add");
				addQTY();
			}
			else
				matchingApp.setQuantity(matchingApp.getQuantity() + Integer.parseInt(quantity));
			}


		else{
					System.out.println("\nNo item matching id #: " + userInput + ".");
					System.out.println("\nPlease re-enter valid ID# or type 'exit' to return to menu");
					userInput = consoleIn.nextLine();
					if (userInput.equals("exit")) {
						showMenu();
					} else
						System.out.println(userInput);
					addQTY();
				}
				display(HardwareStore.sharedInstance().allInventoryItems());
				displayAppliances(HardwareStore.sharedInstance().allApplianceItems());
	}

	/*
	 *
	 *this method logs the customer who is purchasing an item,
	 *then logs the customer who is completing the transaction,
	 * then logs the date of purchase,
	 * then based on ID selects the item being purchased
	 * asks and logs qty purchased,
	 * adjusts qty of inventory according to the purchased qty
	 * and saves the log to a completed transaction array.
	 */
	private void createTransaction() throws IOException {

		displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
		System.out.println("Enter purchasing Customer ID:");

		Scanner consoleIn = new Scanner(System.in);
		String userInput = consoleIn.nextLine();

		try {
			int intValue = Integer.parseInt(userInput);
		}catch (NumberFormatException e) {
			System.out.println("ID is not a valid entry, numbers only");
			createTransaction();
		}

		User customerInfo = UserManager.sharedInstance().customerWithID(Integer.parseInt(userInput));

		displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());

		System.out.println("Enter Employee completing transaction:");
		userInput = consoleIn.nextLine();

		try {
			int intValue = Integer.parseInt(userInput);
		}catch (NumberFormatException e) {
			System.out.println("ID is not a valid entry, numbers only");
			createTransaction();
		}

		User employeeInfo = UserManager.sharedInstance().employeeWithID(Integer.parseInt(userInput));

		System.out.println("Enter today's date or date of purchase:");
		userInput = consoleIn.nextLine();

		String date = userInput;

		display(HardwareStore.sharedInstance().allInventoryItems());
		displayAppliances(HardwareStore.sharedInstance().allApplianceItems());

		System.out.println("Enter ID of item you would like to purchase: ");
		userInput = consoleIn.nextLine();

		Item matchingID = HardwareStore.sharedInstance().itemWithID(userInput);
		Item matchingAppID = HardwareStore.sharedInstance().applianceWithID(userInput);

		if (matchingID != null)
		{
			display(new ArrayList<Item>(Arrays.asList(matchingID)));
			System.out.println("How many of this item would you like to purchase? ");
			String quantity = consoleIn.nextLine();

			try {
				int intValue = Integer.parseInt(quantity);
			}catch (NumberFormatException e) {
				System.out.println("Qty purchased is not a valid quantity");
				createTransaction();
			}

			if 	(matchingID.getQuantity() - Integer.parseInt(quantity) < 0)
			{
				System.out.println("There is not enough stock for this transaction");
				createTransaction();
			}
			else
				{
					matchingID.setQuantity(matchingID.getQuantity() - Integer.parseInt(quantity));
					String quantityPurchased = quantity;

					TransactionManager.sharedInstance().addTransaction(matchingID.getID(), date, quantityPurchased,
							Integer.toString(customerInfo.getID()), Integer.toString(employeeInfo.getID()));
				}
		}
		else if (matchingAppID != null)
		{
			displayAppliances(new ArrayList<Item>(Arrays.asList(matchingAppID)));

			System.out.println("How many of this item would you like to purchase? ");
			String quantity = consoleIn.nextLine();
			try {
				int intValue = Integer.parseInt(quantity);
			}catch (NumberFormatException e) {
				System.out.println("Qty purchased is not a valid quantity");
				createTransaction();
			}

			if ((matchingAppID.getQuantity() - Integer.parseInt(quantity) < 0))
			{
				System.out.println("There is not enough stock for this transaction");
				createTransaction();
			}
			else
				{
				matchingAppID.setQuantity(matchingAppID.getQuantity() - Integer.parseInt(quantity));
				String quantityPurchased = quantity;
				TransactionManager.sharedInstance().addTransaction(matchingAppID.getID(), date, quantityPurchased,
						Integer.toString(customerInfo.getID()), Integer.toString(employeeInfo.getID()));
				}
		}
		else
			{
			System.out.println("\nNo item matching ID #: " + userInput + ".");
			System.out.println("\nPlease re-enter valid ID# or type 'exit' to return to menu");
			userInput = consoleIn.next();
			if (userInput.equals("exit")) {
				showMenu();
			} else
				System.out.println(userInput);
				createTransaction();
			}
	}

	/*
	 *
	 * This method searches the item and appliances inventory by name and displays the returned item.
	 */
	private ArrayList<Item> searchItem()
	{

		System.out.println("Enter Name or part of name to search for item: ");
		Scanner consoleIn = new Scanner(System.in);
		String userInput = consoleIn.nextLine();

		ArrayList<Item> matchingItems = HardwareStore.sharedInstance().itemWithName(userInput);
		ArrayList<Item> matchingAppliance = HardwareStore.sharedInstance().appWithName(userInput);

		if (matchingItems.size() > 0 || matchingAppliance.size() > 0 ) {
			display(matchingItems);
			displayAppliances(matchingAppliance);
		} else
			System.out.println("Item does not exist");

		return matchingItems;
	}

	/*
	 *
	 * This method adds a completely new small hardware or appliances to their according list.
	 */
	private void addItem() throws IOException {

		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Would you like to add: ");
		System.out.println("1. Small Hardware Item ");
		System.out.println("2. Appliance ");
		System.out.println("3. Cancel(Exit to menu)");
		String userInput = consoleIn.nextLine();

		try {

			int intValue = Integer.parseInt(userInput);
		}catch (NumberFormatException e) {
			System.out.println("Input is not a valid integer");
			addItem();
		}

		switch (Integer.parseInt(userInput)) {
			case 1:
				System.out.println("Enter ID: ");
				String idInput = consoleIn.nextLine();

				System.out.println("Enter Name: ");
				String nameInput = consoleIn.nextLine();

				System.out.println("Enter Category ");
				String categoryInput = consoleIn.nextLine();

				System.out.println("Enter Quantity: ");
				String quantityInput = consoleIn.nextLine();

				try {

					int intValue = Integer.parseInt(quantityInput);
				}catch (NumberFormatException e) {
					System.out.println("Input is not a valid quantity");
					showMenu();
				}

				System.out.println("Enter Price: ");
				String priceInput = consoleIn.nextLine();
				try {

					double intValue = Double.parseDouble(priceInput);
				}catch (NumberFormatException e) {
					System.out.println("Input is not a valid price");
					showMenu();
				}

				HardwareStore.sharedInstance().addItem(idInput, nameInput, categoryInput, quantityInput, priceInput);
				display(HardwareStore.sharedInstance().allInventoryItems());
				break;

			case 2:
				System.out.println("Enter ID: ");
				String appIdInput = consoleIn.nextLine();

				System.out.println("Enter Name: ");
				String appNameInput = consoleIn.nextLine();

				System.out.println("Enter Brand ");
				String appBrandInput = consoleIn.nextLine();

				System.out.println("Enter Type: ");
				String appTypeInput = consoleIn.nextLine();

				System.out.println("Enter Quantity: ");
				String appQuantityInput = consoleIn.nextLine();

				try {

					int intValue = Integer.parseInt(appQuantityInput);
				}catch (NumberFormatException e) {
					System.out.println("Input is not a valid quantity");
					showMenu();
				}

				System.out.println("Enter Price: ");
				String appPriceInput = consoleIn.nextLine();

				try {

					double intValue = Double.parseDouble(appPriceInput);
				}catch (NumberFormatException e) {
					System.out.println("Input is not a valid price");
					showMenu();
				}

				HardwareStore.sharedInstance().addApplianceItem(appIdInput, appNameInput, appBrandInput, appQuantityInput, appPriceInput, appTypeInput);
				displayAppliances(HardwareStore.sharedInstance().allApplianceItems());
				break;

			case 3:
				showMenu();
				break;

			default:
				System.out.println("Please enter a valid option");
				addItem();
		}
	}

	/*
	 *
	 *This method completely deletes a small hardware or appliance item from the list
	 */
	private void deleteItem() throws IOException {
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Would you like to delete: ");
		System.out.println("1. Small Hardware Item ");
		System.out.println("2. Appliance ");
		System.out.println("3. Cancel(Exit to menu)");
		String userInput = consoleIn.nextLine();

		if(!isInteger(userInput)) {
			System.out.println("Input is not a valid integer");
			deleteItem();
		}
		else

			switch (Integer.parseInt(userInput))
			{
			case 1:

			System.out.println("Enter ID you would like to delete: ");
			consoleIn = new Scanner(System.in);
			String idInput = consoleIn.nextLine();
			Item matchingID = HardwareStore.sharedInstance().itemWithID(idInput);

			while (matchingID == null || idInput != "exit")
			{
				if (matchingID != null)
				{
				HardwareStore.sharedInstance().removeItem(matchingID);
				System.out.println("Item with ID " + idInput + " has been removed");
				display(HardwareStore.sharedInstance().allInventoryItems());
				showMenu();
				} else
					{
					System.out.println("\nNo item matching id #: " + idInput + ".");
					System.out.println("\nPlease re-enter valid ID# or type 'exit' to return to menu");
					idInput = consoleIn.nextLine();
					matchingID = HardwareStore.sharedInstance().itemWithID(idInput);
					}
					if (idInput.equals("exit"))
					{
					showMenu();
					}
			}
			break;

			case 2:
				displayAppliances(HardwareStore.sharedInstance().allApplianceItems());
				System.out.println("Enter ID you would like to delete: ");
				consoleIn = new Scanner(System.in);
				idInput = consoleIn.nextLine();

				Item matchingAppID = HardwareStore.sharedInstance().applianceWithID(idInput);

				while (matchingAppID == null || idInput != "exit")
				{
					if (matchingAppID != null) {
						HardwareStore.sharedInstance().removeAppliance(matchingAppID);
						System.out.println("Item with ID " + idInput + " has been removed");
						displayAppliances(HardwareStore.sharedInstance().allApplianceItems());
						break;
					} else {
						System.out.println("\nNo item matching id #: " + idInput + ".");
						System.out.println("\nPlease re-enter valid ID# or type 'exit' to return to menu");
						idInput = consoleIn.nextLine();
						matchingAppID = HardwareStore.sharedInstance().applianceWithID(idInput);
					}
						if (idInput.equals("exit")) {
							showMenu();
						}
					}
					break;

			case 3:
				showMenu();

				default:
					System.out.println("Input is not a valid choice. Enter 1 - 3");
					deleteItem();
			}
	}

	/*
	 *
	 * This method displays the menu for adding an item or adding a qty to an item
	 * based on the users input choice.
	 *
	 */
	private void promptAddItem() throws IOException {
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Would you like to create a new item or add stock to an item? ");
		System.out.println("1. Create new item ");
		System.out.println("2. Add stock to item ");
		System.out.println("3. Exit");
		String userInput = consoleIn.nextLine();

		try {
			int intValue = Integer.parseInt(userInput);
		}catch (NumberFormatException e) {
			System.out.println("Input is not a valid integer");
			promptAddItem();
		}

		switch (Integer.parseInt(userInput)) {
			case 1:
				addItem();
				break;

			case 2:
				addQTY();
				break;

			case 3:
				showMenu();
				break;

			default:
				System.out.println("Please enter a valid option");
				promptAddItem();
		}
	}

	/*
	 *
	 *This method adds a customer or employee user to the arraylist accordingly.
	 */
	private void addUser() throws IOException {
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Would you like to add: ");
		System.out.println("1. Customer ");
		System.out.println("2. Employee ");
		System.out.println("3. Cancel(Exit to menu)");
		String userInput = consoleIn.nextLine();

		try {
			int intValue = Integer.parseInt(userInput);
		}catch (NumberFormatException e) {
			System.out.println("Input is not a valid integer");
			addUser();
		}

		switch (Integer.parseInt(userInput)) {
			case 1:
				System.out.println("Enter ID: ");
				String idInput = consoleIn.nextLine();

				try
				{
					int intValueUserID = Integer.parseInt(idInput);
				}catch (NumberFormatException e) {
					System.out.println("ID is not a valid entry, numbers only");
					addUser();
				}

				System.out.println("Enter First Name: ");
				String firstNameInput = consoleIn.nextLine();

				System.out.println("Enter Last Name: ");
				String lastNameInput = consoleIn.nextLine();

				System.out.println("Enter Phone Number: ");
				String phoneNumberInput = consoleIn.nextLine();

				System.out.println("Enter Address: ");
				String addressInput = consoleIn.nextLine();

				UserManager.sharedInstance().addCustomer(idInput, firstNameInput, lastNameInput, phoneNumberInput, addressInput);
				displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
				break;

			case 2:
				System.out.println("(Numbers Only)Enter ID: ");
				String empIdInput = consoleIn.nextLine();

				try
				{
					int intValueEmpID = Integer.parseInt(empIdInput);
					}catch (NumberFormatException e) {
					System.out.println("ID is not a valid entry, numbers only");
					addUser();
				}

				System.out.println("Enter First Name: ");
				String empFirstNameInput = consoleIn.nextLine();

				System.out.println("Enter Last Name ");
				String empLastNameInput = consoleIn.nextLine();

				System.out.println("(Numbers only)Enter 9 Digit Social Security Number ");
				String empSSNInput = consoleIn.nextLine();

				try
				{
					int intValueEmpSSN = Integer.parseInt(empSSNInput);
				}catch (NumberFormatException e) {
					System.out.println("SSN is not a valid entry, numbers only");
					addUser();
				}

				System.out.println("Enter Monthly Salary: ");
				String empMonthlySalaryInput = consoleIn.nextLine();

				try
				{
					double doubleValueEmpSSN = Double.parseDouble(empMonthlySalaryInput);
				}catch (NumberFormatException e) {
					System.out.println(" Monthly Salary is not a valid entry, numbers only");
					addUser();
				}
				UserManager.sharedInstance().addEmployee(empIdInput, empFirstNameInput, empLastNameInput, empSSNInput, empMonthlySalaryInput);
				displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
				break;

			case 3:
				break;

			default:
				System.out.println("Please enter a valid option");
				addUser();
		}
	}

	/*
	 *
	 *This method can manipulate and change an attribute in any user's information.
	 */
	public void changeUserInfo() throws IOException {
		System.out.println("Would you like to update a: ");
		System.out.println("1.Customer's Information ");
		System.out.println("2.Employee's Information ");
		System.out.println("3. Cancel(Exit to menu)");

		Scanner consoleIn = new Scanner(System.in);
		String userInput = consoleIn.nextLine();

		try {
			int intValue = Integer.parseInt(userInput);
		}catch (NumberFormatException e) {
			System.out.println("Input is not a valid integer");
			changeUserInfo();
		}

		switch (Integer.parseInt(userInput)) {

			case 1:
				displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
				System.out.println("(Numbers Only)Enter ID for customer you would like to change info on: ");
				userInput = consoleIn.nextLine();

				try {
					int intValue = Integer.parseInt(userInput);
				}catch (NumberFormatException e) {
					System.out.println("ID is not a valid integer");
					changeUserInfo();
				}

				User idInfo = UserManager.sharedInstance().customerWithID(Integer.parseInt(userInput));

				if (idInfo != null) {
					System.out.println("What attribute would you like to change for this customer? ");
					System.out.println("1. ID");
					System.out.println("2. First Name");
					System.out.println("3. Last Name ");
					System.out.println("4. Phone Number");
					System.out.println("5. Address");
					userInput = consoleIn.nextLine();

					try {
						int intValue = Integer.parseInt(userInput);
					}catch (NumberFormatException e) {
						System.out.println("Input is not a valid integer");
						changeUserInfo();
					}

					switch (Integer.parseInt(userInput)) {

						case 1:
							System.out.println("(Numbers Only) What would you like to change the ID to: ");
							userInput = consoleIn.nextLine();

							try
							{
							int intValue = Integer.parseInt(userInput);
							}catch (NumberFormatException e) {
							System.out.println("ID is not a valid entry, numbers only");
							changeUserInfo();
							}

							idInfo.setID(Integer.parseInt(userInput));
							displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
							break;

						case 2:
							System.out.println("What would you like to change the First Name to: ");
							userInput = consoleIn.nextLine();
							idInfo.setFirstName(userInput);
							displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
							break;

						case 3:
							System.out.println("What would you like to change the Last Name to: ");
							userInput = consoleIn.nextLine();
							idInfo.setLastName(userInput);
							displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
							break;

						case 4:
							System.out.println("What would you like to change the Phone Number to: ");
							userInput = consoleIn.nextLine();
							idInfo.setPhoneNumber(userInput);
							displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
							break;

						case 5:
							System.out.println("What would you like to change the Address to: ");
							userInput = consoleIn.nextLine();
							idInfo.setAddress(userInput);
							displayCustomers(UserManager.sharedInstance().allCustomerDatabase());
							break;

						default:
							System.out.println("Please enter a valid option");
							changeUserInfo();
							break;

					}

				} else {
					System.out.println("That ID does not exist");
					changeUserInfo();
				}
				break;


			case 2:
				displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
				System.out.println("Enter ID for Employee you would like to change info on: ");
				userInput = consoleIn.nextLine();

				try {
					int intValue = Integer.parseInt(userInput);
				}catch (NumberFormatException e) {
					System.out.println("Input is not a valid integer");
					changeUserInfo();
				}

				User empIdInfo = UserManager.sharedInstance().employeeWithID(Integer.parseInt(userInput));

				if (empIdInfo != null) {
					System.out.println("What attribute would you like to change for this employee? ");
					System.out.println("1. ID");
					System.out.println("2. First Name");
					System.out.println("3. Last Name ");
					System.out.println("4. Social Security Number");
					System.out.println("5. Monthly Salary");
					userInput = consoleIn.nextLine();

					try {
						int intValue = Integer.parseInt(userInput);
					}catch (NumberFormatException e) {
						System.out.println("Input is not a valid integer");
						changeUserInfo();
					}
					switch (Integer.parseInt(userInput)) {

						case 1:
							System.out.println("What would you like to change the ID to: ");
							userInput = consoleIn.nextLine();

							try {
								int intValue = Integer.parseInt(userInput);
							}catch (NumberFormatException e) {
								System.out.println("ID is not a valid entry, numbers only");
								changeUserInfo();
							}

							empIdInfo.setID(Integer.parseInt(userInput));
							displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
							break;

						case 2:
							System.out.println("What would you like to change the First Name to: ");
							userInput = consoleIn.nextLine();
							empIdInfo.setFirstName(userInput);
							displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
							break;

						case 3:
							System.out.println("What would you like to change the Last Name to: ");
							userInput = consoleIn.nextLine();
							empIdInfo.setLastName(userInput);
							displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
							break;

						case 4:
							System.out.println("What would you like to change the Social Security Number to: ");
							userInput = consoleIn.nextLine();

							try {
								int intValue = Integer.parseInt(userInput);
							}catch (NumberFormatException e) {
								System.out.println("SSN is not a valid entry, numbers only");
								changeUserInfo();
							}

							empIdInfo.setSSN(Integer.parseInt(userInput));
							displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
							break;

						case 5:
							System.out.println("What would you like to change the Monthly Salary to: ");
							userInput = consoleIn.nextLine();

							try {
								double doubleValue = Double.parseDouble(userInput);
							}catch (NumberFormatException e) {
								System.out.println("Monthly Salary is not a valid entry, numbers only");
								changeUserInfo();
							}

							empIdInfo.setMonthlySalary(Double.parseDouble(userInput));
							displayEmployee(UserManager.sharedInstance().allEmployeeDatabase());
							break;

						default:
							changeUserInfo();
							break;

					}
				} else {
					System.out.println("That ID does not exist");
					changeUserInfo();
				}
				break;

			case 3:
				showMenu();
				break;

			default:
				System.out.println("Please enter a valid option");
				changeUserInfo();
				break;
		}
	}

	/*
	 *
	 *This method checks if an input string value is an integer value.
	 * return : True if is an integer
	 * return: False if not an integer
	 */
	public boolean isInteger( String input ) {
		try {
			Integer.parseInt( input );
			return true;
		}
		catch( Exception e ) {
			return false;
		}
	}
}



