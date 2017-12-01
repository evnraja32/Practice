package oops.corejava.java8.collections.lambdaexp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {
	protected static List<Person> list = null;

	public static void main(String[] args) {

		// A simple example
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

		lines.stream().forEach(value -> System.out.println(value));

		lines.stream().filter(x -> "spring".equals(x)).forEach(x -> System.out.println(x));

		list = Arrays.asList(new Person("Venkata", "NagaRaja", 25), new Person("Asif", "Palli", 30),
				new Person("Sekar", "KS", 28), new Person("Narasimha", "PV", 23), new Person("Rajan", "Rajmani", 27),
				new Person("Zaakeer", "Hussian", 25), new Person("Venkata", "NagaChaitanya", 25));

		System.out.println("\n===== Without Lambda Implementation =====\n");
		collectionsDemoWithoutLambda();
		System.out.println("\n===== Lambda Implementation =====\n");
		collectionsDemoWithLambda();

	}

	public static void collectionsDemoWithoutLambda() {
		// Step1: Creating a lambda list

		// Task1: Sort list by last name

		System.out.println("===== Implementing Sorting with lastName in alpha order =====");
		// Using java Collections.sort() method we can solve this task and here we uses
		// the comparator
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});

		// Task2: Create a Method that prints all elements in the list
		System.out.println("===== Print the sorted order =====");
		// Simple logic - using normal for loop
		for (Person p : list) {
			System.out.println(p);
		}

		// Task3: Create a Method that prints all people having lastNames begin with P

		System.out.println("===== Person Last Name Starts with P =====");
		for (Person p : list) {
			if (p.getLastName().startsWith("P")) {
				System.out.println(p);
			}
		}
		
		System.out.println("===== Implemention of Custom Sorting string implementation =====");

		printCustomList(list, "P", new CustomSortingCondition() {

			@Override
			public boolean checkCondition(Person personObj, String conditionString) {
				return personObj.getLastName().startsWith(conditionString);
			}
		});

		// Task4: Creating a custom logic for sorting list with custom string instead of
		// using a pre-defined string as stated in Task3

		System.out.println("===== Implemention of Custom Sorting string implementation =====");

		printCustomList(list, "N", new CustomSortingCondition() {

			@Override
			public boolean checkCondition(Person personObj, String conditionString) {
				return personObj.getLastName().startsWith(conditionString);
			}
		});

		System.out.println("===== Implementation using sorting condition implemented class =====");

		CustomSortingCondition customSortingConditionObj = new CustomSortingConditionImplementation();
		printCustomList(list, "K", customSortingConditionObj);

		System.out.println("===== Implementation using sorting condition implemented class Example2 =====");
		printCustomList(list, "Naga", customSortingConditionObj);

	}

	private static void printCustomList(List<Person> list, String conditionString,
			CustomSortingCondition customSortingCondition) {
		for (Person p : list) {
			if (customSortingCondition.checkCondition(p, conditionString)) {
				System.out.println(p);
			}
		}
	}

	public static void collectionsDemoWithLambda() {
		// Step1: Creating a lambda list

		// Task1: Sort list by last name

		System.out.println("===== Implementing Sorting with lastName in alpha order =====");
		// Using java Collections.sort() method used to solve and comparator was replaced with lambda
		Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// Task2: Create a Method that prints all elements in the list
		System.out.println("===== Print the sorted order =====");
		// for each loop implementation in lambda
		list.stream().forEach(person -> System.out.println(person));
		
		// Task2: Create a Method that prints all elements in the list
		System.out.println("===== Print the sorted order =====");
		printCustomList(list, "",(p,c) -> true);

		// Task3: Create a Method that prints all people having lastNames begin with P

		System.out.println("===== Person Last Name Starts with P =====");
		// logic - using forEach function in streams

		list.stream().forEach(person ->

		{
			if (person.getLastName().startsWith("P")) {
				System.out.println(person);
			}
		}

		);

		System.out.println("===== Implemention of Custom Sorting string implementation =====");

		printCustomList(list, "P", (personObj, conditionString) -> personObj.getLastName().startsWith(conditionString));
		
		// Task4: Creating a custom logic for sorting list with custom string instead of

		System.out.println("===== Implemention of Custom Sorting string implementation =====");

		printCustomList(list, "N", (personObj, conditionString) -> personObj.getLastName().startsWith(conditionString));

		System.out.println("===== Implementation using sorting condition implemented class =====");

		CustomSortingCondition customSortingLambObj = (personObj, conditionString) -> personObj.getLastName().startsWith(conditionString);

		printCustomList(list, "K", customSortingLambObj);

		printCustomList(list, "Naga", customSortingLambObj);

	}

}

interface CustomSortingCondition {
	boolean checkCondition(Person personObj, String conditionString);
}

class CustomSortingConditionImplementation implements CustomSortingCondition {

	@Override
	public boolean checkCondition(Person personObj, String conditionString) {
		return personObj.getLastName().startsWith(conditionString);
	}
}
