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
/**
 *
 * @author ACER
 */
public class Member extends Person{
    private String emailAddress;
    private String expiredDate;
    private String birthDate;
    private static List <Member> members = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    

    public Member(String emailAddress, String expiredDate, String birthDate, String name, String icNo, String hpNo) {
        super(name, icNo, hpNo);
        this.emailAddress = emailAddress;
        this.expiredDate = expiredDate;
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
     //validation
    @Override// used to indicate,helps catch errors
    public void setName(String name) {
        if (name != null && name.length() >= 3 && !name.matches(".*\\d.*")) {
            super.setName(name); // Call the setter of the parent class
        } else {
            throw new IllegalArgumentException("Name must be at least 3 characters long and cannot contain digits.");
        }
    }
    
     @Override
    public void setIcNo(String icNo) {
        if (icNo != null && icNo.length() <= 12) {//cannot less 12 character
            super.setIcNo(icNo);
        } else {
            throw new IllegalArgumentException("IC number cannot be more than 12 characters.");
        }
    }

    @Override
    public void setHpNo(String hpNo) {
        if (hpNo != null && hpNo.length() <= 11) {//cannot less than 11 character
            super.setHpNo(hpNo);
        } else {
            throw new IllegalArgumentException("Phone number cannot be more than 11 characters.");
        }
    }
    
    public static boolean isValidDate(String date) {
    // Define a regular expression pattern for the desired format "00-00-0000"
        String pattern = "^([0-2]?[0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
        //(0[1-9]|1[0-2]),  matches the month 01" to "12
        //([0-2]?[0-9]|3[01]), matches the day,01" to "31
        //\\d{4}), matches the year
        // Check if the date matches the pattern
        return date.matches(pattern);
    }

    
    public static List<Member> memberManagement(List<Member> members) {
        // logo
        addInitialMember(members);
        
        System.out.println("");
        System.out.println("**********************************************");
        System.out.println("*          Member Management Menu            *");
        System.out.println("**********************************************");
        System.out.println("");
        int choice;

            System.out.println("1. Create new Member");
            System.out.println("2. Search Specific Member");
            System.out.println("3. Update Member");
            System.out.println("4. Delete Member");
            System.out.println("5. Display Member");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            System.out.println("");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createMember(members);
                    break;
                case 2:
                    retrieveSpecificMember(members);
                    break;
                case 3:
                    updateMember(members);
                    break;
                case 4:
                    deleteMember(members);
                    break;
                case 5:
                    displayMembers(members);
                    break;
                case 6:
                    System.out.println("Have a nice day ＞﹏＜ Bye");                
                    break;
                default:
                    System.out.println("Invalid choice. Please select again. (ㆆ_ㆆ)！！！");
                }
            
        return members;
    }

    
    public static void createMember(List<Member> members) {
        boolean createAnotherMember = true;
        
        System.out.println("**********************************************");
        System.out.println("*             Create New Member              *");
        System.out.println("**********************************************");
        
        while (createAnotherMember) {
            String name = sc.nextLine();
            while (true) {
                System.out.print("Enter Member Name: ");
                name = sc.nextLine();

                if (!name.matches(".*\\d.*") && name.length() >= 3) {
                    break; // Exit the loop if the name doesn't contain any digits
                } else {
                    System.out.println("Invalid name. Please do not include digits.");
                }
            }
        
            String icNo;         
            while (true) {
                System.out.print("Enter Member IC Number: ");
                icNo = sc.nextLine();
                if (icNo.length() == 12) {
                    break; // Exit the loop if IC Number is valid
                } else {
                    System.out.println("IC Number cannot be more than 12 characters. Please enter a valid IC Number.");
                }
            }

            String hpNo;
            while (true) {
                System.out.print("Enter Member Handphone Number: ");
                hpNo = sc.nextLine();
                if (hpNo.length() == 11) {
                    break; // Exit the loop if Handphone Number is valid
                } else {
                    System.out.println("Handphone Number cannot be more than 11 characters. Please enter a valid Handphone Number.");
                }
            }
            System.out.print("Enter Member Email Address: ");
            String emailAddress = sc.nextLine();
            String expiredDate;
            while (true) {
                System.out.print("Enter Member Card Expired Date (00-00-0000): ");
                expiredDate = sc.nextLine();

                if (isValidDate(expiredDate)) {
                    break; // Exit the loop if the date is in the correct format
                } else {
                    System.out.println("Invalid date format. Please enter a date in the format '00-00-0000'.");
                }
            }

            String birthDate;
            while (true) {
                System.out.print("Enter Member Birth Date (00-00-0000): ");
                birthDate = sc.nextLine();

                if (isValidDate(birthDate)) {
                    break; // Exit the loop if the date is in the correct format
                } else {
                    System.out.println("Invalid date format. Please enter a date in the format '00-00-0000'.");
                }
            }
       
            //Display the member that have create
            System.out.println("");
            System.out.println("|----New Member details----|");
            System.out.println("    Member Name: " + name);
            System.out.println("    Member IC Number: " + icNo);
            System.out.println("    Member Handphone Number: " + hpNo);
            System.out.println("    Member Email Address: " + emailAddress);
            System.out.println("    Member Card Expired Date: " + expiredDate);
            System.out.println("    Member Birth Date: " + birthDate);
            
            System.out.println("");
            
            System.out.print("Confirm creation of this member? (yes/no): ");
            String confirm = sc.nextLine();
            
            //if yes than store
            if (confirm.equalsIgnoreCase("yes")) {
                Member member = new Member(emailAddress, expiredDate, birthDate, name, icNo, hpNo);
                members.add(member);
                System.out.println("Member has been added.");
                System.out.println("");
            } else {
                System.out.println("Member creation has been canceled.");
                System.out.println("");
            }

            // Ask the user if they want to create another member
            System.out.print("Do you want to create another member? (yes/no): ");
            System.out.println("");
            String createAnotherInput = sc.nextLine();
            createAnotherMember = createAnotherInput.equalsIgnoreCase("yes");
        }

        memberManagement(members);
    }

    
    //Display new member
    public static void retrieveListOfMember( List <Member> members) {
        for (Member m : members) {
            System.out.println("");
            System.out.println("|----New Member details----|");
            System.out.println("    Member Name: " + m.getName());
            System.out.println("    Member IC Number: " + m.getIcNo());
            System.out.println("    Member Handphone Number: " + m.getHpNo());
            System.out.println("    Member Email Address: " + m.getEmailAddress());
            System.out.println("    Member Card Expired Date: " + m.getExpiredDate());
            System.out.println("    Member Birth Date: " + m.getBirthDate());
        }
       memberManagement(members);
    }
    
    //Search member
    public static void retrieveSpecificMember(List <Member> members) {
        
        boolean searchAnotherMember = true;
        //if got error will run again
        while (searchAnotherMember) {
            System.out.println("");
            System.out.print("Enter Member Handphone Number: ");
            String phoneNumber = sc.nextLine();

            boolean found = false;

            for (Member m : members) {
                if (m.getHpNo().equals(phoneNumber)) {//if equals to phone number that user type 
                    System.out.println("**********************************************");
                    System.out.println("*           Search Member details            *");
                    System.out.println("**********************************************");
                    System.out.println("");
                    
                    System.out.println("    Member Name: " + m.getName());
                    System.out.println("    Member IC Number: " + m.getIcNo());
                    System.out.println("    Member Handphone Number: " + m.getHpNo());
                    System.out.println("    Member Email Address: " + m.getEmailAddress());
                    System.out.println("    Member Card Expired Date: " + m.getExpiredDate());
                    System.out.println("    Member Birth Date: " + m.getBirthDate());
                    System.out.println("");
                    
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No member with the phone number " + phoneNumber + " found.");
                System.out.println("");
            }

            // Ask the user if they want to search for another member
            System.out.print("Do you want to search for another member by phone number? (yes/no): ");
            String searchAnotherInput = sc.nextLine();
            searchAnotherMember = searchAnotherInput.equalsIgnoreCase("yes");//check is yes or no it can also sence upper and lower
            System.out.println("");
        }
        memberManagement(members);
    }
    
    //Edit member detail
    public static void updateMember(List<Member> members) {
        boolean updateAnotherMember = true;
        
        while (updateAnotherMember) {
            System.out.println("**********************************************");
            System.out.println("*           Update Member details            *");
            System.out.println("**********************************************");
            System.out.println("");
            System.out.print("Enter Member Handphone Number for update: ");
            String phoneNumber = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).getHpNo().equals(phoneNumber)) {//if equals the hand phone number
                    Member m = members.get(i);

                    // Display current member details
                    System.out.println("|----Current Member Details----|");
                    System.out.println("    Member name: " + m.getName());
                    System.out.println("    Member Ic Number: " + m.getIcNo());
                    System.out.println("    Member Handphone Number: " + m.getHpNo());
                    System.out.println("    Member Email Address: " + m.getEmailAddress());
                    System.out.println("    Member Card Expired Date: " + m.getExpiredDate());
                    System.out.println("    Member Birth Date: " + m.getBirthDate());
                    System.out.println("");
                    System.out.print("Confirm update of this member? (yes/no): ");
                    String confirm = sc.nextLine();
                    System.out.println("");
                    //if confirm want to update this press yes if no than exit
                    if (confirm.equalsIgnoreCase("yes")) {

                        String newName;
                        while (true) {
                            System.out.print("Enter new member name: ");
                            newName = sc.nextLine();

                            if (!newName.matches(".*\\d.*") && newName.length() >= 3) {//check have digit and the length must more than three
                                break; // Exit the loop if the name is valid
                            } else {
                                System.out.println("Invalid name. Name must be at least 3 characters long and cannot contain digits.");
                            }
                        }

                        m.setName(newName);

                        // Input and validation for new supplier IC number
                        String newIcNo;
                        while (true) {
                            System.out.print("Enter new member IC number (exactly 12 characters): ");
                            newIcNo = sc.nextLine();
                            if (newIcNo.length() == 12) {
                                break; // Exit the loop if IC number is valid
                            } else {
                                System.out.println("IC Number must be exactly 12 characters long.");
                            }
                        }

                        m.setIcNo(newIcNo);

                        // Input and validation for new supplier handphone number
                        String newHpNo;
                        while (true) {
                            System.out.print("Enter new member handphone number (exactly 11 digits): ");
                            newHpNo = sc.nextLine();
                            if (newHpNo.length() == 11) {
                                break; // Exit the loop if handphone number is valid
                            } else {
                                System.out.println("Handphone Number must be exactly 11 digits long.");
                            }
                        }

                        m.setHpNo(newHpNo);

                        System.out.print("Enter new email address: ");
                        String newEmailAddress = sc.nextLine();
                        m.setEmailAddress(newEmailAddress);
                        
                        System.out.print("Member Card Expired Date (00-00-0000): ");
                        String newExpiredDate = sc.nextLine();
                        //check the date validation if error will run
                        while (!isValidDate(newExpiredDate)) {
                            System.out.println("Invalid date format. Please enter a date in the format '00-00-0000'.");
                            System.out.print("Member Card Expired Date (00-00-0000): ");
                            newExpiredDate = sc.nextLine();
                        }

                        m.setExpiredDate(newExpiredDate);
                        //check the date validation if error will run
                        System.out.print("Enter new birth date (00-00-0000): ");
                        String newBirthDate = sc.nextLine();

                        while (!isValidDate(newBirthDate)) {
                            System.out.println("Invalid date format. Please enter a date in the format '00-00-0000'.");
                            System.out.print("Enter new birth date (00-00-0000): ");
                            newBirthDate = sc.nextLine();
                        }

                        m.setBirthDate(newBirthDate);

                        members.set(i, m);
                        System.out.println("Member details updated.");
                        System.out.println("");
                    } else {
                        System.out.println("Member update has been canceled.");
                        System.out.println("");
                    }

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No member with the phone number " + phoneNumber + " found.");
                System.out.println("");
            }

            // Ask the user if they want to update another member
            System.out.print("Do you want to update another member by phone number? (yes/no): ");
            String updateAnotherInput = sc.nextLine();
            updateAnotherMember = updateAnotherInput.equalsIgnoreCase("yes");
            System.out.println("");
        }
        memberManagement(members);
    }
    
    //delete member 
    public static void deleteMember(List<Member> members) {
        boolean deleteAnotherMember = true;

        while (deleteAnotherMember) {
            System.out.println("**********************************************");
            System.out.println("*           Delete Member details            *");
            System.out.println("**********************************************");
            System.out.println("");
            System.out.print("Enter Member Handphone Number to delete: ");
            String phoneNumber = sc.nextLine();
            boolean found = false;

            for (int i = 0; i < members.size(); i++) {
                Member member = members.get(i);
                if (member.getHpNo().equalsIgnoreCase(phoneNumber)) {//if match the phone number from the list will prompt message ask user  to enter
                    while (true) {
                        System.out.print("Are you sure you want to delete " + member.getName() + "? (yes/no): ");
                        String confirm = sc.nextLine();
                        System.out.println("");

                        if (confirm.equalsIgnoreCase("yes")) {
                            members.remove(i);
                            System.out.println(member.getName() + " has been deleted.");
                            System.out.println("");
                        } else if (confirm.equalsIgnoreCase("no")) {
                            System.out.println(member.getName() + " deletion has been canceled.");
                            System.out.println("");
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no' to delete the member.");
                            System.out.println("");
                            continue;
                        }
                        break; // Exit the loop after handling deletion
                    }
                    found = true;
                    break; // Exit the loop after finding the member
                }
            }

            if (!found) {
                System.out.println("No member with the phone number " + phoneNumber + " found.");
                System.out.println("");
            }

            System.out.print("Do you want to delete another member? (yes/no): ");
            String deleteAnotherInput = sc.nextLine();
            deleteAnotherMember = deleteAnotherInput.equalsIgnoreCase("yes");
            System.out.println("");
        }
         memberManagement(members);
    }

    
    //arraylst to store member details
    public static void addInitialMember(List<Member> members) {
        
        //write detail
        Member member1 = new Member("Larry2134@gmail.com", "27-9-2024", "19-8-2003", "Larry Tong", "190803071122", "01233455661");
        Member member2 = new Member("Alice2233@gmail.com", "30-10-2024", "19-01-2004", "Alice Tan", "190104072233", "01822399001");
        
        //use to display it to list down
        members.add(member1);
        members.add(member2);
    }
    
    //this is use to display
    public static void displayMembers(List<Member> members) {
    System.out.println("**********************************************");
    System.out.println("*                Member List                 *");
    System.out.println("**********************************************");
    System.out.println("");

    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("| %-4s | %-15s | %-15s | %-15s | %-19s | %-20s | %-20s |\n", "No.", "Name", "IC Number", "Phone Number", "Email Address", "Card Expired Date", "Birth Date");
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

    int counter = 1;
    Set<String> printedICNumbers = new HashSet<>();

    for (Member member : members) {
        if (!printedICNumbers.contains(member.getIcNo())) {
            System.out.printf("| %-4d | %-15s | %-15s | %-15s | %-19s | %-20s | %-20s |\n",
                counter,
                member.getName(),
                member.getIcNo(),
                member.getHpNo(),
                member.getEmailAddress(),
                member.getExpiredDate(),
                member.getBirthDate());
            printedICNumbers.add(member.getIcNo());
            counter++;
        }
    }

    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("");
        memberManagement(members);
    }

}
