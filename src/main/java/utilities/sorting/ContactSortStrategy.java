package domain;

import domain.ContactAdapter;
import java.util.List;

// Strategy (domain.ContactSortStrategy)
public interface ContactSortStrategy {
  List<ContactAdapter> sortContacts(List<ContactAdapter> contacts);
}