package com.github.alvader01.Model.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;


@XmlRootElement(name = "contact")
public class Contact {
    private String email;
    private String name;
    private String username;

    // Constructor vacío
    public Contact() {
    }

    public Contact(String email, String name, String username) {
        this.email = email;
        this.name = name;
        this.username = username;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}


