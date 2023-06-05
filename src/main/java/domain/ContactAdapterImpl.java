package domain;

public class ContactAdapterImpl implements ContactAdapter {
  private Contact contact;
  private ContactGroup group;

  public ContactAdapterImpl(Contact contact) {
    this.contact = contact;
  }

  @Override
  public void display() {
    System.out.println("Name: " + contact.getName());
    System.out.println("Phone Number: " + contact.getPhoneNumber());
    System.out.println("Email: " + contact.getEmail());
  }

  @Override
  public void setGroup(ContactGroup group) {
    this.group = group;
  }

  @Override
  public String toString() {
    // Include the group name if it exists
    if (group != null) {
      return contact.getName() + " " + contact.getPhoneNumber() + " " + contact.getEmail() + " (" + group.getName() + ")";
    } else {
      return contact.getName() + " " + contact.getPhoneNumber() + " " + contact.getEmail();
    }
  }

  @Override
  public String getName() {
    return contact.getName();
  }

  @Override
  public String getPhoneNumber() {
    return contact.getPhoneNumber();
  }
  public Contact getContact() {
    return contact;
  }
}