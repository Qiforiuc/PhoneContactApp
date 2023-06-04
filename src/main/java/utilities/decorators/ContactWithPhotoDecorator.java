import domain.ContactAdapter;

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

  // Other methods related to displaying contact with photo
}