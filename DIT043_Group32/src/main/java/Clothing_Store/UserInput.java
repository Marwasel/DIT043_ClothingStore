package Clothing_Store;
import java.util.*;


public class UserInput {


	
    public static Scanner sc = new Scanner(System.in);

    public static String readLine(String message){
        System.out.print(message);
        String comment = sc.nextLine();
        return comment;
        
    }
    
    public static double readDouble(String message){
        System.out.println(message);
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    public static int readInt(String message){
        System.out.print(message);
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    

    
    }
}
