package testcases.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC005_ValidateWithParameters {
	@Test()
	public void testToValidateParamResponse() {
		// url having some parameters.
		// q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1
		RestAssured.given().param("q", "London,uk").param("appid", "b1b15e88fa797225412429c1c50c122a1")
				.get("http://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);

	}

}
