package oops.corejava;

public class FibanocciSeries2 {

	public static void main(String[] args) {

		// declare the size of the array based on the no of fibanocci series
		
		int a[] = new int[10];

		a[0] = 0;
		a[1] = 1;

		for (int k = 2; k < a.length; k++)

			a[k] = a[k - 1] + a[k - 2];

		for (int l : a)

			System.out.print(" " + l);

	}

}
