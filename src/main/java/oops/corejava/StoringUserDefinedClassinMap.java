package oops.corejava;

import java.util.HashMap;
import java.util.Map;

public class StoringUserDefinedClassinMap {

	public static void main(String[] args) {
	
		Map<User,Answer> map = new HashMap<User,Answer>();
		
		User user = new User();
		
		user.setId(1);
		
		user.setName("Sanal");
		
		user.setSalary(100);
		
		Answer ans = new Answer();
		
		ans.setA(1);
		
		ans.setB(2);
		
		map.put(user, ans);
		
		
		for(Map.Entry<User, Answer> entry : map.entrySet()){
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		
		}
	}

}

 class Answer {
	
	int a, b;

	@Override
	public String toString() {
		return "Answer [a=" + a + ", b=" + b + "]";
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	
}


 class User {

	 int id, salary;
	 
	 String name;	 	 

	@Override
	public String toString() {
		return "User [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}