package oops.corejava;

import java.util.HashMap;
import java.util.Map;


public class TestOn_equalMethod_onObject {

	public static void main(String[] args) {

		Maruthi a = new Maruthi("Red", "AP04 AT 4469");
		Maruthi b = new Maruthi("Red", "AP04 AT 4469");

		if(a != b) System.out.println("different object");
		if(a.equals(b)) System.out.println("meaningfully same");

		
		Map<Car, String> m = new HashMap<Car,String>();
		
		m.put(new Maruthi("Red", "AP04 AT 4469") , "Suresh");
		m.put(new Maruthi("Red", "AP04 AT 4469") , "Suresh");
		m.put(new Maruthi("Red", "AP04 AT 4469") , "Suresh");
		m.put(new Maruthi("Red", "AP04 AT 4469") , "Suresh");
		
		for(Object o : m.keySet()){
			System.out.println(m.get(o));
		}
		
	}

}



class Car{
	String color;
	String regNo;

	public String toString(){
		return "The is a "+color+" color "+this.getClass().getSimpleName()+" having Reg.No : "+regNo;
	}

	private String getCarColor(){
		return color;
	}

	private String getCarRegNo(){
		return regNo;
	}

	public boolean equals(Object obj) {
		return (obj instanceof Car) && ((Car)obj).getCarColor() == color && ((Car)obj).getCarRegNo() == regNo;
	}

}


class Maruthi extends Car{
	public  Maruthi(String color,String regNo){
		this.color = color;
		this.regNo = regNo;
	}
}


