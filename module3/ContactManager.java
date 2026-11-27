
import java.util.ArrayList;
import java.util.HashMap;

public class ContactManager {

    public static void main(String[] args) {

        // Step 1: Create a HashMap
        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 2: Add five contacts
        contacts.put("Ada Lovelace",
            new Contact("Ada Lovelace", "+1 617 555 0101"));

        contacts.put("Grace Hopper",
            new Contact("Grace Hopper", "+1 617 555 0102"));

        contacts.put("Alan Turing",
            new Contact("Alan Turing", "+1 617 555 0103"));

        contacts.put("Katherine Johnson",
            new Contact("Katherine Johnson", "+1 617 555 0104"));

        contacts.put("Tim Berners-Lee",
            new Contact("Tim Berners-Lee", "+1 617 555 0105"));

        // Step 3: Look up an existing contact
        System.out.println("=== Contact Lookup ===");

        Contact found = contacts.get("Ada Lovelace");

        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Contact not found.");
        }

        // Step 4: Test a nonexistent contact
        Contact missing = contacts.get("John Smith");

        if (missing != null) {
            System.out.println("Found: " + missing);
        } else {
            System.out.println("Contact not found.");
        }

        // Step 5: Copy contacts into an ArrayList
        ArrayList<Contact> sorted =
            new ArrayList<>(contacts.values());

        // Step 6: Sort alphabetically by name
        sorted.sort((a, b) ->
            a.getName().compareTo(b.getName()));

        // Step 7: Print sorted contacts
        System.out.println();
        System.out.println("=== All Contacts ===");

        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
}
