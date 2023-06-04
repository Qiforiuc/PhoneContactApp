package domain;

import domain.ContactAdapter;
import domain.ContactAdapterImpl;
import domain.ContactSortStrategy;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneNumberContactSortStrategy implements ContactSortStrategy {
  @Override
  public List<ContactAdapter> sortContacts(List<ContactAdapter> contacts) {
    Collections.sort(contacts, new Comparator<ContactAdapter>() {
      @Override
      public int compare(ContactAdapter contact1, ContactAdapter contact2) {
        return ((ContactAdapterImpl) contact1).getContact().getPhoneNumber()
            .compareTo(((ContactAdapterImpl) contact2).getContact().getPhoneNumber());
      }
    });

    return contacts;
  }
}