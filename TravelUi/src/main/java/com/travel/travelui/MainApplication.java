package com.travel.travelui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Car car1 = new Car("Renault Clio", "Majhen", 50);
    Car car2 = new Car("Volkswagen Polo", "Majhen", 50);
    Car car3 = new Car("Honda Civic", "Majhen", 50);
    Car car4 = new Car("Toyota Avensis", "Sreden", 100);
    Car car5 = new Car("Audi A5", "Sreden", 100);
    Car car6 = new Car("Skoda Octavia", "Sreden", 100);
    Car car7 = new Car("Honda Accord", "Sreden", 100);
    Car car8 = new Car("Volkswagen Passat", "Velik", 150);
    Car car9 = new Car("Seat Leon", "Velik", 150);
    Car car10 = new Car("Mercedes-Benz S-Class", "Velik", 150);

    Car[] cars = new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("landing-scene.fxml"));
        Scene landing_scene = new Scene(fxmlLoader.load());
        stage.setScene(landing_scene);

        Image icon = new Image(String.valueOf(MainApplication.class.getResource("car.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Avtek");
        stage.show();
    }

}