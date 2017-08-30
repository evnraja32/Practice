package testcases.restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 * @author RAJA Used TestNG Assert for verifying the status codes returned.
 *         Given scenarios for both PASS and FAIL of Status Codes
 *
 */
public class TC002_ValidateStatusCodes {
	private Response response = null;

	@Test()
	public void testToPass200StatusCode() {
		// url having some parameters.
		response = RestAssured.get(
				"http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void testToPass403StatusCode() {
		response = RestAssured.get("<<Some Junk URL>>");
		Assert.assertEquals(response.getStatusCode(), 403);
	}

	@Test
	public void testToPass404StatusCode() {
		response = RestAssured.get("https://api.openweathermap.org/current");
		Assert.assertEquals(response.getStatusCode(), 404);
	}

	@Test
	public void testToPass401StatusCode() {
		// here the url was provided without appid. So, when requesting for
		// services without appid 401 error should throw.
		response = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=");
		Assert.assertEquals(response.getStatusCode(), 401);

	}

	@Test()
	public void testToFail200StatusCode() {
		// url having some parameters.
		response = RestAssured.get(
				"http: // samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		Assert.assertEquals(response.getStatusCode(), 000);
	}

	@Test
	public void testToFail403StatusCode() {
		response = RestAssured.get("<<Some Junk URL>>");
		Assert.assertEquals(response.getStatusCode(), 000);
	}

	@Test
	public void testToFail404StatusCode() {
		response = RestAssured.get("https://api.openweathermap.org/current");
		Assert.assertEquals(response.getStatusCode(), 000);
	}

	@Test
	public void testToFail401StatusCode() {
		// here the url was provided without appid. So, when requesting for
		// services without appid 401 error should throw.
		response = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk");
		Assert.assertEquals(response.getStatusCode(), 000);
	}
}
