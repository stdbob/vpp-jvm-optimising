package com.vpp.ch02;

import java.util.Date;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting...");
		Thread.sleep(60000);
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt(args[0]);
		primeNumbers.generateNumbers(max);
	}

}