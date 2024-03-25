package Auxiliary;
import java.util.Scanner;

public class CheckType {
    
    public static int getInt(String message, String errorMessage) {
        Scanner sc = new Scanner(System.in);
        String input;
        int output = 0;
        boolean validValue = false;

        while (!validValue) {
            System.out.print(message);
            input = sc.nextLine();
            try {
                output = Integer.parseInt(input);
                validValue = true;
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
        return output;
    }
}
