public class DefaultContactFactory implements ContactFactory {
  @Override
  public Contact createContact(String name, String phoneNumber, String email) {
    return new Contact(name, phoneNumber, email);
  }
}