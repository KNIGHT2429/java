/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Payment {

    private boolean addAnother = true;
    private Product product;
    private int itemQuantity;
    private List<Order> orders;

    public Payment(List<Order> orders) {
        this.orders = orders;
    }

    public Payment(Product product, int itemQuantity) {
        this.product = product;
        this.itemQuantity = itemQuantity;
        this.addAnother = addAnother;

    }

    public boolean isAddAnother() {
        return addAnother;
    }

    public Product getProduct() {
        return product;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setAddAnother(boolean addAnother) {
        this.addAnother = addAnother;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double calculateSubTotal() {
        return itemQuantity * product.getItemPrice();
    }
      
    public static List<Order> paymentManagement(List<Product> products, List<Member> members) {
       
        Scanner scanner = new Scanner(System.in);
        boolean addAnother = true;
        int salesOrderNum = 0;   
        float finalAmount = 0;
        List<Order> orders = new ArrayList<>(); 
        float discount = 0;
        
        do {
            salesOrderNum++;
            System.out.println("");
            System.out.println("**********************************************");
            System.out.println("*               Payment Module               *");
            System.out.println("**********************************************");
            System.out.println("");
            System.out.println("Sales Order No: " + salesOrderNum);
            

            List<Order> currentOrder = new ArrayList<>();
        
            do {
                System.out.print("Enter Product Code: ");
                String inputProductCode = scanner.nextLine();

                if (inputProductCode.equalsIgnoreCase("x")) {
                    break; // Finish entering products for this order
                }
                
                // Check if the entered product code exists in the list of products
                Product selectedProduct = null;
                for (Product p : products) {
                    if (inputProductCode.equalsIgnoreCase(p.getItemCode())) {
                        selectedProduct = p;
                        break;
                    }
                }

                if (selectedProduct == null) {
                    System.out.println("Error: Product with code '" + inputProductCode + "' does not exist.");
                    
                    continue; // Continue to the next iteration of the loop
                }


                int inputProductQuantity;
                while (true) {
                    System.out.print("Enter Product Quantity: ");
                    try {
                        inputProductQuantity = Integer.parseInt(scanner.nextLine());

                        if (inputProductQuantity <= 0) {
                            System.out.println("Error: Please enter a positive quantity.");
                            continue; // Repeat the quantity input prompt
                        }

                        if (inputProductQuantity > selectedProduct.getItemQuantity()) {
                            System.out.println("Error: The entered quantity is more than the available quantity (" + selectedProduct.getItemQuantity() + ")");
                            continue; // Repeat the quantity input prompt
                        }

                        // Quantity is valid, exit the loop
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid numeric quantity.");
                    }
                }
            
            Order newOrder = new Order();
            newOrder.setQuantity(inputProductQuantity);
            newOrder.getProducts().add(selectedProduct);

            Payment payment = new Payment(selectedProduct, inputProductQuantity);
            double subTotal = payment.calculateSubTotal();
            
            System.out.println("");
            System.out.println("|-----Order Details-----|");
            System.out.println("    Product: " + selectedProduct.getItemName());
            System.out.println("    Product Code: " + selectedProduct.getItemCode());
            System.out.println("    Quantity: " + inputProductQuantity);
            System.out.println("    Price per unit: $" + selectedProduct.getItemPrice());
            System.out.println("    Subtotal: $" + subTotal);
            System.out.println("");
            
            currentOrder.add(newOrder); // Adding the order to the orders list
            
            if (!currentOrder.isEmpty()) {
                orders.addAll(currentOrder); // Add the orders for this sales order
                finalAmount += subTotal;
                System.out.println("Total Amount for Sales Order No " + salesOrderNum + ": $" + subTotal);
                break;
            }
       
        } while (true);
        
        System.out.print("\nAdd another order? (Y/N): ");
        String addAnotherOrderChoice = scanner.nextLine();
        addAnother = addAnotherOrderChoice.equalsIgnoreCase("y");
    } while (addAnother);
    
    // Display the final cumulative total
    System.out.println("\nFinal Grand Total: $" + finalAmount);
    
    boolean proceedToPayment = true;

    while (proceedToPayment) {
        // Check if the user is a member
        System.out.println("");
        System.out.print("Are you a member? (Y/N): ");
        String isMemberInput = scanner.nextLine();
        boolean isMember = isMemberInput.equalsIgnoreCase("Y");

        if (isMember) {
            boolean isVerified = false;

            while (!isVerified) {
                System.out.print("Enter your phone number for verification: ");
                String phoneNumber = scanner.nextLine();

                // Verify the member by searching for the phone number in the members list
                for (Member member : members) {
                    if (phoneNumber.equals(member.getHpNo())) {
                        isVerified = true;
                        break;
                    }
                }

                if (!isVerified) {
                    System.out.println("Member verification failed. Please enter a valid phone number.");
                    
                    System.out.println("");
                }
            }

            // Apply a 5% discount for verified members
            discount = (float)(finalAmount * 0.05);
            finalAmount -= discount;
            System.out.println("");
            System.out.println("Member verified. You received a 5% discount of $" + discount);
            System.out.println("The final amount is $" + finalAmount);

        }
        
        System.out.println("");
        System.out.print("Confirm payment? (Y/N): ");
        String paymentConfirmationChoice = scanner.nextLine();

        if (paymentConfirmationChoice.equalsIgnoreCase("n")) {
            System.out.println("");
            System.out.println("Payment canceled");
            break;
        } else if (paymentConfirmationChoice.equalsIgnoreCase("y")) {
            System.out.println("");
            System.out.println("Processing payment...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            boolean paymentSuccessful = false;
                while (!paymentSuccessful) {

                    // Prompt the user to enter the payment amount
                    System.out.println("");
                    System.out.println("Enter the payment amount (or 'x' to cancel): ");
                    String paymentAmountInput = scanner.nextLine();

                    if (paymentAmountInput.equalsIgnoreCase("x")) {
                        System.out.println("Payment canceled");
                        break; // Exit the payment input loop
                    }

                    try {
                        double paymentAmount = Double.parseDouble(paymentAmountInput);

                        if (paymentAmount < finalAmount) {
                            System.out.println("Payment amount is low or not correct. Please enter a correct amount to pay.");
                            System.out.println("");
                        } else {
                            float change = (float)(paymentAmount - finalAmount);
                            System.out.println("");
                            System.out.println("|-------|Payment successful|-------|");
                            System.out.println("    Change: $" + change);
                            System.out.println("");
                           
                           System.out.print("Do you want to print the receipt? (Y/N): ");
                           String printReceiptChoice = scanner.nextLine();
                           if (printReceiptChoice.equalsIgnoreCase("Y")) {
                           System.out.println("");

                                /// Print the receipt
                            System.out.println("        Yen Grocery Store        ");
                            System.out.println("            Receipt              ");
                            System.out.println("        Tel:+1(630)666-0123      ");
                            System.out.println("        info@yengrocery.com      ");
                            System.out.println("---------------------------------");
                            for (Order order : orders) {
                                System.out.println("");
                                System.out.println("    Product: " + order.getProducts().get(0).getItemName());
                                System.out.println("    Quantity: " + order.getQuantity());
                                System.out.println("    Subtotal: $" + order.getProducts().get(0).getItemPrice() * order.getQuantity());
                                System.out.println("");
    
                            }
                                // Display the discount
                                System.out.println("    Discount (5%): $" + discount);
                                // Display the change
                                System.out.println("    Total Amount: $" + finalAmount);
                                System.out.println("    Change: $" + change);
                                System.out.println("");
                                System.out.println("        Thank You");
                                System.out.println("Receipt printed. Press enter to return to the main menu.");scanner.nextLine();
                            } else {
                                System.out.println("Receipt not printed. Returning to the main menu.");
}

                            paymentSuccessful = true; // Payment is successful, exit the loop
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid numeric amount or 'x' to cancel.");
                    }
                }

                proceedToPayment = false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
   
    }
        return orders;
    }
    
}