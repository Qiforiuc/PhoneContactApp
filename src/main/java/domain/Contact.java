// Contact class
public class Contact implements Comparable<Contact>{
  private String name;
  private String phoneNumber;
  private String email;

  public Contact(String name, String phoneNumber, String email) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Getters and setters

  // Other methods related to the contact

  @Override
  public String toString() {
    return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
  }

  @Override
  public int compareTo(Contact other) {
    return this.name.compareTo(other.getName());
  }
}