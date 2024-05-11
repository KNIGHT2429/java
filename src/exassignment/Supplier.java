/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exassignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;//It does not allow duplicate elements.
import java.util.Set;//defines elements in which each element can appear at most once (no duplicates).

public class Supplier extends Person {
    private String companyName;
    private String address;
    private static List <Supplier> suppliers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public Supplier(String companyName, String address, String name, String icNo, String hpNo) {
        super(name, icNo, hpNo);//refers to superclass (parent) objects, and is to access the superclass constructor.
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //validation
     @Override
    public void setName(String name) {
        if (name != null && name.length() >= 3 && !name.matches(".*\\d.*")) {
            super.setName(name); // Call the setter of the parent class
        } else {
            throw new IllegalArgumentException("Name must be at least 3 characters long and cannot contain digits.");
        }
    }
    
     @Override
    public void setIcNo(String icNo) {
        if (icNo != null && icNo.length() <= 12) {
            super.setIcNo(icNo);
        } else {
            throw new IllegalArgumentException("IC number cannot be more than 12 characters.");
        }
    }

    @Override
    public void setHpNo(String hpNo) {
        if (hpNo != null && hpNo.length() <= 11) {
            super.setHpNo(hpNo);
        } else {
            throw new IllegalArgumentException("Phone number cannot be more than 11 characters.");
        }
    }
    
    public static List<Supplier> supplierManagement(List<Supplier> suppliers) {
        // Logo for supplier and menu
        addInitialSuppliers(suppliers); // This stores the ArrayList
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("*          Supplier Management Menu          *");
        System.out.println("**********************************************");
        System.out.println("");
        
        int choice;

            System.out.println("1. Create New Supplier");
            System.out.println("2. Search Specific Supplier");
            System.out.println("3. Update Supplier");
            System.out.println("4. Delete Supplier");
            System.out.println("5. Display List Of Supplier");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createSupplier(suppliers);
                    break;
                case 2:
                    retrieveSpecificSupplier(suppliers);
                    break;
                case 3:
                    updateSupplier(suppliers);
                    break;
                case 4:
                    deleteSupplier(suppliers);
                    break;
                case 5:
                    displaySupplier(suppliers);
                    break;
                case 6:
                    System.out.println("Have a nice day Bye");
              
                    break;
                default:
                    System.out.println("Invalid choice. Please select again. ┗( T﹏T )┛ !!");
                }

        return suppliers;
    }

    
    // Add management functionalities
   public static void createSupplier(List<Supplier> suppliers) {
    boolean createAnotherSupplier = true; // Flag to control the loop
    System.out.println("**********************************************");
    System.out.println("*              Create Supplier               *");
    System.out.println("**********************************************");
    System.out.println("");
        
    while (createAnotherSupplier) {
        String name;
        while (true) {
            System.out.print("Enter supplier Name: ");
            name = sc.nextLine();

            if (!name.matches(".*\\d.*")) {
                break; // Exit the loop if the name doesn't contain any digits
            } else {
                System.out.println("Invalid name. Please do not include digits.");
            }
        }

        String icNo;
        while (true) {
            System.out.print("Enter supplier IC Number: ");
            icNo = sc.nextLine();
            if (icNo.length() == 12) {
                break; // Exit the loop if IC Number is valid
            } else {
                System.out.println("IC Number must be exactly 12 characters. Please enter a valid IC Number.");
            }
        }

        String hpNo;
        while (true) {
            System.out.print("Enter supplier Handphone Number: ");
            hpNo = sc.nextLine();
            if (hpNo.length() == 11) {
                break; // Exit the loop if Handphone Number is valid
            } else {
                System.out.println("Handphone Number must be exactly 11 characters. Please enter a valid Handphone Number.");
            }
        }

        System.out.print("Enter supplier Company Name: ");
        String companyName = sc.nextLine();
        System.out.print("Enter supplier Address: ");
        String address = sc.nextLine();
        
        System.out.println("");
        System.out.println("|----Supplier details----|");
        System.out.println("    Supplier Name: " + name);
        System.out.println("    Supplier IC Number: " + icNo);
        System.out.println("    Supplier Handphone Number: " + hpNo);
        System.out.println("    Supplier Company Name: " + companyName);
        System.out.println("    Supplier Address: " + address);
        System.out.println("");

        System.out.print("Confirm creation of this supplier? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            Supplier supplier = new Supplier(companyName, address, name, icNo, hpNo);
            suppliers.add(supplier);
            System.out.println("Supplier has been added.");
            System.out.println("");
        } else {
            System.out.println("Supplier creation has been canceled.");
            System.out.println("");
        }

        // Ask the user if they want to create another supplier
        System.out.print("Do you want to create another supplier? (yes/no): ");
        String createAnotherInput = sc.nextLine();
        createAnotherSupplier = createAnotherInput.equalsIgnoreCase("yes");
        System.out.println("");
        }
        supplierManagement(suppliers);//back to menu staff
    }

    
    //Display new supplier
    public static void retrieveListOfSupplier(List <Supplier> suppliers) {
        for (Supplier s : suppliers) {
            System.out.println("");
            System.out.println("|----New Supplier details----|");
            System.out.println("    Supplier Name: " + s.getName());
            System.out.println("    Supplier Ic Number: " + s.getIcNo());
            System.out.println("    Supplier Handphone Number: " + s.getHpNo());
            System.out.println("    Company Name: " + s.getCompanyName());
            System.out.println("    Address: " + s.getAddress());
            System.out.println("");
        }
        supplierManagement(suppliers);//back to menu staff
    }

    //Search supplier
    public static void retrieveSpecificSupplier(List<Supplier> suppliers) {
    boolean searchAnotherSupplier = true; // Flag to control the loop
    System.out.println("**********************************************");
    System.out.println("*              Search Supplier               *");
    System.out.println("**********************************************");
    System.out.println("");
    
    while (searchAnotherSupplier) {
        System.out.print("Enter Supplier Phone Number: ");
        String phoneNumber = sc.nextLine();

        boolean found = false; // Flag to track if the supplier was found

        for (Supplier s : suppliers) {
            if (s.getHpNo().equalsIgnoreCase(phoneNumber)) {
                System.out.println("");
                System.out.println("Supplier Details");
                System.out.println("Supplier Name: " + s.getName());
                System.out.println("Supplier Ic Number: " + s.getIcNo());
                System.out.println("Supplier Handphone Number: " + s.getHpNo());
                System.out.println("Supplier Company Name: " + s.getCompanyName());
                System.out.println("Supplier Address: " + s.getAddress());
                System.out.println("");

                found = true; // Supplier was found
                break;
            }
        }

        if (!found) {
            System.out.println("No supplier with the name " + phoneNumber + " found.");
            System.out.println("");
        }

        // Ask the user if they want to search for another supplier
        System.out.print("Do you want to search for another supplier? (yes/no): ");
        String searchAnotherInput = sc.nextLine();
        searchAnotherSupplier = searchAnotherInput.equalsIgnoreCase("yes");
        System.out.println("");
        }
     supplierManagement(suppliers);//back to menu staff
    }

    
    //Edit suppler detail
    public static void updateSupplier(List<Supplier> suppliers) {
    boolean updateAnotherSupplier = true; // Flag to control the loop
    System.out.println("**********************************************");
    System.out.println("*              Update Supplier               *");
    System.out.println("**********************************************");
    System.out.println("");

    while (updateAnotherSupplier) {
        System.out.print("Enter Supplier phone number that needs to be updated: ");
        String phoneNumber = sc.nextLine();

        boolean found = false; // Flag to track if the supplier was found

        for (int i = 0; i < suppliers.size(); i++) {
            if (suppliers.get(i).getHpNo().equalsIgnoreCase(phoneNumber)) {
                Supplier s = suppliers.get(i);

                // Display current supplier details
                System.out.println("");
                System.out.println("|----Current supplier details-----|");
                System.out.println("    Supplier Name: " + s.getName());
                System.out.println("    Supplier IC number: " + s.getIcNo());
                System.out.println("    Supplier Handphone number: " + s.getHpNo());
                System.out.println("    Supplier Company Name: " + s.getCompanyName());
                System.out.println("    Supplier Address: " + s.getAddress());
                System.out.println("");

                System.out.print("Do you want to proceed with updating this supplier? (yes/no): ");
                String confirmUpdate = sc.nextLine();

                if (confirmUpdate.equalsIgnoreCase("yes")) {
                    // Input and validation for new supplier name
                    String newName;
                    while (true) {
                        System.out.print("Enter new supplier name: ");
                        newName = sc.nextLine();

                        if (!newName.matches(".*\\d.*") && newName.length() >= 3) {
                            break; // Exit the loop if the name is valid
                        } else {
                            System.out.println("Invalid name. Name must be at least 3 characters long and cannot contain digits.");
                        }
                    }

                    s.setName(newName);

                    // Input and validation for new supplier IC number
                    String newIcNo;
                    while (true) {
                        System.out.print("Enter new supplier IC number (exactly 12 characters): ");
                        newIcNo = sc.nextLine();
                        if (newIcNo.length() == 12) {
                            break; // Exit the loop if IC number is valid
                        } else {
                            System.out.println("IC Number must be exactly 12 characters long.");
                        }
                    }

                    s.setIcNo(newIcNo);

                    // Input and validation for new supplier handphone number
                    String newHpNo;
                    while (true) {
                        System.out.print("Enter new supplier handphone number (exactly 11 digits): ");
                        newHpNo = sc.nextLine();
                        if (newHpNo.length() == 11) {
                            break; // Exit the loop if handphone number is valid
                        } else {
                            System.out.println("Handphone Number must be exactly 11 digits long.");
                        }
                    }

                    s.setHpNo(newHpNo);

                    // Input for new supplier company name and address (no specific validation)
                    System.out.print("Enter new supplier company name: ");
                    String newCompanyName = sc.nextLine();
                    s.setCompanyName(newCompanyName);

                    System.out.print("Enter new supplier address: ");
                    String newAddress = sc.nextLine();
                    s.setAddress(newAddress);

                    suppliers.set(i, s);
                    System.out.println("Supplier details updated.");
                } else {
                    System.out.println("Supplier update has been canceled.");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No supplier with the name " + phoneNumber + " found.");
            System.out.println("");
        }

        // Ask the user if they want to update another supplier
        System.out.print("Do you want to update another supplier? (yes/no): ");
        String updateAnotherInput = sc.nextLine();
        updateAnotherSupplier = updateAnotherInput.equalsIgnoreCase("yes");
        System.out.println("");
        }
     supplierManagement(suppliers);//back to menu staff
    }
  
    //delete suplier 
    public static void deleteSupplier(List<Supplier> suppliers) {
    boolean deleteAnotherSupplier = true; // Flag to control the loop
    System.out.println("**********************************************");
    System.out.println("*              Delete Supplier               *");
    System.out.println("**********************************************");
    System.out.println("");

    while (deleteAnotherSupplier) {
        System.out.print("Enter Supplier IC Number to delete: ");
        String icNumber = sc.nextLine();

        boolean found = false; // Flag to track if the supplier was found

        for (int i = 0; i < suppliers.size(); i++) {
            if (suppliers.get(i).getIcNo().equalsIgnoreCase(icNumber)) {
                Supplier s = suppliers.get(i);

                // Display current supplier details
                System.out.println("");
                System.out.println("|-----Current supplier details-----|");
                System.out.println("    Supplier Name: " + s.getName());
                System.out.println("    Supplier IC number: " + s.getIcNo());
                System.out.println("    Supplier Handphone number: " + s.getHpNo());
                System.out.println("    Supplier Company Name: " + s.getCompanyName());
                System.out.println("    Supplier Address: " + s.getAddress());
                System.out.println("");

                System.out.print("Are you sure you want to delete this supplier? (yes/no): ");
                String confirmDelete = sc.nextLine();

                if (confirmDelete.equalsIgnoreCase("yes")) {
                    suppliers.remove(i);
                    System.out.println("Supplier with IC Number " + icNumber + " has been deleted.");
                    System.out.println("");
                } else {
                    System.out.println("Supplier deletion has been canceled.");
                    System.out.println("");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No supplier with the IC Number " + icNumber + " found.");
            System.out.println("");
        }

        // Ask the user if they want to delete another supplier
        System.out.print("Do you want to delete another supplier? (yes/no): ");
        String deleteAnotherInput = sc.nextLine();
        deleteAnotherSupplier = deleteAnotherInput.equalsIgnoreCase("yes");
        System.out.println("");
        }
     supplierManagement(suppliers);//back to menu staff
    }

    
    public static void addInitialSuppliers(List <Supplier> suppliers) {
        
        Supplier supplier1 = new Supplier("Sangla Foods Food Distributor Malaysia", "Lot 2, Jalan Peguam Satu U1/25 A, Hicom Glenmarie Industrial Park, Shah Alam 40150, Selangor", "Thong Mei", "030299089922", "0173350099");
        Supplier supplier2 = new Supplier("CGK Frozen Sdn Bhd", "46, Jalan Yew, Off Jalan Pudu, 55100 Kuala Lumpur, Malaysia.", "Kah Ming", "011288061122", "0122528251");
        Supplier supplier3 = new Supplier("Ocean Pacific Seafood & Meat Sdn Bhd", "29, Jalan Perniagaan Setia 1/1, Taman Perniagaan Setia, 81100 Johor Bahru, Johor, Malaysia.", "Tan Hong Ming", "131288081522", "0127399872");

        suppliers.add(supplier1);
        suppliers.add(supplier2);
        suppliers.add(supplier3);
    }
    
    public static void displaySupplier(List<Supplier> suppliers) {
    System.out.println("**********************************************");
    System.out.println("*               Supplier List                *");
    System.out.println("**********************************************");
    System.out.println("");

    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("| %-4s | %-15s | %-15s | %-15s | %-50s | %-100s |\n", "No.", "Name", "IC Number", "Phone Number", "Company Name", "Address");
    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    int counter = 1;
    Set<String> printedICNumbers = new HashSet<>();

    for (Supplier supplier : suppliers) {
        if (!printedICNumbers.contains(supplier.getIcNo())) {
            System.out.printf("| %-4d | %-15s | %-15s | %-15s | %-50s | %-100s |\n",
                counter,
                supplier.getName(),
                supplier.getIcNo(),
                supplier.getHpNo(),
                supplier.getCompanyName(),
                supplier.getAddress());
            printedICNumbers.add(supplier.getIcNo());
            counter++;
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        supplierManagement(suppliers);//back to menu staff
    }
}