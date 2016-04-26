package com.icap.prime.PrimeFinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.icap.prime.generator.PrimeGenerator;
import com.icap.prime.generator.SieveOfAtkinsGenerator;

public class FindPrimesWithSieveAtkin {

	PrimeGenerator primeService = null;

	@Before
	public void setup() {
		primeService = new SieveOfAtkinsGenerator();
	}

	@Test
	public void shouldFindInitialPrimes() {

		int start = 2, end = 10;
		ArrayList<Integer> primes = primeService.generatePrimes(start, end);

		assertNotNull(primes);

		int firstPrime = primes.get(0);
		int lastPrime = primes.get(3);
		assertEquals(2, firstPrime);
		assertEquals(7, lastPrime);
		assertEquals(4, primes.size());

	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotFindPrimesForLowLimits() {

		int start = 0, end = 1;
		ArrayList<Integer> primes = primeService.generatePrimes(start, end);

		fail("Expected illegal argument exception.");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldNotFindPrimesForHighLimits() {

		int start = 3, end = 10000001;
		ArrayList<Integer> primes = primeService.generatePrimes(start, Integer.MAX_VALUE);

		fail("Expected illegal argument exception.");

	}

	@Test
	public void shouldFindMaxIntPrimes() {

		int start = 999000, end = 999999;
		ArrayList<Integer> primes = primeService.generatePrimes(start, end);

		assertNotNull(primes);

		int firstPrime = primes.get(0);
		int lastPrime = primes.get(3);
		assertEquals(999007, firstPrime);
		assertEquals(999043, lastPrime);
		assertEquals(65, primes.size());

	}
}
