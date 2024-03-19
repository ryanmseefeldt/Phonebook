Single Linked List Phonebook

Overview:

This Java program focuses on implementing a single linked list to manage a phonebook. It includes three main classes: ListNode, PhonebookManager, and PhonebookTester (with the main() method). The program allows users to add, delete, modify, and print entries in the phonebook. It does not use Java's built-in LinkedList class, but instead implements its own linked list.

Key Features:

Implementation of a single linked list
If will allow you the following options:

add contact - This will allow user to add to the phonebook in 3 ways.

add to the beginning of the phonebook
after a specific index entered by the user
at the end of the phone book
remove contact - this will allow user to remove contact either by name or by contact number

view contact - This will print the entire contact list in nice format.

search - This will search the contact list by (name, address, city, phone number)

Edit contact - The user can choose to edit contact by name or contact number. Then will be prompted for which field to edit. Quit - Exit program.

fillbook - hidden command to allow the programmer to fill the phonebook for testing. This can be commented out but I left it in so teacher could fill book easier.

File Structure

ListNode.java: Defines the structure of a single node in the linked list, containing fields for first name, last name, address, city, and phone number.
PhonebookManager.java: Manages the operations on the phonebook, including adding, deleting, modifying, and printing entries.
PhonebookTester.java: Contains the main() method for testing the functionality of the program.
GitHub Portfolio:

This program is included in the GitHub portfolio to showcase skills and abilities to potential employers. The implementation is designed to be efficient, well-organized, and user-friendly.

Added the ability to enter more than just the number on user choices. (ex. for add you can enter 1 or a or add and any variation with capital letters)
