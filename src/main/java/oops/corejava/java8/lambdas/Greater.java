package oops.corejava.java8.lambdas;

public class Greater {
	public void perform() {
		System.out.println("Hello world greater");
	}

	public static void main(String[] args) {
		Greater greater = new Greater();
		greater.perform();

		MyLambda klk = () -> System.out.println("jhgjhgh");

		MyLambdaWithSignature doubleIntFunction = (int a) -> a * 2;
	}
}

interface MyLambda {
	void voidFun();
}

interface MyLambdaWithSignature {

	int add(int a);
}