package com.github.alvader01.view;
import com.github.alvader01.App;
import com.github.alvader01.Model.entity.Contact;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class MainPageController extends Controller implements Initializable {


    @FXML
    Text username;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox contactos;
    @FXML
    Button buttonNewContact;
    @FXML
    TextField usernameField;
    @FXML
    ListView<Contact> contactListView;
    @FXML
    TextField messageTextField;
    @FXML
    Button buttonSend;
    @FXML
    ImageView download;
    @FXML
    ImageView back;



    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void changeSceneToLoginPage() throws IOException {
        App.currentController.changeScene(Scenes.LOGIN, null);
    }
}