package com.github.alvader01;


import com.github.alvader01.view.AppController;
import com.github.alvader01.view.Scenes;
import com.github.alvader01.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static Stage stage;
    public static AppController currentController;

    @Override
    public void start(Stage stage) throws Exception {
        View view = AppController.loadFXML(Scenes.LAYOUT);
        scene = new Scene(view.scene, 764, 486);
        currentController = (AppController) view.controller;
        currentController.onOpen(null);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        //  scene.setRoot(loadFXML(fxml));
    }


    public static void main(String[] args) {
        launch();
    }

}

