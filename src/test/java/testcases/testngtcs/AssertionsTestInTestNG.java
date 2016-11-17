package testcases.testngtcs;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTestInTestNG {
	public static int index = 0;

	@Test(priority = -1)
	public void softAlert() {
		System.out.println("priority index - soft alert: "+(++index));
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(true,false,"Assert Test 1");
		//	  sa.assertAll();

		sa.assertTrue(false,"Assert Test 2");

		sa.assertEquals("actual", "expected","Assert Test 3");
		//	  sa.assertAll();
	}

	@Test(priority = 1)
	public void hardAlert() {
		System.out.println("priority index - hard alert: "+(++index));
		SoftAssert sa = new SoftAssert();

		Assert.assertEquals(true,true,"hard Assert Test 1");

		Assert.assertEquals(true,false,"Hard Assert Test 2");

	}
}
