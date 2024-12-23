/* Allison Doyle
 * CS-320
 * 11/17/2024
 */

package contacttest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("1", "Bob", "Smith", "1112223333", "1234 Maple Ave");
    }

    // Test valid constructor inputs
    @Test
    @DisplayName("Contact is created successfully with valid inputs")
    void testValidContactCreation() {
        assertThat(contact)
            .hasFieldOrPropertyWithValue("id", "1")
            .hasFieldOrPropertyWithValue("firstName", "Bob")
            .hasFieldOrPropertyWithValue("lastName", "Smith")
            .hasFieldOrPropertyWithValue("phone", "1112223333")
            .hasFieldOrPropertyWithValue("address", "1234 Maple Ave");
    }

    // Test constructor with all valid edge-case inputs
    @Test
    @DisplayName("Contact is created successfully with edge-case valid inputs")
    void testContactCreationWithEdgeCases() {
        Contact edgeCaseContact = new Contact("1234567890", "Alice", "Johnson", "9876543210", "1 Main St");
        assertThat(edgeCaseContact.getId()).isEqualTo("1234567890");
        assertThat(edgeCaseContact.getFirst()).isEqualTo("Alice");
        assertThat(edgeCaseContact.getLast()).isEqualTo("Johnson");
        assertThat(edgeCaseContact.getPhoneNumber()).isEqualTo("9876543210");
        assertThat(edgeCaseContact.getAddress()).isEqualTo("1 Main St");
    }

    // Test invalid constructor inputs for ID
    @Test
    @DisplayName("Constructor throws exception for invalid ID")
    void testInvalidIDInConstructor() {
        assertThatThrownBy(() -> new Contact("", "Bob", "Smith", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid ID");

        assertThatThrownBy(() -> new Contact(null, "Bob", "Smith", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid ID");

        assertThatThrownBy(() -> new Contact("12345678901", "Bob", "Smith", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid ID");
    }

    // Test invalid constructor inputs for First Name
    @Test
    @DisplayName("Constructor throws exception for invalid first name")
    void testInvalidFirstNameInConstructor() {
        assertThatThrownBy(() -> new Contact("1", "", "Smith", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid first name");

        assertThatThrownBy(() -> new Contact("1", null, "Smith", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid first name");

        assertThatThrownBy(() -> new Contact("1", "TooLongFirstName", "Smith", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid first name");
    }

    // Test invalid constructor inputs for Last Name
    @Test
    @DisplayName("Constructor throws exception for invalid last name")
    void testInvalidLastNameInConstructor() {
        assertThatThrownBy(() -> new Contact("1", "Bob", "", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid last name");

        assertThatThrownBy(() -> new Contact("1", "Bob", null, "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid last name");

        assertThatThrownBy(() -> new Contact("1", "Bob", "TooLongLastName", "1112223333", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid last name");
    }

    // Test invalid constructor inputs for Phone Number
    @Test
    @DisplayName("Constructor throws exception for invalid phone number")
    void testInvalidPhoneNumberInConstructor() {
        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid phone number");

        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "123", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid phone number");

        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "abcdefghij", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid phone number");

        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "12345678901", "1234 Maple Ave"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid phone number");
    }

    // Test invalid constructor inputs for Address
    @Test
    @DisplayName("Constructor throws exception for invalid address")
    void testInvalidAddressInConstructor() {
        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "1112223333", ""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid address");

        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "1112223333", null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid address");

        assertThatThrownBy(() -> new Contact("1", "Bob", "Smith", "1112223333", "This address is far too long to be valid"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Invalid address");
    }

    // Test setters for updating fields with valid inputs
    @Test
    @DisplayName("Setters correctly update fields with valid inputs")
    void testSettersUpdateFields() {
        contact.setFirst("Alice");
        contact.setLast("Johnson");
        contact.setPhoneNumber("2223334444");
        contact.setAddress("5678 Oak Street");

        assertThat(contact.getFirst()).isEqualTo("Alice");
        assertThat(contact.getLast()).isEqualTo("Johnson");
        assertThat(contact.getPhoneNumber()).isEqualTo("2223334444");
        assertThat(contact.getAddress()).isEqualTo("5678 Oak Street");
    }

    // Test setters with invalid inputs
    @Test
    @DisplayName("Setters handle invalid inputs")
    void testSettersHandleInvalidInputs() {
        contact.setFirst(null);
        contact.setLast("");
        contact.setPhoneNumber(null);
        contact.setAddress("");

        assertThat(contact.getFirst()).isNull();
        assertThat(contact.getLast()).isEmpty();
        assertThat(contact.getPhoneNumber()).isNull();
        assertThat(contact.getAddress()).isEmpty();
    }

    // Test getters return correct values
    @Test
    @DisplayName("Getters return correct values")
    void testGetters() {
        assertThat(contact.getId()).isEqualTo("1");
        assertThat(contact.getFirst()).isEqualTo("Bob");
        assertThat(contact.getLast()).isEqualTo("Smith");
        assertThat(contact.getPhoneNumber()).isEqualTo("1112223333");
        assertThat(contact.getAddress()).isEqualTo("1234 Maple Ave");
    }
}