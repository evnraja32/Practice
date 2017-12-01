package oops.corejava.java8.lambdaexp.collections;

public class PersonImplementsComparable implements Comparable<PersonImplementsComparable>{
	private String firstName;
	private String lastName;
	private int age;

	public PersonImplementsComparable(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	@Override
	public int compareTo(PersonImplementsComparable o) {
		// TODO Auto-generated method stub
		return age-o.getAge();
	}

}
