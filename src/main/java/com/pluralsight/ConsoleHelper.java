// Grabbed ConsoleHelper from previous projects:
package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static String promptForString(String prompt) {
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public static int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            System.out.println();
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.println();
            }
        }
    }

    public static LocalDate promptForDate(String prompt){

        while(true){
            try{
                System.out.print(prompt + ": ");
                String dateAsString = scanner.nextLine();
                return LocalDate.parse(dateAsString);
            }
            catch(Exception ex){
                System.out.println("Invalid Entry, please enter a valid date (YYYY-MM-DD)");
            }
        }
    }

    public static float promptForFloat(String prompt) {
        System.out.println(prompt + ": ");
        float result = scanner.nextFloat();
        scanner.nextLine();
        return result;
    }

    public static long promptForLong(String prompt) {
        System.out.println(prompt + ": ");
        long result = scanner.nextLong();
        scanner.nextLine();
        return result;
    }

    public static double promptForDouble(String prompt) {
        while (true) {
            System.out.print(prompt + ": ");
            System.out.println();
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.println();
            }
        }
    }



}
    

