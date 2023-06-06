package client;

import domain.Contact;
import domain.ContactAdapter;
import domain.ContactAdapterImpl;
import domain.ContactGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utilities.ContactBuilder;
import utilities.ContactFactory;
import utilities.DefaultContactFactory;
import utilities.PhoneBook;
import utilities.decorators.ContactWithPhotoDecorator;
import utilities.logging.ConsoleContactLogger;
import utilities.logging.ContactLogger;
import utilities.logging.FileContactLogger;
import utilities.logging.LogLevel;
import utilities.sorting.ContactSorter;
import utilities.sorting.NameContactSortStrategy;
import utilities.sorting.PhoneNumberContactSortStrategy;

public class PhoneContactApp {
  public static void main(String[] args) throws IOException, InterruptedException {
    // Chain of Responsibility
    ConsoleContactLogger consoleLogger = new ConsoleContactLogger(LogLevel.INFO);
    ContactLogger fileLogger = new FileContactLogger(LogLevel.DEBUG);

    consoleLogger.setNextLogger(fileLogger);

    fileLogger.logMessage(LogLevel.DEBUG, "Starting app at " + new Date());
    // Singleton
    PhoneBook phoneBook = PhoneBook.getInstance();

    // Builder
    Contact contact1 = new ContactBuilder()
        .setName("Adrian Chiforiuc")
        .setPhoneNumber("060256808")
        .setEmail("chiforiucadrian@mail.com")
        .build();

    // Factory Method
    ContactFactory contactFactory = new DefaultContactFactory();
    Contact contact2 = contactFactory.createContact("Arapu Anatolie", "069030543", "arapu_anatolie@mail.com");

    phoneBook.addContact(contact1);
    phoneBook.addContact(contact2);


    // Adapter
    ContactAdapter contactAdapter1 = new ContactAdapterImpl(contact1);
    ContactAdapter contactAdapter2 = new ContactAdapterImpl(contact2);

    contactAdapter1.display();
    contactAdapter2.display();

    consoleLogger.logMessage(LogLevel.INFO, "---Adapter---");

    // Composite
    ContactGroup familyGroup = new ContactGroup("Family");
    familyGroup.addContact(contactAdapter1);
    familyGroup.addContact(contactAdapter2);
    familyGroup.display();

    consoleLogger.logMessage(LogLevel.INFO, "---Composite---");

    // Decorator
    ContactAdapter decoratedContactAdapter1 = new ContactWithPhotoDecorator(contactAdapter1, "photo1.jpg");
    ContactAdapter decoratedContactAdapter2 = new ContactWithPhotoDecorator(contactAdapter2, "photo2.jpg");

    decoratedContactAdapter1.display();
    decoratedContactAdapter2.display();
    consoleLogger.logMessage(LogLevel.INFO, "---Decorator---");
    // Strategy
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
    Thread.sleep(1000);
    fileLogger.logMessage(LogLevel.DEBUG, "Closing app at  " + new Date());
  }
}