package oops.corejava;

public class UpDownCasting {
	public static void main(String[] args) {
		Dog dog = new Dog();	
		System.out.println(dog);

		Animal animal = dog;	//upcast: casting an object to super class
		System.out.println(animal);

		try {
			Dog dog1 = (Dog) (new Animal());
			System.out.println(dog1);
		} catch (ClassCastException e) {
			System.err.println("pages.Animal cannot be cast to pages.Dog");
			Dog dog2 = (Dog)animal;	//downcast: casting an upper class object to again lower class
			System.out.println(dog2);
		}
		
		//Example 2:
		Animal an = new Animal();
		Dog d = (Dog)an;
		
	}
}
