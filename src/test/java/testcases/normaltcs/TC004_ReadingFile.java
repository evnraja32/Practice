package testcases.normaltcs;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * for reading a file we have to use FileInputStream class
 * @param args
 */
public class TC004_ReadingFile {
	
	public static void main(String[] args) {
		FileInputStream fin = null;
		try{
			//attach the file to FileInputStream 
			fin = new FileInputStream("./src/main/resources/data/myfile.txt");
			System.out.println("File Contents: ");

			//read characters from FileInputStream and write them to monitor.
			//Repeat this till the End Of File
			int ch;
			while((ch = fin.read()) != -1){
				System.out.print((char)ch);
			}
			System.out.println();
			fin.close();
		}catch(IOException e){
			System.err.println("error :"+e.getMessage());
		}finally{
			System.out.println("Program ends");
		}

	}

}
