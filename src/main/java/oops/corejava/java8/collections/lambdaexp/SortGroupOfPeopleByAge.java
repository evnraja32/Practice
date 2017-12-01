package oops.corejava.java8.collections.lambdaexp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class SortGroupOfPeopleByAge {
	protected static List<Person> list = null;
	protected static List<PersonImplementsComparable> list2 = null;

	public static void main(String[] args) {

		list = Arrays.asList(new Person("Venkata", "NagaRaja", -5), new Person("Asif", "Palli", 4),
				new Person("Sekar", "KS", 3), new Person("Narasimha", "PV", 2), new Person("Rajan", "Rajmani", 1),
				new Person("Zaakeer", "Hussian", 0), new Person("Venkata", "NagaChaitanya", -1));

		list2 = Arrays.asList(new PersonImplementsComparable("Venkata", "NagaRaja", -5),
				new PersonImplementsComparable("Asif", "Palli", 4), new PersonImplementsComparable("Sekar", "KS", 3),
				new PersonImplementsComparable("Narasimha", "PV", 2),
				new PersonImplementsComparable("Rajan", "Rajmani", 1),
				new PersonImplementsComparable("Zaakeer", "Hussian", 0),
				new PersonImplementsComparable("Venkata", "NagaChaitanya", -1));
		System.out.println("\n===== Lambda Implementation =====\n");
		collectionsDemoWithLambda();

	}

	public static void collectionsDemoWithLambda() {
		//Using Comparator Lambda
		Collections.sort(list, ((p1, p2) -> (p1.getAge() - p2.getAge())));
		list.stream().forEach(p -> System.out.println(p));
		
		
		//Using Comparable
		Collections.sort(list2);
		list.stream().forEach(p -> System.out.println(p));
	}

}
