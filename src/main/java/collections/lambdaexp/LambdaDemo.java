package collections.lambdaexp;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("spring", "node", "mkyong");
		
		lines.stream().forEach(value -> System.out.println(value));
		
		lines.stream().filter(x -> "spring".equals(x)).forEach(x->System.out.println(x));
	}
	
}
