package com.github.alvader01.Test;

import com.github.alvader01.Model.entity.User;
import com.github.alvader01.Utils.UserXMLManager;


import java.io.File;

public class TestUserXMLManager {
    public static void main(String[] args) {
        UserXMLManager userManager = new UserXMLManager();

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

        userManager.saveUser(user1);
        userManager.saveUser(user2);

        System.out.println("Usuario registrado:");
        for (User user : userManager.getUsers()) {
            System.out.println("Nombre de usuario: " + user.getUsername() +
                    ", nombre: " + user.getName() +
                    ", Email: " + user.getEmail());
        }

        File file = new File("users.xml");
        if (file.exists()) {
            System.out.println("El users.xml se creo correctamente");
        } else {
            System.out.println("El users.xml no existe");
        }
    }
}