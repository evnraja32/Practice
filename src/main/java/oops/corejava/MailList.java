package oops.corejava;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// A simple mailing list example.
	
  class AddressComparator implements Comparator<Address>{

	
	public int compare(Address o, Address a2) {
		// TODO Auto-generated method stub
		return o.getName().compareTo(a2.getName());

	  
	}
  }

	class Address {
		
	private String name;
	private String street;
	private String city;
	private String state;
	private String code;
	
	Address(String n, String s, String c,
	String st, String cd) {
	name = n;
	street = s;
	city = c;
	state = st;
	code = cd;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String toString() {
	return name + "\n" + street + "\n" +
	city + " " + state + " " + code;
	}
	
	}
	class MailList {
		
	public static void main(String args[]) {
		
	Set<Address> se = new HashSet<Address>();
	
	se.add(new Address("S  J.W. West", "11 Oak Ave",
			"Urbana", "IL", "61801"));
	
	se.add(new Address("V J.W. West", "11 Oak Ave",
	"Urbana", "IL", "61801"));
		
	Set<Address> ml = new TreeSet<Address>( new AddressComparator());
	
	System.out.println("1");
	
	ml.addAll(se);
	
	System.out.println("1");
	
	ml.add(new Address("J.W. West", "11 Oak Ave",
	"Urbana", "IL", "61801"));
	
	System.out.println("1");	
	
	ml.add(new Address("Ralph Baker", "1142 Maple Lane",
	"Mahomet", "IL", "61853"));
	
	System.out.println("1");
		
	ml.add(new Address("Tom Carlton", "867 Elm St",
	"Champaign", "IL", "61820"));
	
	System.out.println("1");
	
	// Display the mailing list.
	for(Address element : ml)
		
	System.out.println(element + "\n");
	
	System.out.println();
	}
}
