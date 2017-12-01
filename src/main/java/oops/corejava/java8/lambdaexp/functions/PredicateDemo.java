package oops.corejava.java8.lambdaexp.functions;

import java.util.function.Predicate;

public class PredicateDemo {
	public static void main(String[] args) {
		
		printMessage((t) -> t.contains("Check"));
		
	}

	public static void printMessage(Predicate<String> predicate) {
		predicate.test("Check Message");
	}
}

class SampleClassToViewPredicateInBuiltFunctions implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return false;
	}

}