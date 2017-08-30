package testcases.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC001_RestApiGetStatusCodes {
	private Response response = null;

	@Test
	public void testToGet200StatusCode() {
		response = RestAssured.get("https://api.openweathermap.org/");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());

		// url having some parameters.
		response = RestAssured.get(
				"http: // samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}

	@Test
	public void testToGet403StatusCode() {
		response = RestAssured.get("<<Some Junk URL>>");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}

	@Test
	public void testToGet404StatusCode() {
		response = RestAssured.get("https://api.openweathermap.org/current");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}

	@Test
	public void testToGet401StatusCode() {
		// here the url was provided without appid. So, when requesting for
		// services without appid 401 error should throw.
		response = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk");

		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
	}
}
