package com.icap.prime.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimeGeneratorFactory {
	
	@Autowired
	private PrimeGenerator sieveEratosthene;
	@Autowired
	private PrimeGenerator sieveAtkin;
	public enum PRIME_ALGO_TYPE{SIEVE_ERATOSTHENES, SIEVE_ATKIN};
	public PrimeGenerator getPrimeGenerator(PRIME_ALGO_TYPE generatorType)
	{
		
		
		switch(generatorType)
		{
			case SIEVE_ERATOSTHENES: 
				return getSieveEratosthene();
			case SIEVE_ATKIN:
				return getSieveAtkin();
			default:
				return getSieveAtkin();
		}
		
		
	}
	private PrimeGenerator getSieveAtkin() {
		return sieveAtkin;
	}
	private void setSieveAtkin(PrimeGenerator sieveAtkin) {
		this.sieveAtkin = sieveAtkin;
	}
	private PrimeGenerator getSieveEratosthene() {
		return sieveEratosthene;
	}
	private void setSieveEratosthene(PrimeGenerator sieveEratosthene) {
		this.sieveEratosthene = sieveEratosthene;
	}

}
