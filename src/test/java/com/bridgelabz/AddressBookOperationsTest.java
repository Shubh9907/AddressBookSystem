package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AddressBookOperationsTest {
    static AddressBookOperations operations = new AddressBookOperations();

    @Test
    public void givenContactDetails_WhenWrittenToFile_ShouldHaveThatContact() {
        Contacts contacts = new Contacts("shubham", "verma", "xyz", "xyz,", "xyz", "xyz", "xyz", "xyz");
        operations.writeContactDetails(contacts);
        operations.printContactDetails();
        long entries = operations.countEntries();
        Assertions.assertEquals(1,entries);
    }

    @Test
    void givenContactDetails_whenWrittenToCSV_ShouldHaveThatData() throws IOException {
        Contacts contacts = new Contacts("shubham", "verma", "xyz", "xyz,", "xyz", "xyz", "xyz", "xyz");
        operations.contactList.add(contacts);
        operations.writeContactDetailsToSCV(operations.contactList);
        long entries = operations.countEntriesInSCV();
        Assertions.assertEquals(1,entries);
    }
}