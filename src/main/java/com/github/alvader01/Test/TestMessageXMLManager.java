package com.github.alvader01.Test;

import com.github.alvader01.Model.entity.Message;
import com.github.alvader01.Model.entity.User;
import com.github.alvader01.Model.XML.MessageXMLManager;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMessageXMLManager {
    public static void main(String[] args) {
        try {
            // Limpiar el archivo de mensajes antes de la prueba
            clearMessagesFile();

            // Crear usuarios
            User alvader = new User();
            alvader.setUsername("Alvader");
            alvader.setContacts(new ArrayList<>());

            User tejederas = new User();
            tejederas.setUsername("Tejederas");
            tejederas.setContacts(new ArrayList<>());

            User carlos = new User();
            carlos.setUsername("Carlos");
            carlos.setContacts(new ArrayList<>());

            // Enviar mensajes
            Message mensaje1 = new Message("Alvader", "Tejederas", "Hola Tejederas, ¿cómo estás?", "2024-10-22 10:00");
            Message mensaje2 = new Message("Tejederas", "Alvader", "Hola Alvader, estoy bien, gracias.", "2024-10-22 10:05");
            Message mensaje3 = new Message("Alvader", "Carlos", "Hola Carlos, ¿te unes a la conversación?", "2024-10-22 10:10");

            // Agregar mensajes al XML
            MessageXMLManager.addMessage(mensaje1);
            MessageXMLManager.addMessage(mensaje2);
            MessageXMLManager.addMessage(mensaje3);

            // Verificar mensajes visibles para Alvader
            System.out.println("Mensajes de Alvader:");
            printMessagesForUser("Alvader");

            // Verificar mensajes visibles para Tejederas
            System.out.println("\nMensajes de Tejederas:");
            printMessagesForUser("Tejederas");

            // Verificar mensajes visibles para Carlos (no debería ver mensajes entre Alvader y Tejederas)
            System.out.println("\nMensajes de Carlos (no debería ver mensajes):");
            printMessagesForUser("Carlos");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printMessagesForUser(String username) throws JAXBException {
        List<Message> mensajes = MessageXMLManager.recoverMessages();
        for (Message msg : mensajes) {
            if (msg.getSender().equals(username) || msg.getRecipient().equals(username)) {
                System.out.println(msg.getTimestamp() + " [" + msg.getSender() + " -> " + msg.getRecipient() + "]: " + msg.getContent());
            }
        }
    }

    private static void clearMessagesFile() {
        File file = new File("messages.xml");
        if (file.exists()) {
            file.delete(); // Eliminar el archivo si existe para pruebas limpias
        }
    }
}