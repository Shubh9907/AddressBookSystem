package com.bridgelabz;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookOperations {
    ArrayList<Contacts> contactList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);


    /*
    Method to add a new contact
     */
    public void add() {
        System.out.println("Enter First name:");
        String firstName = scan.next();
        System.out.println("Enter last name:");
        String lastName = scan.next();


        if (contactList.size() == 0) {

            System.out.println("Enter the address:");
            String address = scan.next();

            System.out.println("Enter the City:");
            String city = scan.next();

            System.out.println("Enter the State:");
            String state = scan.next();

            System.out.println("Enter the Zip:");
            String zip = scan.next();

            System.out.println("Enter the Phone Number:");
            String phoneNumber = scan.next();

            System.out.println("Enter the Email");
            String email = scan.next();

            Contacts contacts = new Contacts(firstName,lastName,address,city,state,email,zip,phoneNumber);
            writeContactDetails(contacts);
            this.contactList.add(contacts);
        } else {
            int n = 1;
            int flag = 0;
            for (Contacts contact : contactList) {

                if (firstName.equals(contact.getFirstName()) && lastName.equals(contact.getLastName())) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println("This name is already present in the address book");
            } else {
                System.out.println("Enter the address:");
                String address = scan.next();

                System.out.println("Enter the City:");
                String city = scan.next();

                System.out.println("Enter the State:");
                String state = scan.next();

                System.out.println("Enter the Zip:");
                String zip = scan.next();

                System.out.println("Enter the Phone Number:");
                String phoneNumber = scan.next();

                System.out.println("Enter the Email");
                String email = scan.next();

                Contacts contacts = new Contacts(firstName,lastName,address,city,state,email,zip,phoneNumber);
                this.contactList.add(contacts);
            }
        }
    }

    /*
    Method to edit an existing contact
     */
    public void edit() {
        System.out.println("Enter First name:");
        String firstName = scan.next();
        Iterator<Contacts> iterator = this.contactList.listIterator();
        int flag = 0;

        while (iterator.hasNext()) {
            Contacts contacts = iterator.next();

            if (firstName.equals(contacts.getFirstName())) {
                flag = 1;
                System.out.println("Choose field you want to edit:");
                System.out.println("1.Last Name\t2.Address\t3.City\t4.State\t5. Zip\t6.Phone Number\t7.Email");
                switch (scan.nextInt()) {
                    case 1:
                        System.out.println("Re-Correct Last Name");
                        contacts.setLastName(scan.next());
                        break;
                    case 2:
                        System.out.println("Re-Correct Address");
                        contacts.setAddress(scan.next());
                        break;
                    case 3:
                        System.out.println("Re-Correct City");
                        contacts.setCity(scan.next());
                        break;
                    case 4:
                        System.out.println("Re-Correct State");
                        contacts.setState(scan.next());
                        break;
                    case 5:
                        System.out.println("Re-Correct Zip");
                        contacts.setZip(scan.next());
                        break;
                    case 6:
                        System.out.println("Re-Correct Phone Number");
                        contacts.setPhoneNumber(scan.next());
                        break;
                    case 7:
                        System.out.println("Re-Correct Email");
                        contacts.setEmail(scan.next());
                        break;
                }
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Contact not found");
        }
    }

    /*
    Method to delete an existing contact
     */
    public void delete() {
        System.out.println("Enter First name:");
        String firstName = scan.next();
        int flag = 0;

        for (Contacts contacts : contactList) {

            Contacts contact = contacts;

            if (firstName.equals(contact.getFirstName())) {
                flag = 1;
                System.out.println("Contact successfully Deleted");
                contactList.remove(contacts);
            }
        }
        if (flag == 0) {
            System.out.println("Contact not found");
        }
    }

    /*
    Method to show details of a contact
     */
    public void showContact() {
        System.out.println("Enter First name:");
        String firstName = scan.next();
        int flag = 0;
        Iterator<Contacts> iterator = contactList.listIterator();

        while (iterator.hasNext()) {
            Contacts contacts = iterator.next();

            if (firstName.equals(contacts.getFirstName())) {
                flag = 1;
                System.out.println(contacts.toString());
            }
        }
        if (flag == 0) {
            System.out.println("Contact not found");
        }
    }

    /*
    Method to search contacts by city
     */
    public void searchByCity() {
        System.out.println("Enter City");
        String cityName = scan.next();
        List filterListByCity = contactList.stream().filter(contact -> contact.getCity().equalsIgnoreCase(cityName)).collect(Collectors.toList());
        System.out.println("Contact having " +cityName+ " name are:- \n" +filterListByCity);
        System.out.println("Total contacts having this city are:- " +filterListByCity.size());
    }

    public List sortAlphabetically () {
        List contactList2 = contactList.stream().sorted(Comparator.comparing(contact -> contact.getFirstName())).collect(Collectors.toList());
        return contactList2;
    }

    public void writeContactDetails(Contacts contacts) {
        new AddressBookFileIOOperations().writeDate(contacts);
    }

    public void printContactDetails() {
        new AddressBookFileIOOperations().printData();
    }

    public long countEntries() {
        return new AddressBookFileIOOperations().countEntries();
    }

    public void writeContactDetailsToSCV(ArrayList<Contacts> contacts) throws IOException {
        new AddressBookFileIOOperations().writeDataToCSV(contacts);
    }

    public long countEntriesInSCV() {
        return new AddressBookFileIOOperations().countEntriesInCSV();
    }
}