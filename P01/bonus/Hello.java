//Jesse McNary
import java.util.Scanner;

public class Hello{  
    public static void main(String[] args){  
	        
			Scanner scanObj = new Scanner(System.in);
			
			System.out.println("Please Enter Name");
			
			String name = scanObj.nextLine();
			
			System.out.println("Hello " + name + "!");
		}  
	}  