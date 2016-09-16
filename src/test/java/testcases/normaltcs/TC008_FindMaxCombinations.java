package testcases.normaltcs;

public class TC008_FindMaxCombinations {
	public static void main(String[] args) {
		int asciiValueOf_caps_A = (int)'A';
		System.out.println("Ascii Value :"+asciiValueOf_caps_A);
		
		for(int i=0 ; i <= 25 ; i++){
			for(int j=0 ; j <= 25 ; j++){
				for(int k=0 ; k <= 25 ; k++){
					System.out.println(
							    ((char)(asciiValueOf_caps_A+i))
							+""+((char)(asciiValueOf_caps_A+j))
							+""+((char)(asciiValueOf_caps_A+k))
							);
				}
			}
		}
	}
}
