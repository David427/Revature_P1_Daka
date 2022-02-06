package com.revature.app;

import com.revature.Customer;
import com.revature.repositories.ModelRepoImpl;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Customer testCust = new Customer("Test", "Customer", 8, true);
        Customer testCust2 = new Customer("Test", "Customer-Two", 7, false);
        testCust2.setId(5);
        Customer testCust3 = new Customer();
        testCust3.setId(7);
        ModelRepoImpl modelRepo = new ModelRepoImpl();

        modelRepo.addRecord(testCust);
        Object returned = modelRepo.getRecord("customers", 7);
        System.out.println("getRecord OUTPUT: " + returned);
        List<?> returnedList = modelRepo.getAllRecords("customers");
        System.out.println("getAllRecords OUTPUT: " + returnedList);
        modelRepo.updateRecord(testCust2);
        modelRepo.deleteRecord(testCust3);
    }
}
