//Programmer: Ryan Seefeldt
//Class: CS& 145 Assignment 2
//Date:2/7/2024
//Purpose: This is the user input program that is used to build the phonebook.
// If will allow you the following options:
// add contact - This will allow user to add to the phonebook in 3 ways.
// 1. add to the beginning of the phonebook
// 2. after a specific index entered by the user
// 3. at the end of the phone book
// remove contact - this will allow user to remove contact either by name or
// by contact number
// view contact - This will print the entire contact list.
// search - This will search the contact list by (name, address, city, phone
// number)
// This choice is entered by the user
// Edit contact - The user can choose to edit contact by name or contact number.
// Then will be prompted for which field to edit.
// Quit - Exit program.
// fillbook - hidden command to allow the programmer to fill the phonebook for
// testing.
// This can be commented out but I left it in so teacher could fill
// book easier.
// Extra Credit: added the ability to enter more than just the number on user
// choices.
// (ex. for add you can enter 1 or a or add and any variation with
// capital
// letters)

import java.util.*;
public class PhonebookTester {

     // This is the main program where the phonebook application is executed.
     public static void main(String[] args){
          PhonebookManager phonebook = new PhonebookManager();
          boolean contEntry = true;
          do {
             // print the number of choices for main menu.
             printChoices();
             // Get the command.
             String command = getString(" Choice: ");
             // convert the command to lower case for earier compare
             command = command.toLowerCase();
             int index=0;
             switch (command) {
                  // This will allow user to add elements to:
                  // 1. Beginning of the phonebook
                  // 2. After index entered by user
                  // 3. End of the phonebook.
                  case "1":
                  case "add":
                  case "a": {
                     // Print the choices for adding to the phone book.
                     printAddChoices();
                     String entryPosition = getString(" Add Choice: ");
                     entryPosition = entryPosition.toLowerCase();
                     // if the user is entering by index this will get contact number
                     // from the user and check it if is greater than the size of the
                     // book.
                     boolean error = true;
                     // This will handle data entry for get index and error if user
                     // enters invalid choice
                     switch(entryPosition) {
                        case "2":
                        case "i":
                        case "index": {
                           int sizeBook = phonebook.size();
                           index = getIndex(sizeBook, " Choose index to enter: ");
                           error = false;
                           break;
                        }
                        case "1":
                        case "b":
                        case "beginning":
                        case "3":
                        case "e":
                        case "end": {
                           error = false;
                           break;
                        }
                           default: {
                           break;
                        }
                     }
                     if (error) {
                        System.out.println("\nInvalid Entry\n");
                        break;
                     }
                     // get date from user that will be used to fill the contact.
                     String fullName = getString(" Enter Name: ");
                     String addr = getString(" Enter Address: ");
                     String cit = getString(" Enter City: ");
                     String phoneNum = getString(" Enter Phone Number: ");
                     switch (entryPosition) {
                        case "1": // add to the begining of the book
                        case "b":
                        case "beginning": {
                           phonebook.add(0,fullName,addr,cit,phoneNum);
                           break;
                        }
                        case "2": // add after the contact name entered by user
                        case "i":
                        case "index": {
                           phonebook.add(index,fullName,addr,cit,phoneNum);
                           break;
                        }
                        case "3": // add the the end of the book.
                        case "e":
                        case "end": {
                           phonebook.add(fullName,addr,cit,phoneNum);
                           break;
                        }
                        default: {
                           System.out.print("\n Invalid command\n");
                           break;
                        }
                     }
                     break;
                  }
                  
                  // This will allow the user to remove an element from the phonebook
                  // either by name or by index.
                  case "2":
                  case "remove":
                  case "r": {
                     // exit if phone book is empty.
                     if (phonebook.size() == 0) {
                        System.out.println("\nPhonebook is empty\n");
                        break;
                     }
                     // print choices for removing item by index or name
                     printRemModChoices("\n Choose if to remove my index or name");
                     String removeCommand = getString(" Enter Choice: ");
                     removeCommand = removeCommand.toLowerCase(); // set to lower case for
                                                                  // compare
                     // check if by name (1,n,name) or by contact number (2,i,index)
                     // and call appropriate remove command
                     if (removeCommand.equals("1") || removeCommand.equals("n")
                                 || removeCommand.equals("name")) {
                        String fullName = getString(" Enter Name to Remove: ");
                        phonebook.remove(fullName);
                     } else {
                        if (removeCommand.equals("2") || removeCommand.equals("i")
                                    || removeCommand.equals("index")) {
                           int sizeBook = phonebook.size();
                           index = getIndex(sizeBook, " Enter Contact Number to remove: ");
                           phonebook.remove(index);
                        } else {
                           System.out.println("\n Invalid command");
                        }
                     }
                     break;
                  }
                  // This will print all phonebook entries
                  case "3": // print complete contact list
                  case "view":
                  case "v": {
                     // exit if phone book is empty.
                     if (phonebook.size() == 0) {
                        System.out.println("\nPhonebook is empty\n");
                        break;
                     }
                     phonebook.print();
                     break;
                  }
                  // This will search phonebook by field
                  // and print all entries that include that data
                  case "4":
                  case "search":
                  case "s": {
                     // exit if phone book is empty.
                     if (phonebook.size() == 0) {
                        System.out.println("\nPhonebook is empty\n");
                        break;
                     }
                     String commandFieldData;
                     printFieldsList("Enter which field to search");
                     command = getString("Enter Choice: ");
                     commandFieldData = getFieldData(command);
                     phonebook.searchBook(command,commandFieldData);
                     break;
                  }
                  // edit contact list by name or index
                  case "5":
                  case "edit":
                  case "e": {
                     // exit if phone book is empty.
                     if (phonebook.size() == 0) {
                        System.out.println("\nPhonebook is empty\n");
                        break;
                     }
                     // print choices name and index and get data
                     printRemModChoices("\n Choose if to edit by index or name");
                     String editCommand = getString(" Enter Choice: ");
                     // change to lower case for easy compare.
                     editCommand = editCommand.toLowerCase();
                     // check if by name or by index and get appropriate data to
                     // modify list.
                     if (editCommand.equals("1") || editCommand.equals("n")
                                 || editCommand.equals("name")) {
                        String fullName = getString(" Enter Contact Name to Modify: ");
                        printFieldsList("Enter which field to Edit");
                        String field = getString(" Enter Choice: ");
                        String fieldData = getFieldData(field);
                        phonebook.modify(fullName, field, fieldData);
                     } else {
                        if (editCommand.equals("2") || editCommand.equals("i")
                                       || editCommand.equals("index")) {
                           int sizeBook = phonebook.size();
                           index = getIndex(sizeBook, "Enter Contact Number to edit: ");
                           printFieldsList(" Enter which field to Edit");
                           String field = getString(" Enter Choice: ");
                           String fieldData = getFieldData(field);
                           phonebook.modify(index, field, fieldData);
                        } else {
                           System.out.println("\n Invalid command");
                        }
                     }
                     break;
                  }
                  // Allows user to exit the program.
                  case "6": // quit program
                  case "quit":
                  case "q": {
                     System.out.println("\nThank you for visiting Phonebook");
                     contEntry = false; // set to false to exit while loop
                     break;
                  }
                  // This is a hidden test command to fill the phonebook with
                  // data if desired for easier testing.
                  case "fillbook": {
                     phonebook.add("ryan","10 place", "oceanside","555-1212");
                     phonebook.add("david","11 place", "lake worth","555-1213");
                     phonebook.add("john","12 place", "san diego","555-1214");
                     phonebook.add("ryan","13 place", "bellingham","555-1215");
                     phonebook.add("jason","14 place", "lynn","555-1216");
                     phonebook.add("sandy","15 place", "salem","555-1217");
                     phonebook.add(0,"added","2 place", "atlanta","555-1061");
                     phonebook.add("loki","16 place", "plantation","555-1218");
                     break;
                  }
                  // Will alert user that it is not a valid command
                  default: {
                     System.out.println("Invalid Entry\n");
                     break;
                  }
               }
            } while (contEntry);


   } // end of main
   
   
   // This method will allow the user to get a string of data and print the prompt
   // for that string
   public static String getString(String printText) {
      Scanner reader = new Scanner(System.in);
      String command;
      System.out.print(printText);
      command= reader.nextLine();
      return command;
   } // end of getcommand


   // This method will print the main menu choices for the phonebook menu
   public static void printChoices() {
      System.out.println("\nPlease select an option:");
      System.out.println("1 - (Add) Contact");
      System.out.println("2 - (Remove) Contact");
      System.out.println("3 - (View) Contacts");
      System.out.println("4 - (Search)");
      System.out.println("5 - (Edit)");
      System.out.println("6 - (Quit)");
   } // end of print choices


   // This method will print the choices if the user would like to add a contact to
   // the phone book
   public static void printAddChoices() {
      System.out.println("\nPlease enter where you would like to add contact");
      System.out.println("1 - Add at the Beginning of list");
      System.out.println("2 - Add after index");
      System.out.println("3 - Add at the End of List");
   } // end of print add choices


   // This method will print the options for allowing entry for the search menu.
   public static void printFieldsList(String option) {
      System.out.println(option);
      System.out.println("1 - Name");
      System.out.println("2 - Address");
      System.out.println("3 - City");
      System.out.println("4 - Phone Number");
   } //end of print fields list


   // This method is used by the remove and modify choices to print the name and index
   // choices
   public static void printRemModChoices(String printText) {
      System.out.println(printText);
      System.out.println("1 - by Name");
      System.out.println("2 - by Index");
   } // end of remove modify choices


   // This method allows the user to get an integer when needed as an contact number
   public static int getIndex(int size, String printText) {
      Scanner reader = new Scanner(System.in);
      int command;
      System.out.print(printText);
      command = reader.nextInt();
      if (command > size) {
         command = size;
      }
      reader.nextLine(); // Employ the scanner consuming the nextLine character
      return command;
   } // end of getIndex


   // This method is by used by edit choice to prompt the user correctly based on the
   // field the user would like to edit and it returns the correct data.
   public static String getFieldData(String field) {
      String commandPrompt = "";
      String commandFieldData;
      switch (field) {
         case "1":
         case "n":
         case "name": {
            commandPrompt = " Enter Name: ";
            break;
         }
         case "2":
         case "a":
         case "address": {
            commandPrompt = " Enter Address: ";
            break;
         }
         case "3":
         case "c":
         case "city": {
            commandPrompt = " Enter City: ";
            break;
         }
         case "4":
         case "p":
         case "phone": {
            commandPrompt = " Enter Phone Number: ";
            break;
         }
         default: {
            break;
         }
      }
      commandFieldData = getString(commandPrompt);
      return commandFieldData;
   } // end of get field data

} //end phonebooktester