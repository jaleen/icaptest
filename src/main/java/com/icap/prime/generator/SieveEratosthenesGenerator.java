package com.icap.prime.generator;

import java.util.ArrayList;

public class SieveEratosthenesGenerator implements PrimeGenerator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.icap.prime.PrimeFinder.PrimeServiceInterface#findPrimes(int,
	 * int)
	 */
	public ArrayList<Integer> generatePrimes(int start, int end) {

		if (end < 2 || start <2 || end<=start || end>=1000000) {
			throw new IllegalArgumentException("Invalid start or end number. It should be between >2 and <1000000. start:"+start+ " end:"+end);
		}
		

		double limit = Math.sqrt(end);
		boolean[] primeCheck = new boolean[end + 1];
		primeCheck[0] = true;
		primeCheck[1] = true;
		for (int i = 2; i < limit; i++) {
			if (primeCheck[i] == false) {
				int j = 0;
				for (int count = 0; j <= end; count++) {
					j = i * i + count * i;

					if (j < primeCheck.length) {
						primeCheck[j] = true;
					}
				}

			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		if(start<=2)
		{
			primes.add(2);	
		}
		if(start%2==0)
		{
			start++;
		}
		
		
		for (int count = start; count < primeCheck.length;) {
			if (!primeCheck[count]) {
				primes.add(count);
			}
			count+=2;
		}
		return primes;

	}
}
