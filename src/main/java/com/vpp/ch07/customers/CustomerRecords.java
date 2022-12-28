package com.vpp.ch07.customers;

import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}

	public void addCustomer(String name) {
		addCustomer(new Customer(name));
	}
		
	public Map<String, Customer> getCustomers() {
		return Map.copyOf(this.records);//Collections.unmodifiableMap(this.records);//allocating new map and memory usage increase
	}
	public CustomerReadOnly find(String name) {
		return new Customer(records.get(name).getName());
	}
}
