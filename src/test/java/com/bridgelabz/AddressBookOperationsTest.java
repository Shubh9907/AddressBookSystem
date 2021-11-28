package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressBookOperationsTest {
    @Test
    public void givenContactDetails_WhenWrittenToFile_ShouldHaveThatContact() {
        Contacts contacts = new Contacts("shubham", "verma", "xyz", "xyz,", "xyz", "xyz", "xyz", "xyz");
        AddressBookOperations operations = new AddressBookOperations();
        operations.writeContactDetails(contacts);
        operations.printContactDetails();
        long entries = operations.countEntries();
        Assertions.assertEquals(1,entries);
    }
}