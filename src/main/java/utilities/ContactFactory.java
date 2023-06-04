package utilities;

import domain.Contact;

public interface ContactFactory {
  Contact createContact(String name, String phoneNumber, String email);
}