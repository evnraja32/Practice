package oops.controlstatems;

public class IfElseDemo {
	public static void main(String[] args) {
		int i = 10;

		// if statement
		if (i != 1) {
			System.out.println("if block executed in single if block");
		}

		if (i > 10) {
			System.out.println("if block of if...else... statement is executed");
		} else {
			System.out.println("else block of if...else... statement is executed");
		}

		i = -5;

		if (i == 0) {
			System.out.println("it is zero");
		} else if (i > 0) {
			System.out.println(i + " is positive");
		} else {
			System.out.println(i + " is negative");
		}
	}

}
