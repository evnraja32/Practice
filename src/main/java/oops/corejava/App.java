package oops.corejava;

/**
 * @author Sunil Nalluru Date
 *
 */

public class App {

	static {

		int a;

		System.out.println("inside static aa");

		{
			System.out.println(" non static");
		}
	}

	App() {

		System.out.println("Inside constuctor");
	}

	static {
		System.out.println(" Inside static block");
	}

	static void app() {

		System.out.println("Inside app medthod");
	}

	void display() {
		System.out.println("Inside display");
	}

	public static void main(String[] args) {
		app();

		App app = new App();

		app.display();

		System.out.println("Hello World!");

		StaticBlockTest.block();
	}
}