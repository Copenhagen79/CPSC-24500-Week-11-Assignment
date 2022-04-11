import java.io.Serializable;

public class Serial implements Serializable {

    private String id;
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String email;

    // String ID, Name, Phone Number, DOB, and email values
    
    public Serial() {}
    public Serial(String id, String name, String phoneNumber, String dateOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    /**
     * ID String
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     */
    
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Email string
     */
    
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     */
    
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of dateOfBirth
     */
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the value of dateOfBirth
     */
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the value of phoneNumber
     */
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the value of phoneNumber
     */
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the value of name
     */
    
    public String getName() {
        return name;
    }

    /**
     * set Name Value
     */
    
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + "| Name: " + name + "| Phone Number: " + phoneNumber + "| Birth Date: " + dateOfBirth + "| Email: " + email;
    }
}