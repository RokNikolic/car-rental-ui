package com.travel.travelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class Car2Controller implements Initializable {
    Reservation reservation;
    private final String[] SmallCars = {"Renault Clio", "Volkswagen Polo", "Honda Civic"};
    private final String[] MedCars = {"Toyota Avensis", "Audi A5", "Skoda Octavia", "Honda Accord"};
    private final String[] BigCars = {"Volkswagen Passat", "Seat Leon", "Mercedes Benz S Class"};

    private final Map<String, Integer> carPrices = new HashMap<>();

    @FXML
    private Label SizeLabel;
    @FXML
    private ChoiceBox<String> ChoseCarLabel;
    @FXML
    private Label GearboxLabel;
    @FXML
    private Label EngineLabel;
    @FXML
    private Label CarPriceLabel;
    public void displaySize(String CarSize) {
        SizeLabel.setText(CarSize);
        switch (CarSize) {
            case "Velik" -> ChoseCarLabel.getItems().addAll(BigCars);
            case "Srednji" -> ChoseCarLabel.getItems().addAll(MedCars);
            case "Majhen" -> ChoseCarLabel.getItems().addAll(SmallCars);
            case null, default -> System.out.println(CarSize);
        }
    }
    public void displayGearbox(String CarGearbox) {
        GearboxLabel.setText(CarGearbox);
    }
    public void displayEngine(String CarEngine) {
        EngineLabel.setText(CarEngine);
    }
    public void displayPrice(int CarPrice) {
        CarPriceLabel.setText(String.valueOf(CarPrice));
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        carPrices.put("Renault Clio", 100);
        carPrices.put("Volkswagen Polo", 110);
        carPrices.put("Honda Civic", 120);
        carPrices.put("Toyota Avensis", 150);
        carPrices.put("Audi A5", 160);
        carPrices.put("Skoda Octavia", 170);
        carPrices.put("Honda Accord", 180);
        carPrices.put("Volkswagen Passat", 200);
        carPrices.put("Seat Leon", 210);
        carPrices.put("Mercedes Benz S Class", 220);
        ChoseCarLabel.setOnAction(this::get_chosen_car);
    }
    public void get_chosen_car(ActionEvent event) {
        String ChosenCar = ChoseCarLabel.getValue();
        reservation.carName = ChosenCar;
        int priceOfCar = carPrices.get(ChosenCar);
        displayPrice(priceOfCar);
        System.out.println(priceOfCar);
        reservation.totalPrice = priceOfCar;
    }

    public void next_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("personal-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        PersonalController controller  = loader.getController();
        controller.reservation = this.reservation;
    }
    public void previous_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("car1-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Car1Controller controller  = loader.getController();
        controller.reservation = this.reservation;
    }
    public void first_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
