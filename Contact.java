/* Allison Doyle
*/

package contact;


public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String id, String first, String last, String phoneNumber, String address) {
        if (id == null || id.isEmpty() || id.length() > 10) {
            throw new IllegalArgumentException("Invalid ID: must not be null, empty, or longer than 10 characters.");
        }
        if (first == null || first.isEmpty() || first.length() > 10) {
            throw new IllegalArgumentException("Invalid first name: must not be null, empty, or longer than 10 characters.");
        }
        if (last == null || last.isEmpty() || last.length() > 10) {
            throw new IllegalArgumentException("Invalid last name: must not be null, empty, or longer than 10 characters.");
        }
        if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number: must be exactly 10 digits.");
        }
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address: must not be null, empty, or longer than 30 characters.");
        }

        this.id = id;
        this.firstName = first;
        this.lastName = last;
        this.phone = phoneNumber;
        this.address = address;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirst(String first) {
        this.firstName = first;
    }

    public void setLast(String last) {
        this.lastName = last;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}