package ContactManager;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Manager {

    // Show all contacts
    // TODO: Add a new contact
    // TODO: Search a contact by her name
    // TODO: Delete an existing contact


    public static void printContacts(Path filePath) throws IOException {

        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
        }

    }

    public static void main(String[] args) throws IOException {
        
        Path filePathToContacts = Paths.get("./src/ContactManager/contacts.txt");

        System.out.println("filePathToContacts = " + filePathToContacts);

        printContacts(filePathToContacts);

//        Files.write(
//                Paths.get("data", String.valueOf(filePathToContacts)),
//                Collections.singletonList("eggs"), // list with one item
//                StandardOpenOption.APPEND
//        );

    }
}
