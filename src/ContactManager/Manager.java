package ContactManager;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Manager {

    private static final Input scn = new Input();

    // Show all contacts
    // Add a new contact
    // Search a contact by her name
    // TODO: Delete an existing contact


    public static void printContacts(Path filePath) throws IOException {

        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
        }

    }

    public static void addContact(Path filePath, String contactName) throws IOException {

        Files.write(
                filePath,
                Arrays.asList(contactName),
                StandardOpenOption.APPEND
        );
    }

    public static String searchContact(Path filePath, String contactName) throws IOException {

        String match = "Match not found.";

        Scanner scan = new Scanner(new FileInputStream(String.valueOf(filePath)));
        while (scan.hasNextLine()) {
            String currentLine = scan.nextLine();
            if (currentLine.contains(contactName)) {
                match = currentLine;
            }
        }
        return match;
    }

    public static boolean ghostContact(Path filePath, String contactName) throws IOException {

        List<String> handsomeList = new ArrayList<>();

        Scanner scan = new Scanner(new FileInputStream(String.valueOf(filePath)));
        while (scan.hasNextLine()) {
            String currentLine = scan.nextLine();
            if (!currentLine.contains(contactName)) {
                handsomeList.add(currentLine);
            } else {
                System.out.println("Deleting " + currentLine);
            }
        }
        Path deWay = Files.write(Paths.get(String.valueOf(filePath)), handsomeList);
        return Files.exists(deWay);
    }


    // MAIN METHOD
    public static void main(String[] args) throws IOException {
        
        Path filePathToContacts = Paths.get("./src/ContactManager/contacts.txt");

        System.out.println("filePathToContacts = " + filePathToContacts);

        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");

        int numInput = scn.getInt("\nWhat would you like to do?");
        String contact;

        switch (numInput) {
            case 1 -> {
                System.out.println("\nPrinting contacts...\n");
                printContacts(filePathToContacts);
            }
            case 2 -> {
                contact = scn.getString("\nTo create a new contact, enter their name, followed by their number with no dashes: ");
                addContact(filePathToContacts, contact);
                System.out.println("\nContact added.\n");
            }
            case 3 -> {
                contact = scn.getString("\nWho are you looking for? \n");
                System.out.println(searchContact(filePathToContacts, contact));
            }
            case 4 -> {
                contact = scn.getString("\nEnter the name of who to delete: \n");
                System.out.println(ghostContact(filePathToContacts, contact));

            }
            case 5 -> System.out.println("\nExiting...");
        }
    }
}
