package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

       Menu menu = new Menu();
       com.company.HardwareStore.sharedInstance().createFile();
       com.company.TransactionManager.sharedInstance().createTransactionFile();
       com.company.UserManager.sharedInstance().createCustomerFile();
       com.company.UserManager.sharedInstance().createEmployeeFile();
       menu.start();

    }
}
