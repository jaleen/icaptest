package com.icap.prime.generator;

import java.util.ArrayList;

public class SieveOfAtkinsGenerator implements PrimeGenerator {

	public ArrayList<Integer> generatePrimes(int start, int end) {

		if (end < 2 || start < 2 || end <= start || end >= 1000000) {
			throw new IllegalArgumentException(
					"Invalid start or end number. It should be between >2 and <1000000. start:" + start + " end:"
							+ end);
		}

		boolean primeFlag[] = new boolean[end + 1];

		primeFlag[2] = true;
		primeFlag[3] = true;

		int limit = (int) Math.sqrt(end);

		for (int x = 1; x <= limit; x++) {
			for (int y = 1; y <= limit; y++) {
				int num = (4 * x * x + y * y);
				if (num <= end && (num % 12 == 1 || num % 12 == 5)) {
					primeFlag[num] = true;
				}

				num = (3 * x * x + y * y);
				if (num <= end && (num % 12 == 7)) {
					primeFlag[num] = true;
				}

				if (x > y) {
					num = (3 * x * x - y * y);
					if (num <= end && (num % 12 == 11)) {
						primeFlag[num] = true;
					}
				}
			}
		}
		// remove the composites
		for (int i = 5; i <= limit; i++) {
			if (primeFlag[i])
				for (int j = i * i; j <= end; j += i) {
					primeFlag[j] = false;
				}
		}

		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			if (primeFlag[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
}
