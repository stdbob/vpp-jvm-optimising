package com.vpp.ch07.customers;


class Customer implements CustomerReadOnly {
	private String name;

	@Override
	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public Customer(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
