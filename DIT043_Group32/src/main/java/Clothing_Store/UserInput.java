package Clothing_Store;
import java.util.*;


public class UserInput {

	public static void main(String[] args) {

	}
	
	
    public static Scanner input = new Scanner(System.in);

    public static String readLine(String message){
        System.out.print(message);
        String comment = input.nextLine();
        return comment;
        
    }
    
    public static double readDouble(String message){
        System.out.println(message);
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }

    public static int readInt(String message){
        System.out.print(message);
        int number = input.nextInt();
        input.nextLine();
        return number;
    

    
    }
}
