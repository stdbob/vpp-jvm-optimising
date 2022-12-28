package com.vpp.ch07;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		//records.getCustomers().clear();
		//records.find("John").setName("Jane");
		records.getCustomers().get("Simon").setName("Simona");

		for (Customer next : records.getCustomers().values()) {
			System.out.println(next);
		}
	}
	
}
