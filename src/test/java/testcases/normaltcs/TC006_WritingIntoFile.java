package testcases.normaltcs;

import java.io.FileOutputStream;
import java.io.IOException;

public class TC006_WritingIntoFile {

	public static void main(String[] args) {
		try{
			FileOutputStream fos = new FileOutputStream("./src/main/resources/data/sampleLog.txt");
			String data = "Through file output i want to generate log reports";
			
			for(char c : data.toCharArray()){
				fos.write(c); 
			}
			
			fos.close(); 
			
			//while executing uncomment the next line to see how to throw exceptions
//			throw new IOException("cannot create file");
		}catch(IOException e){
			System.err.println("Error: "+e.getMessage());
			System.err.println("Error: "+e.getLocalizedMessage());
			System.err.println("Error: "+e.getCause());
			System.err.println("Error: "+e.getStackTrace());
			System.err.println("Error: "+e.getSuppressed());
		}

	}

}
