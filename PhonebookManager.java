//Programmer: Ryan Seefeldt 
//Class: CS& 145 Assignment 2
//Date:2/7/2024
//Purpose: This is the file to create the phonebook linked list and support
// the methods that it needs to manipulate the phonebook
// the PhonebookManager is the linked list of ListNode's to generate the phone book.
// Methods:
//   add - this method has 2 types. It will add at the end of the list and it will
//         add after a specific index.
//   size - this will return the number of contacts in the phonebook.
//   remove - this method has 2 types. It will remove the contact by name (This will
//            remove the first instance in the phone book. If there is more than 1
//            instance of that name you will have to remove again. It will also remove
//            by index. This will remove the contact at a specific number.
//   print - This will print the entire contact list.
//   printNode - This will print a contact at a specific index
//   modify - this method has 2 types. It will edit the contact by name (This will
//            edit the first instance in the phone book. If there is more than 1
//            instance of that name you will need to use the index method. It will 
//            also modify by index. This will remove the contact at a specific number.
//            This method will allow you to change the name, address, city, phone number.
//   search - This will allow you to search the contact list for a specific string in 
//            name, address, city, phone number. It will print all contacts that match
//            the criteria.


// Constructor for initializing an empty phone book
public class PhonebookManager {
    private ListNode front;
    
    public PhonebookManager() {
          front = null; //front represents the head of the phonebook list.
    } // end of phonebook manager class


// This is the add method that will add the contact to the end of the phonebook.          
public void add (String fullName, String addr, String cit, String phoneNum) {

     // If the phonebook is empty it will add the first element to the phonebook.
     if (front == null) {
          front = new ListNode(fullName, addr, cit, phoneNum);
     } else {
          ListNode current = front;
          // search the list until you find the last element then add the new contact
          // link to the last element 
          while (current.next != null) {
               current = current.next;
          }
          current.next = new ListNode(fullName, addr, cit, phoneNum);
     }
} // end of add


// This is the add method that will add the contact after the contact number of the index
// that is passed.        
public void add (int index, String fullName, String addr, String cit, String phoneNum) {

       if ( index == 0) {
            front = new ListNode(fullName, addr, cit, phoneNum, front);
       } else {
            ListNode current = front;
            
          // search the list until get to the index passed and add the contact
          // link to that element.
            for (int i = 0; i < index-1; i++) {
                 current = current.next;
            }
            current.next = new ListNode(fullName, addr, cit, phoneNum, current.next);
       }
} // end of add with index                          
                            
// This method will return the number of contacts in the phonebook
public int size () {
     ListNode current = front;
     int counter = 0;
     
     // check for empty phone book. return 0 if empty
     if (current == null)
            return 0;
            
     while (current != null) {
          current= current.next;
          counter = counter+1;
     }
     return counter;
}          


// This method will remove the contact at a specific index passed.
          
public void remove(int index) {

      ListNode current = front;
      // If the index passed is zero assume the first contact is removed.
      if (index == 0 || index == 1) {
            front = current.next;
      } else {
       
           if (current != null) {
     
                for (int i=1; i< index-1; i++) {
                     current = current.next;
                }
                current.next = current.next.next;
         
            } else {
                 // if the phone book is empty print message
                 System.out.println("\nThe Phonebook is empty\n");
            }
       }
       
} // end of remove by index            
     
// This method will remove the first instance of a name in a phonebook.
// It will search the name field until it is found then use that index to
// remove the contact.
public void remove(String fullName) {
      
      ListNode current = front;
      int counter = 0;
      fullName = fullName.toLowerCase(); // move all strings to lower to make                                         
                                         // compare easier
      // name sure the phonebook is not empty                                        
      if (current != null) {
           // search the phonebook for the name to remove
           while (!current.name.toLowerCase().equals(fullName)) {
                current = current.next;
                counter += 1;
           }
           current = front;
           // if the counter is 0 remove the first entry.
           if (counter == 0) {
                front = current.next;
           } else {
                // find the correct contact to remove     
                for (int i=0; i< counter-1; i++) {
                     current = current.next;
                }
                // move linked list to remove the correct element
                current.next = current.next.next;
           }     
       } else {
            System.out.println("\nThe Phonebook is empty\n");
       }
              
} // end of remove with name

// This method will print all contacts in the phonebook.
public void print() {
     
     ListNode current = front;
     // check to see is phonebook is empty
     if (current != null) {
          int counter = 1;
          System.out.println("\nPhonebook\n");
          while (current != null) {
     
               System.out.printf("%d - Name: %s%n",counter,current.name);
               System.out.printf("    Address: %s%n", current.address);
               System.out.printf("    City: %s%n", current.city);
               System.out.printf("    Phone Number: %s%n%n", current.phoneNumber);

               counter += 1;
               current = current.next;
               
          }
     } else {
        System.out.println("\nThe Phonebook is empty\n");
     }       

} // end print 


// This method will print an individual node based on index.

public void printNode(int index) {

     ListNode current = front;

     for (int i=1; i<index;i++) {
          current = current.next;
      }     

     System.out.printf("%n%d - Name: %s%n",index,current.name);
     System.out.printf("    Address: %s%n", current.address);
     System.out.printf("    City: %s%n", current.city);
     System.out.printf("    Phone Number: %s%n", current.phoneNumber);
     
} // end of print node     

// This will modify the contact that matches the name that is sent.
// It will modify the first contact with that name only.
// This will find the correct contact by name and then modify the 
// correct element based on the field and field data passed to the
// method
public void modify (String fullName, String field, String fieldData) {

     int counter = 1;
     ListNode current = front;
     // finds the correct contact name to enter until the end of the 
     // phonebook    

     while ((!current.name.equals(fullName)) && (current.next != null)) {
          current = current.next;
          counter += 1;
     }
     // if the name of entered does not exist print error
     if (current.name.equals(fullName)) {
          // handles the field to edit     
          switch (field) {
               case "1": {
                    current.name = fieldData;
                    break;
               }     
               case "2": {
                    current.address = fieldData;
                    break;
               }     
               case "3": {
                    current.city = fieldData;
                    break;
               }     
               case "4": {
                    current.phoneNumber = fieldData;
                    break;
               }     
               default: {
                    System.out.print("\nInvalid field\n");
                    break;
               } 
           }
           // print contact edited
           printNode(counter);
      } else {
           System.out.println("\n Name is not in Phonebook\n");
      }            
           

} // end of modify


// This will modify the contact that matches the index that is sent.
// This will find the correct contact by index and then modify the 
// correct element based on the field and field data passed to the
// method

public void modify (int index, String field, String fieldData) {

     // if index is greater than the size of the phonebook print error
     if (index > size()) {
          System.out.println("\nEnter index within phonebook\n");
     } else {
          ListNode current = front;
          for (int i=0; i<index-1;i++) {
               current = current.next;
          }     
          switch (field) {
               case "1": {
                    current.name = fieldData;
                    break;
               }     
               case "2": {
                    current.address = fieldData;
                    break;
               }     
               case "3": {
                    current.city = fieldData;
                    break;
               }     
               case "4": {
                    current.phoneNumber = fieldData;
                    break;
               }     
               default: {
                    System.out.print("\nInvalid field\n");
                    break;
               } 
           }
           printNode(index);  
     }      

} // end of modify

// This method will search the phonebook based on the field and
// field data sent. It will print each contact that has this data.

public void searchBook (String field, String fieldData) {

     ListNode current = front;
     int counter=1;
     String currentField ="";
     while (current != null) {  
     
         // This will get the correct data for that contact based
         // of the field passed
         switch (field) {
              case "1": {
                   currentField = current.name;                               
                   break;
              }
              case "2": {
                    currentField = current.address;          
                    break;
              }
               case "3": {
                    currentField = current.city;          
                    break;
               }
               case "4": {
                    currentField = current.phoneNumber;          
                    break;
               }
               default: {
                    break;
               }
          }
          // If the data is matching this will print the contact
          currentField = currentField.toLowerCase();
          fieldData = fieldData.toLowerCase();
          if (currentField.equals(fieldData)) {
               printNode(counter);
          }
          current = current.next;
          counter +=1;
     }     
     

     
} // end of search book          


    
} // end of phonebookmanager
