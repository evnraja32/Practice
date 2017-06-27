package testcases.testngtcs;

import org.testng.annotations.Test;

import wrapper.TestNGWrapper;

import org.testng.annotations.BeforeClass;

public class InterviewPractive extends TestNGWrapper {
  @Test
  public void f() {
  
  }
  @BeforeClass
  public void beforeClass() {
	  testCaseName = "Test";
	  testCaseDesc = "Sample Test Case";
	  browser = "chrome";
	  url = "https://ab.com";
  }

}
