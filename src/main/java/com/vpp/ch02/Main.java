package com.vpp.ch02;

public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt(args[0]);
		primeNumbers.generateNumbers(max);
		System.out.printf("Elapsed time was %dms", System.currentTimeMillis() - start);
	}

}