package oops.corejava;

class Bb extends ClassWithAbstract{

	@Override
	int add(int j, int k) {

		return j+k;
	}
	
	public static void main(String args[]) {
		
		Bb b = new Bb(); 
		
		System.out.println(b.add(1,2));
		
	}
	
}