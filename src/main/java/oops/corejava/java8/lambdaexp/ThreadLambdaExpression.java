package oops.corejava.java8.lambdaexp;

public class ThreadLambdaExpression {

	public static void main(String[] args) {
		// General Way of implementing the Runnable using the instance of Runnable class
		Thread threadObj = new Thread(new ImplementsRunnable());
		threadObj.start();

		// Another General Way of implementing the Runnable using Annoymous class
		Thread secondThreadObj = new Thread(new Runnable() {

			@Override 
			public void run() {
				System.out.println("Inside Annoymous class implementation: " + this.getClass().getName());
			}
		}

		);

		secondThreadObj.start();

		
		// Implementing using lambda expressions
		new Thread(() -> System.out.println("Inside Lambda Expression Implementation")).start();
		
	}

}

class ImplementsRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside : " + this.getClass().getName());

	}

}