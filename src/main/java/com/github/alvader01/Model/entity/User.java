package com.github.alvader01.Model.entity;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
    private String username;
    private String name;
    private String password;
    private String email;

    public User() {
        // Constructor por defecto
    }

    public String getUsername() {
        return username;
    }

    @XmlElement
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }
}
