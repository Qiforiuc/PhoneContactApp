// Factory Method (ContactFactory)
public interface ContactFactory {
  Contact createContact(String name, String phoneNumber, String email);
}