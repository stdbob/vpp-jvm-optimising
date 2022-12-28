package com.vpp.ch07;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords {
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
		
//	public Map<String, Customer> getCustomers() {
//		return this.records;
//	}

	public Iterator<Customer> getCustomers() {
		return this.records.values().iterator();
	}
}
