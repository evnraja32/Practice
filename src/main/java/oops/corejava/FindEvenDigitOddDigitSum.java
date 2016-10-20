package oops.corejava;

public class FindEvenDigitOddDigitSum {

	public static void main(String[] args) {

		int b = 1237492983;
		
		String str = String.valueOf(b);
		
		System.out.println(str);
		
		char[] ch = str.toCharArray();
		
		char k = 2;
		
		System.out.println(" assigned vthout literal " + k);
		
		char p = '1';
		
		int j = p;
		
		System.out.println(j);
		
		for(char c : ch )
			System.out.println(c);
		
		
		int oddDigitSum = 0, evenDigitSum = 0;
		
		int a = ch[0] , d = ch [1];
		
		System.out.println("a : " + a + " b = " + d);
		
		for(int i = 0; i < ch.length; i++){
			
			if((ch[i]%2) == 0){
				
				System.out.println("ch[i] = " +ch[i]);
				
				//if u hav nt specified -48 char value is converted into int value
				
				evenDigitSum = evenDigitSum + ch[i] - 48 ;
				
				System.out.println("even digit sum  " +evenDigitSum);
			}
			
			else { 
				
				System.out.println("ch[i]" + ch[i]);

				oddDigitSum = oddDigitSum + ch[i] - 48;
				
				System.out.println("odd digit sum " + oddDigitSum);				
				
			}
			
		}
		
		System.out.println(evenDigitSum + " " + oddDigitSum);

	}

}
