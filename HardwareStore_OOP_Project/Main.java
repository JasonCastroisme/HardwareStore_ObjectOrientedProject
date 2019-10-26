package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

       Menu menu = new Menu();
       HardwareStore.sharedInstance().createFile();
       TransactionManager.sharedInstance().createTransactionFile();
       UserManager.sharedInstance().createCustomerFile();
       UserManager.sharedInstance().createEmployeeFile();
       menu.start();

    }
}
