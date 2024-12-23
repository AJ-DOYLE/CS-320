/* Allison Doyle
 * CS-320
 * 11/17/2024
 */

package contacttest;

import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Alice", "Peterson", "1234567890", "123 Bush St");

        service.addContact(contact);

        Contact fetchedContact = service.getInstance("1");
        assertNotNull(fetchedContact);
        assertEquals("Alice", fetchedContact.getFirst());
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Alice", "Peterson", "1234567890", "123 Bush St");

        service.addContact(contact);
        service.deleteContact("1");

        assertNull(service.getInstance("1"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Alice", "Peterson", "1234567890", "123 Bush St");

        service.addContact(contact);
        service.updateContact("1", "Alicia", "Johnson", "0987654321", "456 Oak St");

        Contact updatedContact = service.getInstance("1");
        assertNotNull(updatedContact);
        assertEquals("Alicia", updatedContact.getFirst());
        assertEquals("Johnson", updatedContact.getLast());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("456 Oak St", updatedContact.getAddress());
    }

    @Test
    void testGetAllContacts() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "Alice", "Peterson", "1234567890", "123 Maple St"));
        service.addContact(new Contact("2", "Bob", "Johnson", "0987654321", "456 Oak St"));

        List<Contact> contacts = service.getAllContacts();
        assertEquals(2, contacts.size());
    }
}