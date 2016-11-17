package oops.corejava;

import bsh.This;

public class TestOn_equalMethod_onIntegerDataType {

	public static void main(String[] args) {

		Integer i = 1000;
		Integer j = 1000;
		
		if(i != j) System.out.println("different object");
		if(i == j) System.out.println("same object");
		if(i.equals(j)) System.out.println("meaningfully same");
		
	}
	
	

}



