package utilities.sorting;

import domain.ContactAdapter;
import java.util.List;

public interface ContactSortStrategy {
  List<ContactAdapter> sortContacts(List<ContactAdapter> contacts);
}