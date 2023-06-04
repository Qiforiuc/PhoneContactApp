import java.util.ArrayList;
import java.util.List;

public class PhoneContactApp {
  public static void main(String[] args) {
    // Chain of Responsibility (ContactLogger)
    ContactLogger consoleLogger = new ConsoleContactLogger(LogLevel.INFO);
    ContactLogger fileLogger = new FileContactLogger(LogLevel.DEBUG);

    consoleLogger.setNextLogger(fileLogger);

    // Singleton (PhoneBook)
    PhoneBook phoneBook = PhoneBook.getInstance();

    // Builder (ContactBuilder)
    Contact contact1 = new ContactBuilder()
        .setName("John Doe")
        .setPhoneNumber("1234567890")
        .setEmail("john.doe@example.com")
        .build();

    // Factory Method (ContactFactory)
    ContactFactory contactFactory = new DefaultContactFactory();
    Contact contact2 = contactFactory.createContact("Jane Smith", "9876543210", "jane.smith@example.com");

    phoneBook.addContact(contact1);
    phoneBook.addContact(contact2);


    // Adapter (ContactAdapter)
    ContactAdapter contactAdapter1 = new ContactAdapterImpl(contact1);
    ContactAdapter contactAdapter2 = new ContactAdapterImpl(contact2);

    contactAdapter1.display();
    contactAdapter2.display();

    consoleLogger.logMessage(LogLevel.INFO, "---Adapter---");

    // Composite (ContactGroup)
    ContactGroup familyGroup = new ContactGroup("Family");
    familyGroup.addContact(contactAdapter1);
    familyGroup.addContact(contactAdapter2);
    familyGroup.display();

    consoleLogger.logMessage(LogLevel.INFO, "---Composite---");

    // Decorator (ContactDecorator)
    ContactAdapter decoratedContactAdapter1 = new ContactWithPhotoDecorator(contactAdapter1, "photo1.jpg");
    ContactAdapter decoratedContactAdapter2 = new ContactWithPhotoDecorator(contactAdapter2, "photo2.jpg");

    decoratedContactAdapter1.display();
    decoratedContactAdapter2.display();
    consoleLogger.logMessage(LogLevel.INFO, "---Decorator---");
    // Strategy (ContactSortStrategy)
    List<ContactAdapter> contacts = new ArrayList<>();
    contacts.add(contactAdapter1);
    contacts.add(contactAdapter2);

    ContactSorter contactSorter = new ContactSorter();

    contactSorter.setSortStrategy(new NameContactSortStrategy());
    List<ContactAdapter> sortedContactsByName = contactSorter.sortContacts(contacts);

    for (ContactAdapter contact : sortedContactsByName) {
      contact.display();
    }
    consoleLogger.logMessage(LogLevel.INFO, "---Strategy 1---");


    contactSorter.setSortStrategy(new PhoneNumberContactSortStrategy());
    List<ContactAdapter> sortedContactsByPhoneNumber = contactSorter.sortContacts(contacts);
    for (ContactAdapter contact : sortedContactsByPhoneNumber) {
      contact.display();
    }
    consoleLogger.logMessage(LogLevel.INFO, "---Strategy 2---");

  }
}