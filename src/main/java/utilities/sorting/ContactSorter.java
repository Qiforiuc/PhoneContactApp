package utilities.sorting;

import domain.ContactAdapter;
import java.util.List;

public class ContactSorter {
  private ContactSortStrategy sortStrategy;

  public void setSortStrategy(ContactSortStrategy sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

  public List<ContactAdapter> sortContacts(List<ContactAdapter> contacts) {
    return sortStrategy.sortContacts(contacts);
  }
}