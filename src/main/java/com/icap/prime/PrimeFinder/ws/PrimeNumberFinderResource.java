package com.icap.prime.PrimeFinder.ws;


import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.icap.prime.generator.PrimeGenerator;
import com.icap.prime.generator.PrimeGeneratorFactory;


@Path("/prime")
public class PrimeNumberFinderResource {
    
	@Autowired
	private PrimeGeneratorFactory primeGeneratorFactory;
	private PrimeGeneratorFactory.PRIME_ALGO_TYPE sieveAlgo;
    private PrimeGenerator primeService;
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getPrimeNumbers(@QueryParam("start") int start, @QueryParam("end") int end) {

        if (start < 0 || end <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide two positive "
                    + "numbers in query parameters using names 'start' and 'end' Where end should be "
                    + "larger than start").build();
        }
        
        if(getPrimeService()==null)
        {
        	setPrimeService(primeGeneratorFactory.getPrimeGenerator(getSieveAlgo()));
            
        }
        
        String response = "<xml>";
        response += "       <prime-numbers>";
        
        ArrayList<Integer> primes = getPrimeService().generatePrimes(start, end);
        
        for(Integer prime:primes)
        {
        
            response += "           <prime-number>";
            response += prime;
            response += "           </prime-number>";
        }
        response += "       </prime-numbers>";
        response += "      </xml>";

        return Response.ok(response, MediaType.APPLICATION_XML).build();
    }


	private PrimeGeneratorFactory.PRIME_ALGO_TYPE getSieveAlgo() {
		return sieveAlgo;
	}


	private void setSieveAlgo(PrimeGeneratorFactory.PRIME_ALGO_TYPE sieveAlgo) {
		this.sieveAlgo = sieveAlgo;
	}


	private PrimeGenerator getPrimeService() {
		return primeService;
	}


	private void setPrimeService(PrimeGenerator primeService) {
		this.primeService = primeService;
	}

}