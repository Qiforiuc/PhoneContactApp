package domain;

import domain.Contact;
import domain.ContactAdapter;
import domain.ContactAdapterImpl;
import domain.ContactSortStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NameContactSortStrategy implements ContactSortStrategy {
  @Override
  public List<ContactAdapter> sortContacts(List<ContactAdapter> contacts) {
    List<Contact> contactList = contacts.stream()
        .map(contactAdapter -> ((ContactAdapterImpl) contactAdapter).getContact())
        .collect(Collectors.toList());

    // Sort the contacts by name
    Collections.sort(contactList);

    // Convert back to domain.ContactAdapter
    return contactList.stream()
        .map(ContactAdapterImpl::new)
        .collect(Collectors.toList());
  }
}