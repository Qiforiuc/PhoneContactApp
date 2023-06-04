package domain;

public interface ContactAdapter {
  void display();
  String getName();
  String getPhoneNumber();
  void setGroup(ContactGroup group);
}