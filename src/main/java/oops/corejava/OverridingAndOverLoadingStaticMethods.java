package oops.corejava;

/**
 * 
 * @author Sunil Nalluru DATE : 10-10-2016 12:44 AM 
 *
 */

public class OverridingAndOverLoadingStaticMethods {

	public static void main(String[] args) {

		System.out.println(" Static method super class : a = " + StaticMethodsSuperClass.a +

				" static method superclass : b = " + StaticMethodsSuperClass.b +

				" a = " + StaticMethodsSuperClass.getA() + " a = " + StaticMethodsSuperClass.getA() +

				" a+b+c = " + StaticMethodsSuperClass.getSum(20, 30, 40));

		System.out.println(" static method subclass = " + StaticMethodSubClass.getA() + " : "
				
				+ StaticMethodSubClass.getSum(11, 12, 13));

	}

}
