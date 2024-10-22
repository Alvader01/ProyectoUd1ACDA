package com.github.alvader01.Utils;

import com.github.alvader01.Model.entity.Contact;
import com.github.alvader01.Model.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserXMLManager {
    private static File userFile = new File("users.xml");

    public static void addUser(User user) throws Exception {
        List<User> users = getUsers();
        users.add(user);
        saveUsers(users);
    }

    public static List<User> getUsers() throws Exception {
        if (userFile.exists() && userFile.length() > 0) {
            JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UserListWrapper wrapper = (UserListWrapper) unmarshaller.unmarshal(userFile);
            return wrapper.getUsers();
        } else {
            createInitialXML();
            return new ArrayList<>();
        }
    }

    public static List<Contact> getContactsByUsername(String username) throws Exception {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getContacts() != null ? user.getContacts() : new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }

    public static void addContactToUser(String username, Contact contact) throws Exception {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getContacts() == null) {
                    user.setContacts(new ArrayList<>());
                }
                user.getContacts().add(contact);
                saveUsers(users);
                return;
            }
        }
    }

    public static void saveUsers(List<User> users) throws Exception {
        UserListWrapper wrapper = new UserListWrapper();
        wrapper.setUsers(users);
        JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(wrapper, userFile);
    }

    private static void createInitialXML() throws Exception {
        if (!userFile.exists()) {
            userFile.createNewFile();
        }
        UserListWrapper wrapper = new UserListWrapper();
        wrapper.setUsers(new ArrayList<>());
        JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(wrapper, userFile);
    }
}
