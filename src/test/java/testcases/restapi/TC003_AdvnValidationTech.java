package testcases.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC003_AdvnValidationTech {
	@Test()
	public void testToPass200StatusCode() {
		// url having some parameters.
		RestAssured.get(
				"http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1")
				.then()
				.assertThat()
				.statusCode(200);
	}

	@Test
	public void testToPass403StatusCode() {
		RestAssured.get("<<Some Junk URL>>")
		.then()
		.assertThat()
		.statusCode(403);
	}
	
	@Test
	public void testToFail403StatusCode() {
		RestAssured.get("<<Some Junk URL>>")
		.then()
		.assertThat()
		.statusCode(400);
	}

	
}
