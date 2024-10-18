package com.github.alvader01.Utils;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.util.ArrayList;
import java.util.List;
import com.github.alvader01.Model.entity.User;

public class UserXMLManager {
    private List<User> users = new ArrayList<>();

    public void saveUser(User user) {
        users.add(user);
        saveUsersToFile("users.xml");
    }

    public void saveUsersToFile(String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            UserListWrapper wrapper = new UserListWrapper();
            wrapper.setUsers(users);

            marshaller.marshal(wrapper, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        loadUsersFromFile("users.xml");
        return users;
    }

    public void loadUsersFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("El archivo no existe.");
                return;
            }

            JAXBContext context = JAXBContext.newInstance(UserListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UserListWrapper wrapper = (UserListWrapper) unmarshaller.unmarshal(file);
            users = wrapper.getUsers();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
