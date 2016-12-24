package oops.controlstatems.loops;

public class BreakStatementDemo {
	public static void main(String[] args) {
		// Break statement demo
		int x = 1;
		for (;;) {
			System.out.println(x);
			x++;
			if (x > 10) {
				break;
			}
		}
	}
}
