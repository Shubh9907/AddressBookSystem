package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    static HashMap<String, AddressBookOperations> map = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        AddressBookOperations addressBook = new AddressBookOperations();

        boolean need = true;
        do {
            System.out.println("1.Create a new Address Book\t2.Exit");

            switch (scan.nextInt()) {
                case 1:
                    System.out.println("Enter address book name");
                    String bookName = scan.next();

                    boolean status = true;
                    do {
                        System.out.println("Choose Operation you want to do");
                        System.out.println("1.Add a contact\t2.Edit contact\t3.Delete a contact\t4.Show a contact details\t5.Search by City\t6.Exit from current address book");
                        switch (scan.nextInt()) {
                            case 1:
                                addressBook.add();
                                break;
                            case 2:
                                addressBook.edit();
                                break;
                            case 3:
                                addressBook.delete();
                                break;
                            case 4:
                                addressBook.showContact();
                                break;
                            case 5:
                                addressBook.searchByCity();
                                break;
                            default:
                                status = false;
                        }
                        System.out.println("Current list " + addressBook.contactList);
                        System.out.println("After Sorting");
                        System.out.println(addressBook.sortAlphabetically());
                    } while (status);
                    map.put(bookName, addressBook);
                    break;
                default:
                    need = false;
            }
            System.out.println("The current map is - " +map);
        }
        while (need);
    }
}