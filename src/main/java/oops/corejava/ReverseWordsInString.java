package oops.corejava;

public class ReverseWordsInString {

	public static void main(String[] args) {

		String str = "Hello Welcome Hi";
		
		String[] newString = str.split(" ");
		
		for (int k = 0 ; k< newString.length; k++){
			System.out.print(newString[(newString.length-1)-k] + " ");
		}

	}

}
