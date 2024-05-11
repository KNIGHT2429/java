/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderIdCounter = 1000; // Start order IDs from 1000
    private int orderId;
    private Member member; // Assuming you have a Member class
    private List<Product> products;
    private int quantity;

    public Order() {
        this.products = new ArrayList<>(); // Initialize the products list in the constructor
    }

    public int getOrderId() {
        return orderId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getItemPrice() * quantity;
        }
        return subtotal;
    }

    private int generateUniqueOrderId() {
        return orderIdCounter++;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId++).append("\n");
        sb.append("Quantity: ").append(quantity).append("\n");
        sb.append("Products:\n");
        
        for (Product product : products) {
            sb.append("  - ").append(product.getItemName()).append("\n");
        }

        sb.append("Subtotal: $").append(calculateSubtotal()).append("\n");
        return sb.toString();
    }

}