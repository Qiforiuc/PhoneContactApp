public class ContactAdapterImpl implements ContactAdapter {
  private Contact contact;

  public ContactAdapterImpl(Contact contact) {
    this.contact = contact;
  }

  @Override
  public void display() {
    System.out.println("Name: " + contact.getName());
    System.out.println("Phone Number: " + contact.getPhoneNumber());
    System.out.println("Email: " + contact.getEmail());
  }

  public Contact getContact() {
    return contact;
  }
}