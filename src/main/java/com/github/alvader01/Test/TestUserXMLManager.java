package com.github.alvader01.Test;

import com.github.alvader01.Model.entity.Contact;
import com.github.alvader01.Model.entity.User;
import com.github.alvader01.Utils.UserXMLManager;


import java.io.File;
import java.util.List;

public class TestUserXMLManager {
    public static void main(String[] args) {
        try {
            User user1 = new User();
            user1.setUsername("Alvader");
            user1.setName("Alvaro");
            user1.setPassword("Alvader01");
            user1.setEmail("alvader01@gmail.com");

            User user2 = new User();
            user2.setUsername("Tejederas");
            user2.setName("Alfonso");
            user2.setPassword("Tejederas");
            user2.setEmail("tejederas@gmail.com");

            User user3 = new User();
            user3.setUsername("Carlillos6");
            user3.setName("Carlos");
            user3.setPassword("Carlillos6");
            user3.setEmail("Carlillos6@gmail.com");

            UserXMLManager.addUser(user1);
            UserXMLManager.addUser(user2);
            UserXMLManager.addUser(user3);


            Contact contactForUser1 = new Contact();
            contactForUser1.setUsername("Tejederas");
            UserXMLManager.addContactToUser("Alvader", contactForUser1);

            System.out.println("Registered Users:");
            List<User> users = UserXMLManager.getUsers();
            for (User user : users) {
                System.out.println("Username: " + user.getUsername() +
                        ", Name: " + user.getName() +
                        ", Email: " + user.getEmail() +
                        ", Contacts: " + user.getContacts());
            }

            List<Contact> alvaderContacts = UserXMLManager.getContactsByUsername("Alvader");
            System.out.println("Contacts for Alvader:");
            for (Contact contact : alvaderContacts) {
                System.out.println("Contact Username: " + contact.getUsername());
            }

            File file = new File("users.xml");
            if (file.exists()) {
                System.out.println("\nThe users.xml file has been created successfully.");
            } else {
                System.out.println("\nThe users.xml file does not exist.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}