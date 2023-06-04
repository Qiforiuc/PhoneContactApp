import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
  private static PhoneBook instance;
  private List<Contact> contacts;

  private PhoneBook() {
    contacts = new ArrayList<>();
  }

  public static PhoneBook getInstance() {
    if (instance == null) {
      instance = new PhoneBook();
    }
    return instance;
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  public void removeContact(Contact contact) {
    contacts.remove(contact);
  }

  public void displayContacts() {
    for (Contact contact : contacts) {
      System.out.println(contact.getName() + " : " + contact.getPhoneNumber());
    }
  }

  // Other methods related to managing contacts
}