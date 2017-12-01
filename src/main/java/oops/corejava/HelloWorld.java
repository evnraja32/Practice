package oops.corejava;
public class HelloWorld{

     public static void main(String []args){
       
    String a = "fffafiuqhcnjbhujxcefijkm";

    String output = "";
 
    while(a.length() != 0){
        
        output = output+a.charAt(0);
        a = a.replaceAll(a.charAt(0)+"","");        
    }

   
    System.out.println(output);
   
        
     }
     
     
     
}
