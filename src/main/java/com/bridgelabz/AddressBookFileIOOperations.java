package com.bridgelabz;

import com.google.gson.Gson;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddressBookFileIOOperations {
    AddressBookOperations operations = new AddressBookOperations();
    public static String AddressBook_File_Name = "addressbook-file.txt";
    public static String AddressBook_CSV_File_Name = "addressbook-CSV-file.csv";
    public static String AddressBook_JSON_File_Name = "addressbook-JSON-file.json";

    /**
     * Method to write data to a file
     * @param contacts
     */
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

    /**
     * Method to print the file data to console
     */
    public void printData() {
        try {
            Files.lines(new File(AddressBook_File_Name).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to count the entries in the file
     * @return
     */
    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(AddressBook_File_Name).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public void writeDataToCSV(ArrayList<Contacts> contacts) throws IOException {
        FileWriter fw = new FileWriter(AddressBook_CSV_File_Name,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (Contacts contact : contacts) {
            String newContact = contact.toString().concat("\n");
            pw.print(contact+"\n");
        }

        pw.flush();
        pw.close();
    }

    public long countEntriesInCSV() {
        long entries = 0;
        try {
            entries = Files.lines(new File(AddressBook_CSV_File_Name).toPath()).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public void writeToJSon(ArrayList<Contacts> contacts) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(contacts);
        FileWriter writer = new FileWriter(AddressBook_JSON_File_Name);
        writer.write(json);
        writer.close();
    }
}
