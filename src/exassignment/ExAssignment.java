/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package exassignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExAssignment {

    public static void main(String[] args) {
        // Login
        Login loginInstance = new Login();

        // Call methods from the login class
        boolean loggedIn = loginInstance.loginProcess();

        if (loggedIn) {
            displayMainMenu();
            } else {
                System.out.println("");
            }
        }
        
        public static void displayMainMenu() {
            // Staff management
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            //store and have data
            List<Product> products = new ArrayList<>();
            Product.assignedProduct(products);
            
            List <Staff> staffs = new ArrayList<>();
            Staff.addInitialStaffMembers(staffs);
            
            List <Supplier> suppliers = new ArrayList<>();
            Supplier.addInitialSuppliers(suppliers);
            
            List <Member> members = new ArrayList<>();
            Member.addInitialMember(members);
            
            List<Order> orders = new ArrayList<>();

            do {
                System.out.println("");
                System.out.println("**********************************************");
                System.out.println("*                  Main Menu                 *");
                System.out.println("**********************************************");
                System.out.println("");
                System.out.println("1. Product Management");
                System.out.println("2. Member Management");
                System.out.println("3. Staff Management");
                System.out.println("4. Supplier Management");
                System.out.println("5. Payment Management");
                System.out.println("6. Summary Report");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");

                if (sc.hasNextInt()) {//check it is digit or not
                    choice = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    switch (choice) {
                        case 1:
                            products = Product.productManagement(products);
                            break;
                        case 2:
                            members = Member.memberManagement(members);
                            break;
                        case 3:
                            staffs = Staff.staffManagement(staffs);
                            break;
                        case 4:
                            suppliers = Supplier.supplierManagement(suppliers);
                            break;
                        case 5:
                            Payment payment = new Payment(orders);
                            orders = payment.paymentManagement(products, members);
                            break;
                        case 6:                  
                            SummaryReport summaryReport = new SummaryReport();
                            summaryReport.generateSummaryReport(orders); // Generate and display the summary report
                            break;
                        case 7:
                            System.out.println("Exiting. Have a nice day ^_^");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select again. (ㆆ_ㆆ)");
                    }

                } else {
                    // Handle non-integer input
                    System.out.println("Invalid input. Please enter a valid number between 1 and 7.");
                    sc.nextLine(); // Clear the invalid input from the buffer
                }
            } while (choice != 7);// if not equals to 7 will prompt error message
        }
}

