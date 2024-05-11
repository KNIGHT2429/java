/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;//It does not allow duplicate elements.
import java.util.Set;//defines elements in which each element can appear at most once (no duplicates).


/**
 *
 * @author ACER
 */
public class Product {

    
    private String itemName;
    private String itemCode;
    private int itemQuantity;
    private String itemCategory;
    private double itemPrice;
    private int totalCategory;
    private static List <Product> products = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    public Product(){
        this.itemName = "";
        this.itemCode = "";
        this.itemQuantity = 0;
        this.itemCategory = "";
        this.itemPrice = 0;
        totalCategory++; //track of the total number of categories.
    }

    //declares a constructor named product with five parameters that is use for to provide specific values for these properties when creating a product object.
    public Product(String itemName, String itemCode, int itemQuantity, String itemCategory, double itemPrice) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.itemQuantity = itemQuantity;
        // Use the setter for category validation
        setItemCategory(itemCategory);
        this.itemPrice = itemPrice;
        totalCategory++;
    }

    // Getter methods for each attribute
    public String getItemName() {
        return itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public String getItemCategory() {
        return itemCategory;
    }
    
    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCode(String itemCode) {
        if (isValidItemCode(itemCode)) {
            this.itemCode = itemCode;
        } else {
            throw new IllegalArgumentException("Item code must not exceed 6 characters.");
        }
    }
    
    private boolean isValidItemCode(String itemCode) {
        return itemCode != null && itemCode.length() <= 6;
    }

    public void setItemQuantity(int itemQuantity) {
         if (itemQuantity >= 0) {
            this.itemQuantity = itemQuantity;
        } else {
            throw new IllegalArgumentException("Quantity must be a non-negative integer.");
        }
    }

    public void setItemCategory(String itemCategory) {
         // Define a list of valid categories
        List<String> validCategories = Arrays.asList(
            "Pet Care", "Baby Item", "Household & Cleaning Supplies",
            "Health Care", "Personal Care", "Frozen Foods", "Baking",
            "Packages Foods", "Beverages", "Bread & Bakery", "Snacks",
            "Condiments & Spices", "Deli", "Fish & Seafood", "Meat",
            "Dairy", "Canned Goods", "Vegetables", "Fruits"
        );

        if (validCategories.contains(itemCategory)) {
            this.itemCategory = itemCategory;
        } else {
            throw new IllegalArgumentException("Invalid item category.");
        }
    }

    public void setItemPrice(double itemPrice) {
        if (itemPrice >= 0) {
            this.itemPrice = itemPrice;
        } else {
            throw new IllegalArgumentException("Price must be a non-negative number.");
        }
    }

    @Override //use it to display
    public String toString() {
        return "Product{" +
                "itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemCategory='" + itemCategory + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
    
    //this is array list to declare and track down the value inside the array list
    public static List<Product> productManagement(List<Product> products){
        // Implement staff management logic here
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("*          Product Management Menu           *");
        System.out.println("**********************************************");
        System.out.println("");
        
                System.out.println("1. Create new Product");
                System.out.println("2. Search Specific Product");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Display List Of Product");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();//declare like c int choice then is integer
                sc.nextLine(); // Consume the newline character
               
                switch (choice) {//use switch for doing the menu
                    case 1:
                        createProduct(products); //why the products is inside because want to take the products arraylist value out
                        break;
                    case 2:
                        retrieveSpecificProduct(products);
                        break;
                    case 3:
                        updateProduct(products);
                        break;
                    case 4:
                        deleteProduct(products);
                        break;
                    case 5:
                        addInitialProduct(products);
                        break;
                    case 6:
                        System.out.println("Have a nice day ^_^");
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select again. (ㆆ_ㆆ)");
                    }
                return products;// go back to the menu of main
    }
    
    // Add management functionalities
    public static void createProduct(List<Product> products) {
        boolean createAnotherProduct;//for ask user yes or no , is like true or false
        System.out.println("**********************************************");
        System.out.println("*             Create New Product             *");
        System.out.println("**********************************************");
        System.out.println("");
        do {

            System.out.print("Enter Product Name: ");
            String itemName = sc.nextLine();

            System.out.print("Enter Product Code: ");
            String itemCode = sc.nextLine();

            int itemQuantity;
                while (true) {
                    try {
                        System.out.print("Enter Product Quantity: ");
                        itemQuantity = Integer.parseInt(sc.nextLine());//if enter character it will display error message
                        break; // Exit the loop if parsing succeeds
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for Quantity.");
                    }
            }

            String itemCategory;
                while (true) {
                    System.out.print("Enter Product Category: ");
                    itemCategory = sc.nextLine();

                    // Validate the item category
                    String[] validCategories = {
                        "Pet Care", "Baby Item", "Household & Cleaning Supplies",
                        "Health Care", "Personal Care", "Frozen Foods", "Baking",
                        "Packages Foods", "Beverages", "Bread & Bakery", "Snacks",
                        "Condiments & Spices", "Deli", "Fish & Seafood", "Meat",
                        "Dairy", "Canned Goods", "Vegetables", "Fruits"
                    };

                    boolean isValidCategory = false;
                    for (String category : validCategories) {
                        if (category.equalsIgnoreCase(itemCategory)) {
                            isValidCategory = true;
                            break;
                        }
                    }

                    if (isValidCategory) {
                        break; // Exit the loop if the category is valid
                    } else {
                        System.out.println("Invalid category. Please enter a valid category.");
                    }
                }

            double itemPrice;
             while (true) {
                 try {
                     System.out.print("Enter Product Price: ");
                     itemPrice = Double.parseDouble(sc.nextLine());//if got character will display error message
                     break; // Exit the loop if parsing succeeds
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid input. Please enter a valid number for Price.");
                 }
            }

            //display let user see the product they type is correct or  not
            System.out.println("");
            System.out.println("|----New Product details----|");//finish type will display the new add
            System.out.println("    Product Name: " + itemName);
            System.out.println("    Product Code: " + itemCode);
            System.out.println("    Product Quantity: " + itemQuantity);
            System.out.println("    Product Category: " + itemCategory);
            System.out.println("    Product Price: " + itemPrice);
            System.out.println("");

            System.out.print("Confirm creation of this product? (yes/no): ");//ask user yes no to confirm creation
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {//if yes will store inside the array list of products
                Product product = new Product(itemName, itemCode, itemQuantity, itemCategory, itemPrice);
                products.add(product);//if confirm add in the array list
                System.out.println("Product has been added.");
                System.out.println("");
            } else {
                System.out.println("Product creation has been canceled.");
                System.out.println("");
            }

                // Ask the user if they want to create another product
                System.out.print("Do you want to create another product? (yes/no): ");
                String continueInput = sc.nextLine();
                createAnotherProduct = continueInput.equalsIgnoreCase("yes");
                 System.out.println("");

        } while (createAnotherProduct);

            // After creating one or more products, return to the product management menu
            productManagement(products);
    
    }

    //Display new product
    public static void retrieveListOfProduct(List<Product> products) {
        for (Product p : products) {
            System.out.println("|----New Product details----|");
            System.out.println("    Product Name: " + p.getItemName());
            System.out.println("    Product Code: " + p.getItemCode());
            System.out.println("    Product Quantity: " + p.getItemQuantity());
            System.out.println("    Product Category: " + p.getItemCategory());
            System.out.println("    Product Price: " + p.getItemPrice());
            System.out.println("");
        }
        // After creating one or more products, return to the product management menu
        productManagement(products);
    }
    
    //Search product
    public static void retrieveSpecificProduct(List<Product> products){
        System.out.println("**********************************************");
        System.out.println("*               Search Product               *");
        System.out.println("**********************************************");
        System.out.println("");
        
        System.out.print("Enter Product Code: ");
        String itemCode = sc.nextLine().trim(); // Store the entered item code

        boolean found = false; // Flag to track if a match is found

        for (Product p : products) {
            if (p.getItemCode().equalsIgnoreCase(itemCode)) {
                System.out.println("|-----Product details----|");
                System.out.println("    Product Name: " + p.getItemName());
                System.out.println("    Product Code: " + p.getItemCode());
                System.out.println("    Product Quantity: " + p.getItemQuantity());
                System.out.println("    Product Category: " + p.getItemCategory());
                System.out.println("    Product Price: " + p.getItemPrice());

                found = true; // Set the flag to true if a match is found
                break; // Exit the loop once a match is found
            }
        }
        
        if (!found) {
            System.out.println("Product with code " + itemCode + " not found.");
            System.out.println("");
        }
        
        // After creating one or more products, return to the product management menu
        productManagement(products);
    }
    
    //Edit product detail
    public static void updateProduct(List<Product> products) {
        boolean updateAnotherProduct;
        System.out.println("**********************************************");
        System.out.println("*               Update Product               *");
        System.out.println("**********************************************");
        System.out.println("");

    do {
        System.out.print("Enter item code that needs to be updated: ");
        String itemCode = sc.nextLine();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getItemCode().equalsIgnoreCase(itemCode)) {
                Product p = products.get(i);

                // Display current product details
                System.out.println("");
                System.out.println("|----Current Product details----|");
                System.out.println("    Product Name: " + p.getItemName());
                System.out.println("    Product Code: " + p.getItemCode());
                System.out.println("    Product Quantity: " + p.getItemQuantity());
                System.out.println("    Product Category: " + p.getItemCategory());
                System.out.println("    Product Price: " + p.getItemPrice());
                System.out.println("");
                
                System.out.print("Confirm update of this product? (yes/no): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    System.out.print("Enter new item name: ");
                    String newItemName = sc.nextLine();
                    p.setItemName(newItemName);

                    int newItemQuantity;

                    while (true) {
                        try {
                            System.out.print("Enter new item quantity: ");
                            newItemQuantity = Integer.parseInt(sc.nextLine());
                            p.setItemQuantity(newItemQuantity); // Assuming setItemQuantity updates the quantity in the Product object
                            break; // Exit the loop if parsing and update succeed
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for Quantity.");
                        }
                    }

                    String newItemCategory;
                    while (true) {
                        System.out.print("Enter new item category: ");
                        newItemCategory = sc.nextLine();

                        // Validate the new item category
                        String[] validCategories = {
                            "Pet Care", "Baby Item", "Household & Cleaning Supplies",
                            "Health Care", "Personal Care", "Frozen Foods", "Baking",
                            "Packages Foods", "Beverages", "Bread & Bakery", "Snacks",
                            "Condiments & Spices", "Deli", "Fish & Seafood", "Meat",
                            "Dairy", "Canned Goods", "Vegetables", "Fruits"
                        };

                        boolean isValidCategory = false;
                        for (String category : validCategories) {
                            if (category.equalsIgnoreCase(newItemCategory)) {
                                isValidCategory = true;
                                break;
                            }
                        }

                        if (isValidCategory) {
                            p.setItemCategory(newItemCategory); // Assuming setItemCategory updates the category in the Product object
                            break; // Exit the loop if the category is valid and update succeeds
                        } else {
                            System.out.println("Invalid category. Please enter a valid category.");
                        }
                    }

                    
                    double newItemPrice;
                    while (true) {
                        try {
                            System.out.print("Enter new price: ");
                            newItemPrice = Double.parseDouble(sc.nextLine());
                            p.setItemPrice(newItemPrice); // Assuming setItemPrice updates the price in the Product object
                            break; // Exit the loop if parsing and update succeed
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number for Price.");
                        }
                    }


                    products.set(i, p);
                    System.out.println("Product details updated.");
                    System.out.println("");
                } else {
                    System.out.println("Product update has been canceled.");
                    System.out.println("");
                }
            }
        }

        // Ask the user if they want to update another product
        System.out.print("Do you want to update another product? (yes/no): ");
        String continueInput = sc.nextLine();
        updateAnotherProduct = continueInput.equalsIgnoreCase("yes");
        System.out.println("");
    } while (updateAnotherProduct);
    
    // After creating one or more products, return to the product management menu
        productManagement(products);
}

    
    //delete staff 
    public static void deleteProduct(List<Product> products) {
    boolean deleteAnotherProduct = true; // Flag to control the loop
    
    System.out.println("**********************************************");
    System.out.println("*               Delete Product               *");
    System.out.println("**********************************************");
    System.out.println("");

    while (deleteAnotherProduct) {
        System.out.print("Enter Product Code to delete: ");
        String itemCode = sc.nextLine();

        boolean found = false; // Flag to track if the product was found

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getItemCode().equalsIgnoreCase(itemCode)) {
                while (true) {
                    System.out.println("Are you sure you want to delete " + itemCode + "? (yes/no): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {
                        products.remove(i);
                        
                        System.out.println(itemCode + " has been deleted.");
                        System.out.println("");
                        found = true; // Product was found and deleted
                    } else if (confirm.equalsIgnoreCase("no")) {
                        System.out.println(itemCode + " deletion has been canceled.");
                        System.out.println("");
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no' to delete the product.");
                        System.out.println("");
                        continue;
                    }

                    break; // Exit the loop after handling deletion
                }

                if (found) {
                    break; // Exit the loop since the product was found and deleted
                }
            }
        }

        if (!found) {
            System.out.println("No product with the code " + itemCode + " found.");
            System.out.println("");
        }

        // Ask the user if they want to delete another product
        System.out.print("Do you want to delete another product? (yes/no): ");
        String deleteAnotherInput = sc.nextLine();
        deleteAnotherProduct = deleteAnotherInput.equalsIgnoreCase("yes");
        System.out.println("");
        sc.nextLine();

    }

    // After deleting one or more products, return to the product management menu
    productManagement(products);
}

   //arraylist for to store the staff and display it
    public static void assignedProduct(List<Product> products){
        Product product1 = new Product("Pet Food", "PC001", 40, "Pet Care", 30.00);
        Product product2 = new Product("Pet Shampoo", "PC002", 40, "Pet Care", 9.00);
        Product product3 = new Product("Pet Treats", "PC003", 15, "Pet Care", 5.00);
        Product product4 = new Product("Pet Toys", "PC004", 15, "Pet Care", 5.00);

        Product product5 = new Product("Baby food", "BT001", 15, "Baby Item", 110.00);
        Product product6 = new Product("Diapers", "BT002", 15, "Baby Item", 40.00);
        Product product7 = new Product("Wet Wipes", "BT003", 15, "Baby Item", 1.00);
        Product product8 = new Product("Lotion", "BT004", 15, "Baby Item", 20.00);

        Product product9 = new Product("Laundry Detergent", "HCS001", 15, "Household & Cleaning Supplies", 15.00);
        Product product10 = new Product("Dishwashing Liquid", "HCS002", 15, "Household & Cleaning Supplies", 5.00);
        Product product11 = new Product("Paper Towels", "HCS003", 15, "Household & Cleaning Supplies", 20.00);
        Product product12 = new Product("Tissues", "HCS004", 15, "Household & Cleaning Supplies", 6.00);
        Product product13 = new Product("Trash Bag", "HCS005", 15, "Household & Cleaning Supplies", 3.00);
        Product product14 = new Product("Aluminum Foil", "HCS006", 15, "Household & Cleaning Supplies", 2.00);
        Product product15 = new Product("Zip Bags", "HCS007", 15, "Household & Cleaning Supplies", 2.00);

        Product product16 = new Product("Cough Drop", "HC001", 15, "Health Care", 20.00);
        Product product17 = new Product("Panadol", "HC002", 15, "Health Care", 14.00);
        Product product18 = new Product("Menthol plaster", "HC003", 15, "Health Care", 5.00);
        Product product19 = new Product("Cleaning Alcohol", "HC004", 15, "Health Care", 9.00);
        Product product20 = new Product("Andacids", "HC005", 15, "Health Care", 12.00);

        Product product21 = new Product("Shampoo", "PS001", 15, "Personal Care", 2.00);
        Product product22 = new Product("Body Shower", "PS002", 15, "Personal Care", 2.00);
        Product product23 = new Product("Conditioner", "PS003", 15, "Personal Care", 2.00);
        Product product24 = new Product("Toothpaste", "PS004", 15, "Personal Care", 2.00);
        Product product25 = new Product("Deodorant", "PS005", 15, "Personal Care", 2.00);

        Product product26 = new Product("Pizza", "FC001", 15, "Frozen Foods", 8.00);
        Product product27 = new Product("Fish", "FC002", 15, "Frozen Foods", 20.00);
        Product product28 = new Product("Ice cream", "FC003", 15, "Frozen Foods", 10.00);
        Product product29 = new Product("Ready Meals", "FC004", 15, "Frozen Foods", 12.00);
        Product product30 = new Product("Meat", "FC005", 15, "Frozen Foods", 10.00);
        Product product31 = new Product("Fish Ball", "FC006", 15, "Frozen Foods", 8.00);

        Product product32 = new Product("Flour", "BK001", 15, "Baking", 3.00);
        Product product33 = new Product("Powdered sugar", "BK002", 15, "Baking", 1.00);
        Product product34 = new Product("Baking Powder", "BK003", 15, "Baking", 8.00);
        Product product35 = new Product("Cocoa", "BK004", 15, "Baking", 25.00);

        Product product36 = new Product("Pasta", "PF001", 15, "Packages Foods", 4.00);
        Product product37 = new Product("Rice", "PF002", 15, "Packages Foods", 20.00);
        Product product38 = new Product("Cereal", "PF003", 15, "Packages Foods", 10.00);
        Product product39 = new Product("Macaroni", "PF004", 15, "Packages Foods", 4.00);
        Product product40 = new Product("Noodles", "PF005", 15, "Packages Foods", 5.00);

        Product product41 = new Product("Coffee", "BR001", 15, "Beverages", 12.00);
        Product product42 = new Product("Teabags", "BR002", 15, "Beverages", 5.00);
        Product product43 = new Product("Milk", "BR003", 15, "Beverages",6.00);
        Product product44 = new Product("Soda", "BR004", 15, "Beverages", 2.00);      
        Product product45 = new Product("Juice", "BR005", 15, "Beverages", 3.00);
        Product product46 = new Product("Beer", "BR006", 15, "Beverages", 8.00);

        Product product47 = new Product("Bread", "BB001", 15, "Bread & Bakery", 3.00);
        Product product48 = new Product("Tortillas", "BB002", 15, "Bread & Bakery", 9.00);
        Product product49 = new Product("Cookies", "BB003", 15, "Bread & Bakery",6.00);

        Product product50 = new Product("Chips", "SN001", 15, "Snacks", 8.00);      
        Product product51 = new Product("Popcorn", "SN002", 15, "Snacks", 7.00);
        Product product52 = new Product("Nuts", "SN003", 15, "Snacks", 5.00);
        Product product53 = new Product("Crackers", "SN004", 15, "Snacks", 6.00);

        Product product54 = new Product("Black Pepper", "CS001", 15, "Condiments & Spices", 8.00);      
        Product product55 = new Product("Sugar", "CS002", 15, "Condiments & Spices", 3.00);
        Product product56 = new Product("Olive Oil", "CS003", 15, "Condiments & Spices", 15.00);
        Product product57 = new Product("Ketchup", "CS004", 15, "Condiments & Spices", 5.00);
        Product product58 = new Product("Oregano", "CS005", 15, "Condiments & Spices", 6.00);
        Product product59 = new Product("Cinnamon", "CS006", 15, "Condiments & Spices", 13.00);
        Product product60 = new Product("Mayonnaise", "CS007", 15, "Condiments & Spices", 13.00);

        Product product61 = new Product("Cheese", "DL001", 15, "Deli", 6.00);      
        Product product62 = new Product("Ham", "DL002", 15, "Deli", 10.00);

        Product product63 = new Product("Shrimp", "FS001", 15, "Fish & Seafood", 28.00);      
        Product product64 = new Product("Crab", "FS002", 15, "Fish & Seafood", 30.00);
        Product product65 = new Product("Cod", "FS003", 15, "Fish & Seafood", 25.00);      
        Product product66 = new Product("Tuna", "FS004", 15, "Fish & Seafood", 10.00);
        Product product67 = new Product("Salmon", "FS005", 15, "Fish & Seafood", 30.00);      

        Product product68 = new Product("Chicken", "MT001", 15, "Meat", 11.00);      
        Product product69 = new Product("Beef", "MT002", 15, "Meat", 22.00);
        Product product70 = new Product("Pork", "MT003", 15, "Meat", 21.00);      
        Product product71 = new Product("Sausage", "MT004", 15, "Meat", 14.00);
        Product product72 = new Product("Bacon", "MT005", 15, "Meat", 15.00);      

        Product product73 = new Product("Butter", "DY001", 15, "Dairy",11.00);      
        Product product74 = new Product("Eggs", "DY002", 15, "Dairy", 13.00);
        Product product75 = new Product("Yogurt", "DY003", 15, "Dairy", 12.00);      

        Product product76 = new Product("Soup", "CG001", 15, "Canned Goods", 7.00);
        Product product77 = new Product("Pasta Sauce", "CG002", 15, "Canned Goods", 6.00);      
        Product product78 = new Product("Beans", "CG003", 15, "Canned Goods", 5.00);
        Product product79 = new Product("Tuna", "CG004", 15, "Canned Goods", 7.00);      

        Product product80 = new Product("Potatoes", "VT001", 15, "Vegetables", 2.00);
        Product product81 = new Product("Onions", "VT002", 15, "Vegetables", 2.00);      
        Product product82 = new Product("Carrots", "VT003", 15, "Vegetables", 1.00);
        Product product83 = new Product("Broccoli", "VT004", 15, "Vegetables", 5.00);      
        Product product84 = new Product("Tomatoes (1kg)", "VT005", 15, "Vegetables", 6.00);
        Product product85 = new Product("Cucumbers", "VT006", 15, "Vegetables", 2.00);      

        Product product86 = new Product("Apples", "FF001", 15, "Fruits", 5.00);
        Product product87 = new Product("Bananas", "FF002", 15, "Fruits", 5.00);      
        Product product88 = new Product("Grapes", "FF003", 15, "Fruits", 7.00);
        Product product89 = new Product("Oranges", "FF004", 15, "Fruits", 3.00);      

              // Adding instances to the ArrayList
            products.add(product1);
            products.add(product2);
            products.add(product3);
            products.add(product4);
            products.add(product5);
            products.add(product6);
            products.add(product7);
            products.add(product8);
            products.add(product9);
            products.add(product10);
            products.add(product11);
            products.add(product12);
            products.add(product13);
            products.add(product14);
            products.add(product15);
            products.add(product16);
            products.add(product17);
            products.add(product18);
            products.add(product19);
            products.add(product20);
            products.add(product21);
            products.add(product22);
            products.add(product23);
            products.add(product24);
            products.add(product25);
            products.add(product26);
            products.add(product27);
            products.add(product28);
            products.add(product29);
            products.add(product30);
            products.add(product31);
            products.add(product32);
            products.add(product33);
            products.add(product34);
            products.add(product35);
            products.add(product36);
            products.add(product37);
            products.add(product38);
            products.add(product39);
            products.add(product40);
            products.add(product41);
            products.add(product42);
            products.add(product43);
            products.add(product44);
            products.add(product45);
            products.add(product46);
            products.add(product47);
            products.add(product48);
            products.add(product49);
            products.add(product50);
            products.add(product51);
            products.add(product52);
            products.add(product53);
            products.add(product54);
            products.add(product55);
            products.add(product56);
            products.add(product57);
            products.add(product58);
            products.add(product59);
            products.add(product60);
            products.add(product61);
            products.add(product62);
            products.add(product63);
            products.add(product64);
            products.add(product65);
            products.add(product66);
            products.add(product67);
            products.add(product68);
            products.add(product69);
            products.add(product70);
            products.add(product71);
            products.add(product72);
            products.add(product73);
            products.add(product74);
            products.add(product75);
            products.add(product76);
            products.add(product77);
            products.add(product78);
            products.add(product79);
            products.add(product80);
            products.add(product81);
            products.add(product82);
            products.add(product83);
            products.add(product84);
            products.add(product85);
            products.add(product86);
            products.add(product87);
            products.add(product88);
            products.add(product89);
    }
    // Print table header
    //arraylist for to store the staff and display it
    public static void addInitialProduct( List<Product> products){
        // Creating instances of the Product class
        System.out.println("**********************************************");
        System.out.println("*              Product Category              *");
        System.out.println("**********************************************");
        System.out.println("");

        System.out.println("1. Pet Care");
        System.out.println("2. Baby Item");
        System.out.println("3. Household & Cleaning Supplies");
        System.out.println("4. Health Care");
        System.out.println("5. Personal Care");
        System.out.println("6. Frozen Foods");
        System.out.println("7. Baking");
        System.out.println("8. Packages Foods");
        System.out.println("9. Beverages");
        System.out.println("10. Bread & Bakery");
        System.out.println("11. Snacks");
        System.out.println("12. Condiments & Spices");
        System.out.println("13. Deli");
        System.out.println("14. Fish & Seafood");
        System.out.println("15. Meat");
        System.out.println("16. Dairy");
        System.out.println("17. Canned Goods");
        System.out.println("18. Vegetables");
        System.out.println("19. Fruits");
        System.out.println("20. Back to Product Management Menu");
        System.out.print("Enter your choice: ");
        int choiceProduct = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.printf("\n");
        String selectedCategory = "";
        switch (choiceProduct) {
            case 1:
                System.out.println("Pet Care");
                // Print table header
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
                System.out.println("-----------------------------------------------------------------------------------------------");
                selectedCategory = "Pet Care";
                break;
                
            case 2:
                System.out.println("Baby Item");
                // Print table header
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
                System.out.println("-----------------------------------------------------------------------------------------------");
                selectedCategory = "Baby Item";
            break;
            
            case 3:
            System.out.println("Household & Cleaning Supplies");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Household & Cleaning Supplies";
            break;
            
            case 4:
            System.out.println("Health Care");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Health Care";
            break;
            
            case 5:
            System.out.println("Personal Care");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Personal Care";
            break;
            
            case 6:
            System.out.println("Frozen Foods");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Frozen Foods";
            break;
            
            case 7:
            System.out.println("Baking");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Baking";
            break;
            
            case 8:
            System.out.println("Packages Foods");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Packages Foods";
            break;
            
            case 9:
            System.out.println("Beverages");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Beverages";
            break;
            
            case 10:
            System.out.println("Bread & Bakery");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Bread & Bakery";
            break;
            
            case 11:
            System.out.println("Snacks");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Snacks";
            break;
            
            case 12:
            System.out.println("Condiments & Spices");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Condiments & Spices";
            break;
            
            case 13:
            System.out.println("Deli");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Deli";
            break;
            
            case 14:
            System.out.println("Fish & Seafood");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Fish & Seafood";
            break;
            
            case 15:
            System.out.println("Meat");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Meat";
            break;
            
            case 16:
            System.out.println("Dairy");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Dairy";
            break;
            
            case 17:
            System.out.println("Canned Goods");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Canned Goods";
            break;
            
            case 18:
            System.out.println("Vegetables");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Vegetables";
            break;
            
            case 19:
            System.out.println("Fruits");
            // Print table header
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | $%-8s |\n", "No.", "Name", "Item Code", "Item Quantity", "Price");
            System.out.println("-----------------------------------------------------------------------------------------------");
            selectedCategory = "Fruits";
            break;
            
            case 20:
            System.out.println("Have a nice day ^_^");
            System.out.printf("\n");
            
            
            
            default:
                System.out.println("Invalid choice. Please select again. (ㆆ_ㆆ)");
            }
            
           int counter = 1;
           //set declares a Set named printedItemCodes that will store unique item codes (strings).
           Set<String> printedItemCodes = new HashSet<>();//HashSet implementation which ensures that it does not allow duplicate item codes.
           
           // loop iterates over each Product in the products list.
            for (Product p : products) {
                if (p.getItemCategory().equals(selectedCategory)) {//checks whether the ItemCategory of the current Product matches the selectedCategory
                    if (!printedItemCodes.contains(p.getItemCode())) {// checks whether the printedItemCodes set already contains the ItemCode of the current product and ensure no duplicate
                        System.out.printf("| %-10d | %-20s | %-20s | %-20d | $%-8.2f |\n",
                            counter,//counter is used to number the products being displayed,
                            p.getItemName(),
                            p.getItemCode(),
                            p.getItemQuantity(),
                            p.getItemPrice());
                        printedItemCodes.add(p.getItemCode());// the code adds the item code to the printedItemCodes set to keep track of which item codes have been printed
                        counter++;//incremented to ensure that the product numbers are unique
                    }
                }
            }

            System.out.println("-----------------------------------------------------------------------------------------------");
       // After deleting one or more products, return to the product management menu
    productManagement(products);

    
   }
}




