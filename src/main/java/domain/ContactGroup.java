package domain;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup implements ContactAdapter {
  private String groupName;
  private List<ContactAdapter> contacts;

  public ContactGroup(String groupName) {
    this.groupName = groupName;
    contacts = new ArrayList<>();
  }

  public void addContact(ContactAdapter contact) {
    contacts.add(contact);
  }

  public void removeContact(ContactAdapter contact) {
    contacts.remove(contact);
  }

  @Override
  public void display() {
    System.out.println("Group Name: " + groupName);
    for (ContactAdapter contact : contacts) {
      contact.display();
    }
  }
  @Override
  public String getPhoneNumber() {
    return "";
  }

  @Override
  public void setGroup(ContactGroup group) {
  }

  @Override
  public String getName() {
    return groupName;
  }

  @Override
  public String toString()
  {
    return groupName;
  }

}