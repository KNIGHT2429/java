/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;

import java.util.Scanner;

public class Login {
    
    public boolean loginProcess() {
        Scanner scanner = new Scanner(System.in);
        
        //use to store the name and password
        String correctUsername = "lily";
        String correctPassword = "edwin12345";
        
        while (true){
            // Display the logo
            System.out.println("**********************************************");
            System.out.println("*        Yen Grocery Store POS System        *");
            System.out.println("**********************************************");
            System.out.println("Welcome to the Grocery Store POS System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            
            //try-catch" block to handle non-numeric input 
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            
                if (choice == 1) {
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    if (username.equals(correctUsername) && password.equals(correctPassword)) {
                        System.out.println("Login successful ^0^ [HI!]");
                        return true; // Return true for successful login
                    } else {
                        System.out.println("Login failed. Incorrect username or password！！！+_+");
                    }
                } else if (choice == 2) {
                    System.out.println("Exiting the Login System. Goodbye! ^o^ ~ Bye~Bye~");
                    return false; // Return false to indicate login failed
                } else {
                    System.out.println("Invalid choice. Please enter 1 to login or 2 to exit！(⊙ˍ⊙)？");
                }
            } catch (java.util.InputMismatchException e) {//InputMismatchException is use to catch when non-numeric is input 
                // Handle non-numeric input
                System.out.println("Invalid input. Please enter again (¬_¬ )！！.");
                scanner.nextLine(); // Consume the invalid input
            }
    
        }
     }
}
