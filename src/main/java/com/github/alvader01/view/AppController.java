package com.github.alvader01.view;
import com.github.alvader01.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController extends Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    private Controller centerController;

    @FXML
    static Alert alert= new Alert(Alert.AlertType.ERROR);

    @FXML
    static Alert alert2= new Alert(Alert.AlertType.CONFIRMATION);

    @FXML
    static Alert alertInfoRegister= new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void onOpen(Object input) throws IOException {
        changeScene(Scenes.LOGIN,null);
    }

    public void changeScene(Scenes scene,Object data) throws IOException {
        View view = loadFXML(scene);
        borderPane.setCenter(view.scene);
        this.centerController = view.controller;
        this.centerController.onOpen(data);
    }

    public void openModal(Scenes scene, String title,Controller parent, Object data) throws IOException {
        View view = loadFXML(scene);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(App.stage);
        Scene _scene = new Scene(view.scene);
        stage.setScene(_scene);
        view.controller.onOpen(parent);
        stage.showAndWait();

    }


    @Override
    public void onClose(Object output) {
        //nothing to do
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static View loadFXML(Scenes scenes) throws IOException {
        String url = scenes.getURL();
        FXMLLoader loader = new FXMLLoader(App.class.getResource(url));
        Parent p = loader.load();
        Controller c = loader.getController();
        View view = new View();
        view.scene=p;
        view.controller=c;
        return view;
    }

    public static void ShowAlertsErrorLogin(){
        alert.setTitle("Error");
        alert.setContentText("Usuario o contraseña incorrectos");
        alert.showAndWait();
    }
    public static void ShowAlertsErrorLoginPassword(){
        alert.setTitle("Error");
        alert.setContentText("La contraseña es incorrecta");
        alert.showAndWait();
    }
    public static void ShowAlertsInvalidEmail(){
        alert.setTitle("Error");
        alert.setContentText("El email tiene que ser valido, por ejemplo: 1rT8j@example.com");
        alert.showAndWait();
    }
    public static void ShowAlertsErrorRegister(){
        alert.setTitle("Error");
        alert.setContentText("No se pudo registrar el usuario");
        alert.showAndWait();
    }
    public static void ShowAlertsErrorLogin2(){
        alert.setTitle("Error");
        alert.setContentText("Necesitas introducir los campos de usuario y contraseña");
        alert.showAndWait();

    }
    public static void ShowAlertsSuccessfullyRegister(){
        alert2.setTitle("Exito");
        alert2.setContentText("Usuario registrado con exito");
        alert2.showAndWait();
    }


    public static void ShowAlertsUserAlreadyExists(){
        alert.setTitle("Error");
        alert.setContentText("El usuario ya existe");
        alert.showAndWait();
    }
    public static void  ShowInformation(){
        alertInfoRegister.setTitle("Informacion");
        alertInfoRegister.setHeaderText(null);
        alertInfoRegister.setContentText("No puedes crear usuarios con el mismo nombre de usuario");
        alertInfoRegister.showAndWait();

    }

    @FXML
    private void closeApp(){
        System.exit(0);
    }


}

