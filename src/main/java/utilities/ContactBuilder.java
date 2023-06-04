// Builder (ContactBuilder)
public class ContactBuilder {
  private String name;
  private String phoneNumber;
  private String email;

  public ContactBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContactBuilder setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public ContactBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public Contact build() {
    return new Contact(name, phoneNumber, email);
  }
}