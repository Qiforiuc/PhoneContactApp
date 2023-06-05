package utilities.decorators;

import domain.ContactAdapter;
import domain.ContactGroup;

public class ContactWithPhotoDecorator extends ContactDecorator {

  private String photo;

  public ContactWithPhotoDecorator(ContactAdapter contactAdapter, String photo) {
    super(contactAdapter);
    this.photo = photo;
  }

  @Override
  public void display() {
    super.display();
    System.out.println("Photo: " + photo);
  }

  @Override
  public String getPhoneNumber() {
    return this.getPhoneNumber();
  }

  @Override
  public void setGroup(ContactGroup group) {
    this.setGroup(group);
  }

  @Override
  public String getName() {
    return this.getPhoneNumber();
  }
}