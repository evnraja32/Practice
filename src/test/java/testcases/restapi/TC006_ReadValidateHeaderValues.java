package testcases.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC006_ReadValidateHeaderValues {
	@Test()
	public void testToReadValidateHeaderResponse() {
		// url having some parameters.
		// q=London,uk
		// appid=b1b15e88fa797225412429c1c50c122a1
		Response response = RestAssured.given().param("q", "London,uk")
				.param("appid", "b1b15e88fa797225412429c1c50c122a1")
				.get("http://samples.openweathermap.org/data/2.5/weather");

		// validating response code
		response.then().assertThat().statusCode(200);

		// List the available header values
		Headers headersOnline = response.thenReturn().getHeaders();

		for (Header hValue : headersOnline) {
			System.out.println(hValue.getName() + " : " + hValue.getValue());
		}

		// Read Date header value
		String dateHeader = response.thenReturn().getHeader("date");
		System.out.println("Date Header Value: " + dateHeader);

		// Validating header value header(headerName, expectedValue)
		response.then().assertThat().header("Server", "openresty/1.9.7.1");

		/*
		 * X-Frame-Options : SAMEORIGIN X-XSS-Protection : 1; mode=block
		 * X-Content-Type-Options : nosniff Cache-Control : max-age=0, private,
		 * must-revalidate => multiple header value attribute ETag :
		 * W/"e70c27085ed41de5321252b16c9582fe"
		 */

		// creating some header values
		Header header1 = new Header("X-Frame-Options", "SAMEORIGIN");
		Header header2 = new Header("Cache-Control", "max-age=0");
		Header header3 = new Header("Cache-Control", "private");
		Header header4 = new Header("Cache-Control", "must-revalidate");

		System.out.println(header4);

		// creating a multi valued header
		Header header5 = new Header("Cache-Control", "max-age=0, private, must-revalidate");

		System.out.println(header5);

		// append all headers
		Headers userHeaders = new Headers(header1, header2, header3, header4, header5);
		System.out.println("===user header===");
		System.out.println(userHeaders);

	}
}
