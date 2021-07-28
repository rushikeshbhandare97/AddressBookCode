import java.util.ArrayList;
import java.util.Scanner;

public class Main {





        public static void main(String[] args) {

            // Initiation of variables
            MenuSystem menuSystem = new MenuSystem();
            AddressBook addressBook = new AddressBook();
            Scanner in = new Scanner(System.in);
            Contact contact = new Contact();
            Boolean quit = false;
            boolean customFieldBoolean = false;
            String repeat;
            String yesOrNo = "n";
            boolean validInput;
            ;
            String crudeMenuChoice = null;

            // The main loop that will loop until the application closes
            do {

                // Displays the main menu system
                repeat = null;
                menuSystem.displayMainMenu();

                // Displays contact if there is a current one, else alerts.
                if (addressBook.getCurrentContact() != null) {
                    System.out.println("*****Current Contact*****");
                    System.out.println(addressBook.getCurrentContact().toString());
                } else {
                    System.out.println("*****No Current Contact*****");
                }

                // Asks for user to input menu # and then stores it in menuChoice variable
                System.out.println();
                System.out
                        .print("Please choose a menu item above by entering a number (1-8): ");

                validInput = false;
                // Catches invalid inputs repeats until it receives the acceptable input
                while (validInput == false) {
                    validInput = true;
                    crudeMenuChoice = in.nextLine();

                    try {
                        int menuChoice = Integer.parseInt(crudeMenuChoice);

                    } catch (Exception e) {
                        validInput = false;
                        System.out.println();
                        System.out.print("Invalid input, try again: ");

                    } finally {
                        if (validInput == true) {
                            int menuChoice = Integer.parseInt(crudeMenuChoice);
                            if (1 > menuChoice || 8 < menuChoice) {
                                validInput = false;
                                System.out.println();
                                System.out.print("Invalid number, try again: ");
                            }
                        }

                    }

                }
                // Converts the input into a legitimate integer
                int menuChoice = Integer.parseInt(crudeMenuChoice);

                // Main switch which takes user the menu number that they have selected
                switch (menuChoice) {
                    case 1: // displays next contact
                        addressBook.next();

                        break;
                    case 2: // displays previous contact
                        addressBook.previous();

                        break;
                    case 3: // Adds a new contact
                        // Gathers default field values first
                        menuSystem.displayAddContactMenu();
                        contact = new Contact();
                        System.out.println();
                        System.out.print("Enter First Name: ");
                        String firstName = in.nextLine();
                        contact.setFirstName(firstName);
                        System.out.print("Enter Last Name: ");
                        String lastName = in.nextLine();
                        contact.setLastName(lastName);
                        System.out.println("Enter the Address: ");
                        String  Address= in.nextLine();
                        contact.setAddress(Address);
                        System.out.println("Enter the City: ");
                        String City= in.nextLine();
                        contact.setCity("City Name");
                        System.out.println("Enter the State: ");
                        String State=in.nextLine();
                        contact.setState("State name");
                        System.out.println("Enter the Zip: ");
                        String Zip = in.nextLine();
                        contact.setZip("Zip Code");
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = in.nextLine();
                        contact.setPhoneNumber(phoneNumber);
                        System.out.print("Enter Email: ");
                        String email = in.nextLine();
                        contact.setEmailAddress(email);
                        addressBook.addContact(contact);

                        // Gives user the option to add a custom field while creating a "new" contact

                        System.out.print("(Optional) Custom Field (Y/N)? ");
                        yesOrNo = in.nextLine();
                        if (yesOrNo.toLowerCase().equals("y")) {
                            customFieldBoolean = false;
                            while (customFieldBoolean == false) {
                                System.out.print("Enter your custom fields name: ");
                                String customField = in.nextLine();
                                System.out.print("Enter a value for" + customField
                                        + ":");
                                String customFieldValue = in.nextLine();
                                contact.setCustomField(customField, customFieldValue);
                                System.out
                                        .print("Would you like to add another custom field (Y/N): ");
                                yesOrNo = in.nextLine();

                                // functionality to add another custom field should the
                                // user feel so inclined.
                                if (yesOrNo.toLowerCase().equals("n"))
                                    customFieldBoolean = true;
                            }
                        }
                        break;

                    case 4: // Deletes a contact
                        menuSystem.displayDeleteContactMenu();
                        yesOrNo = in.nextLine();
                        if (yesOrNo.toLowerCase().equals("y"))
                            addressBook.deleteContact();
                        break;

                    case 5: // Updates a contact
                        menuSystem.displayUpdateContactMenu();
                        String crudeUpdateInfo = in.nextLine();
                        if (crudeUpdateInfo.contains(","))
                            addressBook.updateContact(crudeUpdateInfo.substring(0,
                                    crudeUpdateInfo.indexOf(",")), crudeUpdateInfo
                                    .substring(crudeUpdateInfo.indexOf(",") + 1,
                                            crudeUpdateInfo.length()));
                        else
                            System.out
                                    .println("Info was not entered correctly, please make sure to use a comma!");
                        System.out.println("Press [Enter] to continue");
                        repeat = in.nextLine();
                        if (!repeat.equals(null))
                            break;
                        break;

                    case 6: // Displays number of current contacts
                        menuSystem.displayNumberOfContactsMenu();
                        System.out.println(addressBook.getContactCount());
                        System.out.println();
                        System.out.println("Press [Enter] to continue");
                        repeat = in.nextLine();
                        if (!repeat.equals(null))
                            break;

                    case 7: // Searches for a contact and gives option to display the search results
                        menuSystem.displaySearchForContactMenu();
                        String searchInfo = in.nextLine();
                        ArrayList<Contact> matches = addressBook
                                .searchForContact(searchInfo);
                        if (matches.size() == 0) {
                            System.out.println("There were 0 results found.");
                            System.out.println();
                            System.out.println("Press [Enter] to continue");
                            repeat = in.nextLine();
                            if (!repeat.equals(null))
                                break;
                        } else
                            System.out.println("There were " + matches.size()
                                    + " results found.");
                        System.out
                                .println("Would you like to print out the results (Y/N)?");
                        yesOrNo = "n";
                        yesOrNo = in.nextLine();
                        if (yesOrNo.toLowerCase().equals("y")) {

                            System.out.println("**********");
                            System.out.println("Search Results:");
                            System.out.println();
                            for (Contact match : matches) {
                                System.out.println(match.toString());
                                System.out.println("----------");
                            }
                            System.out.println("**********");

                            System.out.println();
                            System.out.println("Press [Enter] to continue");
                            repeat = in.nextLine();
                            if (!repeat.equals(null))
                                break;
                        } else
                            break;
                    case 8: // Terminates the application
                        menuSystem.displayQuitApplicationMenu();
                        yesOrNo = in.nextLine();
                        if (yesOrNo.toLowerCase().equals("y")) {
                            System.out.println();
                            System.out.println("***** Application terminated. *****");
                            quit = true;
                        }
                        break;
                    default: // Default output for invalid inputs that pass the filters above the switch
                        System.out.println();
                        System.out.println("Unknown error!");
                        break;
                }

            } while (quit != true);

        }
    }











