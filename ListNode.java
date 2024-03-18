//Programmer: Ryan Seefeldt 
//Class: CS& 145 Assignment 2
//Date:2/5/2024
//Purpose: This will set up the elements of the phone book.




public class ListNode { 

public String name;
public String address;
public String city;
public String phoneNumber;
public ListNode next;


// This is used to set the initial and last element in the phonebook
// In this the next field is null     
public ListNode(String fullName, String addr, String cit, String phoneNum) {
                 

        this.name = fullName;
        this.address = addr;
        this.city = cit;
        this.phoneNumber = phoneNum;
        this.next = null;
}        

// Constructor for creating a new node with given data and a reference to the next node
public ListNode(String fullName, String addr, String cit, String phoneNum, ListNode next) {
                 

        this.name = fullName;
        this.address = addr;
        this.city = cit;
        this.phoneNumber = phoneNum;
        this.next = next;

} // end of list node

} // end of list node class