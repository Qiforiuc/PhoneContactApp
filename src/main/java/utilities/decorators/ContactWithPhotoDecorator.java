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
    // You can choose to return a default value or handle this based on your specific requirements
    return "";
  }

  @Override
  public void setGroup(ContactGroup group) {
  }

  @Override
  public String getName() {
    return "";
  }
  // Other methods related to displaying contact with photo
}