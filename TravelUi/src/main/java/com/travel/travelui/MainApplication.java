package com.travel.travelui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // First scene
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("first-scene.fxml"));
        Scene first_scene = new Scene(fxmlLoader.load());
        stage.setScene(first_scene);

        // Test scene
        Group root = new Group();
        Scene testing_scene = new Scene(root);
        //stage.setScene(testing_scene);

        // Constants
        Image icon = new Image(String.valueOf(MainApplication.class.getResource("palm.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Flights into the unknown");
        stage.setMaximized(true);
        stage.show();
    }

}