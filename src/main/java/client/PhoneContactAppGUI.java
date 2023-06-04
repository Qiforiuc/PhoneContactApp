package client;

import domain.Contact;
import domain.ContactAdapter;
import domain.ContactAdapterImpl;
import domain.ContactGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class PhoneContactAppGUI extends JFrame {
  private DefaultListModel<ContactAdapter> contactListModel;
  private JList<ContactAdapter> contactList;
  private JButton addButton;
  private JButton deleteButton;
  private JButton orderByNameButton;
  private JButton orderByNumberButton;
  private JButton createGroupButton;
  private JButton addContactToGroupButton;
  private List<ContactGroup> contactGroups;

  public PhoneContactAppGUI() {
    // Set up the frame
    setTitle("Phone Contact App");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900, 500);
    setLocationRelativeTo(null);

    // Create the contact list model and list
    contactListModel = new DefaultListModel<>();
    contactList = new JList<>(contactListModel);

    // Create the buttons
    addButton = new JButton("Add Contact");
    deleteButton = new JButton("Delete Contact");
    orderByNameButton = new JButton("Order by Name");
    orderByNumberButton = new JButton("Order by Number");
    createGroupButton = new JButton("Create Group");
    addContactToGroupButton = new JButton("Add Contact to Group");

    // Create the contact groups list
    contactGroups = new ArrayList<>();

    // Set dark theme colors
    Color backgroundColor = Color.DARK_GRAY;
    Color foregroundColor = Color.WHITE;
    Color buttonColor = Color.LIGHT_GRAY;

    // Set the background color for the frame and components
    getContentPane().setBackground(backgroundColor);
    contactList.setBackground(backgroundColor);
    addButton.setBackground(buttonColor);
    deleteButton.setBackground(buttonColor);
    orderByNameButton.setBackground(buttonColor);
    orderByNumberButton.setBackground(buttonColor);
    createGroupButton.setBackground(buttonColor);
    addContactToGroupButton.setBackground(buttonColor);

    // Set the foreground color for the components
    contactList.setForeground(foregroundColor);
    addButton.setForeground(foregroundColor);
    deleteButton.setForeground(foregroundColor);
    orderByNameButton.setForeground(foregroundColor);
    orderByNumberButton.setForeground(foregroundColor);
    createGroupButton.setForeground(foregroundColor);
    addContactToGroupButton.setForeground(foregroundColor);

    // Set the border for the buttons
    addButton.setBorder(new EmptyBorder(5, 10, 5, 10));
    deleteButton.setBorder(new EmptyBorder(5, 10, 5, 10));
    orderByNameButton.setBorder(new EmptyBorder(5, 10, 5, 10));
    orderByNumberButton.setBorder(new EmptyBorder(5, 10, 5, 10));
    createGroupButton.setBorder(new EmptyBorder(5, 10, 5, 10));
    addContactToGroupButton.setBorder(new EmptyBorder(5, 10, 5, 10));

    // Set up the layout
    setLayout(new BorderLayout());
    add(new JScrollPane(contactList), BorderLayout.CENTER);
    // Set up the layout
    setLayout(new BorderLayout());
    add(new JScrollPane(contactList), BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addButton);
    buttonPanel.add(deleteButton);
    buttonPanel.add(orderByNameButton);
    buttonPanel.add(orderByNumberButton);
    buttonPanel.add(createGroupButton);
    buttonPanel.add(addContactToGroupButton);
    add(buttonPanel, BorderLayout.SOUTH);

    // Add action listeners
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Open a dialog to add a new contact
        String name = JOptionPane.showInputDialog("Enter contact name:");
        String phoneNumber = JOptionPane.showInputDialog("Enter contact phone number:");
        String email = JOptionPane.showInputDialog("Enter contact email:");

        Contact contact = new Contact(name, phoneNumber, email);
        ContactAdapter contactAdapter = new ContactAdapterImpl(contact);
        contactListModel.addElement(contactAdapter);
      }
    });

    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Delete the selected contact
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
          contactListModel.remove(selectedIndex);
        }
      }
    });

    orderByNameButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Order the contact list by name
        ArrayList<ContactAdapter> contacts = Collections.list(contactListModel.elements());
        Collections.sort(contacts, new Comparator<ContactAdapter>() {
          @Override
          public int compare(ContactAdapter contact1, ContactAdapter contact2) {
            return contact1.getName().compareTo(contact2.getName());
          }
        });
        contactListModel.clear();
        for (ContactAdapter contact : contacts) {
          contactListModel.addElement(contact);
        }
      }
    });

    orderByNumberButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Order the contact list by phone number
        ArrayList<ContactAdapter> contacts = Collections.list(contactListModel.elements());
        Collections.sort(contacts, new Comparator<ContactAdapter>() {
          @Override
          public int compare(ContactAdapter contact1, ContactAdapter contact2) {
            return contact1.getPhoneNumber().compareTo(contact2.getPhoneNumber());
          }
        });
        contactListModel.clear();
        for (ContactAdapter contact : contacts) {
          contactListModel.addElement(contact);
        }
      }
    });
    createGroupButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Open a dialog to create a new group
        String groupName = JOptionPane.showInputDialog("Enter group name:");
        ContactGroup group = new ContactGroup(groupName);
        contactGroups.add(group);
      }
    });

    addContactToGroupButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Open a dialog to add a contact to a group
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
          ContactAdapter selectedContact = contactListModel.getElementAt(selectedIndex);
          JComboBox<ContactGroup> groupComboBox = new JComboBox<>(contactGroups.toArray(new ContactGroup[0]));
          int choice = JOptionPane.showConfirmDialog(null, groupComboBox, "Select a group", JOptionPane.OK_CANCEL_OPTION);
          if (choice == JOptionPane.OK_OPTION) {
            ContactGroup selectedGroup = (ContactGroup) groupComboBox.getSelectedItem();
            selectedGroup.addContact(selectedContact);
            selectedContact.setGroup(selectedGroup); // Set the group for the contact
            contactListModel.setElementAt(selectedContact, selectedIndex); // Update the list model
          }
        }
      }
    });
  }

  public void display() {
    // Show the GUI
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        PhoneContactAppGUI appGUI = new PhoneContactAppGUI();
        appGUI.display();
      }
    });
  }
}