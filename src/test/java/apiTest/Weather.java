package apiTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import apitest.InterzoidWeather;

public class Weather {

	InterzoidWeather weatherApi;

	@Before
	public void prepareTests() {
		this.weatherApi = new InterzoidWeather();
	}

	@After
	public void finalizeTests() {

	}

	@Test
	public void test1() {
		weatherApi.getWeather("Round Rock", "TX");
		assertEquals(200, weatherApi.getStatusCode());
		assertEquals("OK", weatherApi.getStatusDescription());
	}

	@Test
	public void test2() {
		weatherApi.getWeather("Tampa", "TX");
		assertEquals(404, weatherApi.getStatusCode());
		assertEquals("Not Found", weatherApi.getStatusDescription());
	}

	@Test
	public void test3() {
		weatherApi.getWeather("--", "--");
		assertEquals(400, weatherApi.getStatusCode());
		assertEquals("Bad Request", weatherApi.getStatusDescription());
	}
}
