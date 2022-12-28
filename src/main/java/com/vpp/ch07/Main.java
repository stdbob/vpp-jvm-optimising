package com.vpp.ch07;

import com.vpp.ch07.customers.CustomerReadOnly;
import com.vpp.ch07.customers.CustomerRecords;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer("John");
		records.addCustomer("Simon");

		//records.getCustomers().clear();
		//records.find("John").setName("Jane");
		//records.getCustomers().get("Simon").setName("Simona");

		for (CustomerReadOnly next : records.getCustomers().values()) {
			System.out.println(next);
		}
	}
	
}
