package com.icap.prime.PrimeFinder;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

/**
 * Hello world!
 *
 */
public class PrimeFinderApp {
	public static void main(String[] args) {
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
		ResourceConfig config = new ResourceConfig();
		config.packages(true, "app");
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		
		server.start();
	}
}
