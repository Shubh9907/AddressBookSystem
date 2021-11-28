package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddressBookFileIOOperations {
    public static String AddressBook_File_Name = "addressbook-file.txt";

    public void writeDate(Contacts contacts) {
        StringBuffer bookBuffer = new StringBuffer();
        String contact = contacts.toString().concat("\n");
        bookBuffer.append(contact);

        try {
            Files.write(Paths.get(AddressBook_File_Name),bookBuffer.toString().getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(AddressBook_File_Name).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(AddressBook_File_Name).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}
