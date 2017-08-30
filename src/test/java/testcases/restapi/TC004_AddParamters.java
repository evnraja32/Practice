package testcases.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC004_AddParamters {

	@Test()
	public void testToAddCityParam() {
		// url having some parameters.
		// q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1
		Response response = RestAssured.given().param("q", "London,uk")
				.param("appid", "b1b15e88fa797225412429c1c50c122a1")
				.get("http://samples.openweathermap.org/data/2.5/weather");

		response.then().assertThat().statusCode(200);

	}

}
