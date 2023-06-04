package utilities.decorators;

import domain.ContactAdapter;

public abstract class ContactDecorator implements ContactAdapter {
  protected ContactAdapter contactAdapter;

  public ContactDecorator(ContactAdapter contactAdapter) {
    this.contactAdapter = contactAdapter;
  }

  @Override
  public void display() {
    contactAdapter.display();
  }
}