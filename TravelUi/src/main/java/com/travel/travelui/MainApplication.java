package com.travel.travelui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("landing-scene.fxml"));
        Scene landing_scene = new Scene(fxmlLoader.load());
        stage.setScene(landing_scene);

        Image icon = new Image(String.valueOf(MainApplication.class.getResource("palm.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Polet v neznano");
        stage.show();
    }

}