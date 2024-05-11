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

public class Staff extends Person {
    private double salary;
    private static List <Staff> staffs = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public Staff(double salary, String name, String icNo, String hpNo) {
        //super is go to the Person and take the Person name, icNo, hpNo
        super(name, icNo, hpNo);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

   public void setSalary(double salary) {
    if (String.valueOf(salary).matches("\\d*\\.?\\d+")) {
        this.salary = salary; // Set the salary attribute directly
    } else {
        throw new IllegalArgumentException("Salary cannot have non-numeric characters.");
    }
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
    
    public static List<Staff> staffManagement(List<Staff> staffs) {
        // Implement staff management logic here
        addInitialStaffMembers(staffs);
         System.out.println("");
        System.out.println("**********************************************");
        System.out.println("*           Staff Management Menu            *");
        System.out.println("**********************************************");
        System.out.println("");

        int choice;

            System.out.println("1. Create new Staff");
            System.out.println("2. Search Specific Staff");
            System.out.println("3. Update Staff");
            System.out.println("4. Delete Staff");
            System.out.println("5. Display List Of Staff");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createStaff(staffs);
                    break;
                case 2:
                    retrieveSpecificStaff(staffs);
                    break;
                case 3:
                    updateStaff(staffs);
                    break;
                case 4:
                    deleteStaff(staffs);
                    break;
                case 5:
                    displayStaff(staffs);
                    break;
                case 6:
                    System.out.println("Have a nice day ^_^");

                    break;
                default:
                    System.out.println("Invalid choice. Please select again. (ㆆ_ㆆ)");
                }

        return staffs;
    }

    
    // Add management functionalities
    public static void createStaff(List<Staff> staffs) {
        boolean createAnotherStaff = true; // Flag to control the loop
        System.out.println("**********************************************");
        System.out.println("*             Create Staff Member            *");
        System.out.println("**********************************************");
        System.out.println("");
        
        while (createAnotherStaff) {//this is ask user need to add another?
            
            String name = sc.nextLine();
            while (true) {
                System.out.print("Enter Staff Name: ");
                name = sc.nextLine();

                if (!name.matches(".*\\d.*")) {
                    break; // Exit the loop if the name doesn't contain any digits
                } else {
                    System.out.println("Invalid name. Please do not include digits.");
                }
            }
        
            String icNo;         
            while (true) {
                System.out.print("Enter IC Number: ");
                icNo = sc.nextLine();
                if (icNo.length() == 12) {
                    break; // Exit the loop if IC Number is valid
                } else {
                    System.out.println("IC Number cannot be more than 12 characters. Please enter a valid IC Number.");
                }
            }

            String hpNo;
            while (true) {
                System.out.print("Enter Handphone Number: ");
                hpNo = sc.nextLine();
                if (hpNo.length() == 11) {
                    break; // Exit the loop if Handphone Number is valid
                } else {
                    System.out.println("Handphone Number cannot be more than 11 characters. Please enter a valid Handphone Number.");
                }
            }

            double salary;
            while (true) {
                System.out.print("Enter Salary: ");
                String salaryInput = sc.nextLine();
                if (salaryInput.matches("\\d*\\.?\\d+")) {
                    salary = Double.parseDouble(salaryInput);
                    break; // Exit the loop if Salary is valid
                } else {
                    System.out.println("Salary cannot have non-numeric characters. Please enter a valid Salary.");
                }
            }
            
            System.out.println("");
            System.out.println("|----New Staff details----|");
            System.out.println("    Staff Name: " + name);
            System.out.println("    Staff IC Number: " + icNo);
            System.out.println("    Staff Handphone Number: " + hpNo);
            System.out.println("    Salary: " + salary);
            System.out.println("");

            System.out.print("Confirm creation of this staff? (yes/no): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                Staff staff = new Staff(salary, name, icNo, hpNo);
                staffs.add(staff);
                System.out.println("Staff has been added.");
                System.out.println("");
            } else {
                System.out.println("Staff creation has been canceled.");
                System.out.println("");
            }

            // Ask the user if they want to create another staff
            System.out.print("Do you want to create another staff? (yes/no): ");
            String createAnotherInput = sc.nextLine();
            createAnotherStaff = createAnotherInput.equalsIgnoreCase("yes");
        }
        staffManagement(staffs);//back to menu staff
    }

    
    //Display new staff
    public static void retrieveListOfStaff(List <Staff> staffs) {
        for (Staff s : staffs) {
             System.out.println("");
            System.out.println("|----New Staff details----|");
            System.out.println("    Staff Name: " + s.getName());
            System.out.println("    Staff Ic Number: " + s.getIcNo());
            System.out.println("    Staff Handphone Number: " + s.getHpNo());
            System.out.println("    Staff Salary: " + s.getSalary());
             System.out.println("");
        }
        staffManagement(staffs);
    }
    
    //Search staff
    public static void retrieveSpecificStaff(List<Staff> staffs) {
        boolean searchAnotherStaff = true;
        System.out.println("**********************************************");
        System.out.println("*             Search Staff Member            *");
        System.out.println("**********************************************");
        System.out.println("");

        while (searchAnotherStaff) {
            System.out.print("Enter staff IC number to search: ");
            String icNo = sc.nextLine();

            boolean found = false;

            for (Staff s : staffs) {
                if (s.getIcNo().equalsIgnoreCase(icNo)) {
                    System.out.println("");
                    System.out.println("|----Staff details----|");
                    System.out.println("    Staff name: " + s.getName());
                    System.out.println("    Staff IC Number: " + s.getIcNo());
                    System.out.println("    Staff Handphone Number: " + s.getHpNo());
                    System.out.println("    Staff Salary: " + s.getSalary());
                    System.out.println("");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Staff with the IC Number " + icNo + " not found.");
                System.out.println("");
            }

            // Ask the user if they want to search for another staff member
            System.out.print("Do you want to search for another staff? (yes/no): ");
            String searchAnotherInput = sc.nextLine();
            searchAnotherStaff = searchAnotherInput.equalsIgnoreCase("yes");
            System.out.println("");
        }
          staffManagement(staffs); // Go back to the staff menu
    }

    //Edit staff detail
    public static void updateStaff(List<Staff> staffs) {
        boolean updateAnotherStaff = true; // Flag to control the loop
        System.out.println("**********************************************");
        System.out.println("*             Update Staff Member            *");
        System.out.println("**********************************************");
        System.out.println("");
        
    while (updateAnotherStaff) {
        System.out.print("Enter staff IC number that needs to be updated: ");
        String icNo = sc.nextLine();

        boolean found = false; // Flag to track if the staff member was found

        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getIcNo().equalsIgnoreCase(icNo)) {
                Staff s = staffs.get(i);

                // Display current staff details
                System.out.println("");
                System.out.println("|----Current staff details----|");
                System.out.println("    Staff Name: " + s.getName());
                System.out.println("    Staff IC number: " + s.getIcNo());
                System.out.println("    Staff Handphone number: " + s.getHpNo());
                System.out.println("    Current salary: " + s.getSalary());
                System.out.println("");

                System.out.print("Confirm update of this staff? (yes/no): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    //validation for name
                    String newName;
                    while (true) {
                        System.out.print("Enter new staff name: ");
                        newName = sc.nextLine();

                        if (newName.length() >= 3 && !newName.matches(".*\\d.*")) {//cannot less than 3 character and cannot have digit 
                            break; // Exit the loop if the name is at least 3 characters long and doesn't contain digits
                        } else {
                            System.out.println("Invalid name. Name must be at least 3 characters long and cannot contain digits.");
                        }
                    }
                    s.setName(newName);

                    // Validate and update handphone number
                    String newHpNo;
                    while (true) {
                        System.out.print("Enter new staff handphone number (exactly 11 digits): ");
                        newHpNo = sc.nextLine();
                        if (newHpNo.matches("\\d{11}")) {
                            break; // Exit the loop if handphone number is valid
                        } else {
                            System.out.println("Invalid handphone number format. Please enter exactly 11 digits.");
                        }
                    }
                    s.setHpNo(newHpNo);//save back to hand phone number

                    // Validate and update salary
                    double newSalary;

                    while (true) {
                        System.out.print("Enter new Salary: ");
                        String salaryInput = sc.nextLine();

                       if (salaryInput.matches("\\d*\\.?\\d+")) {
                            newSalary = Double.parseDouble(salaryInput);
                            break; // Exit the loop if Salary is valid
                        } else {
                            System.out.println("Invalid salary format. Please enter a valid numeric value.");
                        }
                    }
                    s.setSalary(newSalary);

                    staffs.set(i, s);
                    System.out.println("");
                    System.out.println("Staff details updated.");
                    System.out.println("");
                    
                    } else {
                        System.out.println("Staff update has been canceled.");
                        System.out.println("");
                    }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No staff member with the IC Number " + icNo + " found.");
            System.out.println("");
        }

            // Ask the user if they want to update another staff member
            System.out.print("Do you want to update another staff member? (yes/no): ");
            String updateAnotherInput = sc.nextLine();
            updateAnotherStaff = updateAnotherInput.equalsIgnoreCase("yes");
            System.out.println("");
        }

        staffManagement(staffs); // Go back to the staff menu
    }

    //delete staff 
    public static void deleteStaff(List<Staff> staffs) {
        boolean deleteAnotherStaff = true; // Flag to control the loop
        System.out.println("**********************************************");
        System.out.println("*             Delete Staff Member            *");
        System.out.println("**********************************************");
        System.out.println("");
        
        while (deleteAnotherStaff) {
            System.out.print("Enter Staff IC Number to delete: ");
            String staffIC = sc.nextLine();

            boolean found = false; // Flag to track if the staff member was found

            for (int i = 0; i < staffs.size(); i++) {
                if (staffs.get(i).getIcNo().equalsIgnoreCase(staffIC)) {
                    while (true) {
                        System.out.println("Are you sure you want to delete the staff with IC number " + staffIC + "? (yes/no): ");
                        String confirm = sc.nextLine();

                        if (confirm.equalsIgnoreCase("yes")) {
                            staffs.remove(i);
                            System.out.println("Staff with IC number " + staffIC + " has been deleted.");
                            System.out.println("");
                        } else if (confirm.equalsIgnoreCase("no")) {
                            System.out.println("Deletion of staff with IC number " + staffIC + " has been canceled.");
                            System.out.println("");
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no' to delete the staff.");
                            System.out.println("");
                            continue;
                        }

                        found = true; // Staff member was found
                        break; // Exit the loop after handling deletion
                    }

                    if (found) {
                        break; // Exit the loop since the staff member was found and deleted
                    }
                }
            }

            if (!found) {
                System.out.println("No staff member with the IC number " + staffIC + " found.");
                System.out.println("");
            }

            // Ask the user if they want to delete another staff member
            System.out.print("Do you want to delete another staff member? (yes/no): ");
            String deleteAnotherInput = sc.nextLine();
            deleteAnotherStaff = deleteAnotherInput.equalsIgnoreCase("yes");
            System.out.println("");
        }
        staffManagement(staffs);
    }

    
    //arraylist for to store the staff 
    public static void addInitialStaffMembers(List <Staff> staffs) {
        Staff staff1 = new Staff(3000.00, "Mary", "1123084836", "0122237788");
        Staff staff2 = new Staff(2500.00, "Henry", "2123123435", "0114458899");

        staffs.add(staff1);
        staffs.add(staff2);
    }
    
    //this is use to display the staff 
    public static void displayStaff(List<Staff> staffs) {
    System.out.println("**********************************************");
    System.out.println("*                 Staff List                 *");
    System.out.println("**********************************************");
    System.out.println("");

    System.out.println("-----------------------------------------------------------------------------");
    System.out.printf("| %-4s | %-15s | %-15s | %-15s | %-12s |\n", "No.", "Name", "IC Number", "Phone Number", "Salary");
    System.out.println("-----------------------------------------------------------------------------");

    int counter = 1;
    Set<String> printedICNumbers = new HashSet<>();

    for (Staff staff : staffs) {
        if (!printedICNumbers.contains(staff.getIcNo())) {
            System.out.printf("| %-4d | %-15s | %-15s | %-15s | $%-11.2f |\n",
                counter,
                staff.getName(),
                staff.getIcNo(),
                staff.getHpNo(),
                staff.getSalary());
            printedICNumbers.add(staff.getIcNo());
            counter++;
        }
    }

    System.out.println("-----------------------------------------------------------------------------");
    staffManagement(staffs);
}

}

