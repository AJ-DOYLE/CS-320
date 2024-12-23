/* Allison Doyle
 * CS-320
 * 11/17/2024
 */

package contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final List<Contact> contacts;

    // Constructor
    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    // Add a new contact
    public void addContact(Contact contact) {
        if (getInstance(contact.getId()) == null) {
            contacts.add(contact);
        }
        // If a contact with the same ID exists, do nothing
    }

    // Delete a contact by ID
    public void deleteContact(String id) {
        Contact contact = getInstance(id);
        if (contact != null) {
            contacts.remove(contact);
        }
        // If contact not found, do nothing
    }

    // Update a contact's details by ID
    public Contact updateContact(String id, String firstName, String lastName, String phone, String address) {
        Contact contact = getInstance(id);
        if (contact != null) {
            if (firstName != null && !firstName.isEmpty()) {
                contact.setFirst(firstName);
            }
            if (lastName != null && !lastName.isEmpty()) {
                contact.setLast(lastName);
            }
            if (phone != null && !phone.isEmpty()) {
                contact.setPhoneNumber(phone);
            }
            if (address != null && !address.isEmpty()) {
                contact.setAddress(address);
            }
        }
        return contact; // Return the updated contact or null if not found
    }

    // Get a contact by ID
    public Contact getInstance(String id) {
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                return contact;
            }
        }
        return null; // Contact not found
    }

    // Get all contacts
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts); // Return a copy to prevent modification
    }
}