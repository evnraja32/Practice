package oops.corejava.java8.lambdaexp.functions;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PredicateImplementationInFindElements {
	public void method() {
		List<WebElement> elements = new RemoteWebDriver(DesiredCapabilities.chrome()).findElements(By.id(""));
		performActionOnTextFieldElements(elements,(element) -> element.getTagName().equals("input"));

	}

	public void performActionOnTextFieldElements(List<WebElement> elements, Predicate<WebElement> elePredicate) {
		for(WebElement element : elements) {
			if(elePredicate.test(element)) {
				element.click();
			}
		}
	}

}
