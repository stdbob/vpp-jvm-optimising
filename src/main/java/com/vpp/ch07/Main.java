package com.vpp.ch07;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		//records.getCustomers().clear();

//		for (Customer next : records.getCustomers().values())
		for (Iterator<Customer> it = records.getCustomers();it.hasNext();) {
			System.out.println(it.next());
			//it.remove();
		}
	}
	
}
