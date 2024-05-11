/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ACER
 */
public class SummaryReport {
   
    private static Scanner sc = new Scanner(System.in);
    public static void generateSummaryReport(List<Order> orders) {
        
    // Display the summary report header
    System.out.println("|------------------------|Summary Report|------------------------|");
    System.out.println("------------------------------------------------------------------");

    // Initialize a variable to keep track of the sales order number
    int salesOrderNum = 0;

    // Iterate through each order
    for (Order order : orders) {
        salesOrderNum++;
        
        // Calculate the total sales amount for the current order
        double totalSalesAmount = 0;
        for (Product product : order.getProducts()) {
            totalSalesAmount += product.getItemPrice() * order.getQuantity();
        }

        // Display the sales order number
        System.out.println("Sales Order No: " + salesOrderNum);
        System.out.println("");
        
        // Display the products sold in the current order
        System.out.println("Products Sold in this Order:");
        for (Product product : order.getProducts()) {
            System.out.println("Product Name: " + product.getItemName());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Subtotal: $" + (product.getItemPrice() * order.getQuantity()));
        }
        
        // Display the total amount of sales for the current order
        System.out.println("------------------------------------------------------------------");
        System.out.println("Total Sales Amount for this Order: $" + totalSalesAmount);
        System.out.println("Summary Report Showed. Press Enter to return to menu");sc.nextLine();
    }
}

}

