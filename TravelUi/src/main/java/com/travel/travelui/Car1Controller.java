package com.travel.travelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class Car1Controller implements Initializable {
    @FXML
    private DatePicker DepartureDateLabel;
    public void get_departure_date() {
        LocalDate DepartureDate = DepartureDateLabel.getValue();
        String formattedDepartureDate = DepartureDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedDepartureDate);
    }
    @FXML
    private DatePicker ReturnDateLabel;
    public void get_return_date() {
        LocalDate ReturnDate = ReturnDateLabel.getValue();
        String formattedReturnDate = ReturnDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedReturnDate);
    }
    @FXML
    private ChoiceBox<String> DepartureTimeLabel;
    @FXML
    private ChoiceBox<String> ReturnTimeLabel;
    private final String[] Times = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    @FXML
    private ChoiceBox<String> DepartureCityLabel;
    @FXML
    private ChoiceBox<String> ReturnCityLabel;
    private final String[] Cities = {"Ljubljana", "Maribor", "Celje", "Kranj", "Velenje", "Koper", "Novo Mesto", "Murska Sobota", "Jesenice", "Portoroz", "letalisce Brnik", "letalisce Maribor"};
    @FXML
    private ChoiceBox<String> CarSizeLabel;
    private final String[] Sizes = {"Velika", "Srednja", "Majhna"};
    @FXML
    private ChoiceBox<String> CarGearboxLabel;
    private final String[] Gearboxes = {"Ročni", "Samodejen"};
    @FXML
    private ChoiceBox<String> CarEngineLabel;
    private final String[] Engines = {"Bencinski", "Dizel"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DepartureTimeLabel.getItems().addAll(Times);
        DepartureTimeLabel.setOnAction(this::get_depart_time);
        ReturnTimeLabel.getItems().addAll(Times);
        ReturnTimeLabel.setOnAction(this::get_return_time);
        DepartureCityLabel.getItems().addAll(Cities);
        DepartureCityLabel.setOnAction(this::get_depart_city);
        ReturnCityLabel.getItems().addAll(Cities);
        ReturnCityLabel.setOnAction(this::get_return_city);
        CarSizeLabel.getItems().addAll(Sizes);
        CarSizeLabel.setOnAction(this::get_car_size);
        CarGearboxLabel.getItems().addAll(Gearboxes);
        CarGearboxLabel.setOnAction(this::get_car_gearbox);
        CarEngineLabel.getItems().addAll(Engines);
        CarEngineLabel.setOnAction(this::get_car_engine);
    }
    public void get_depart_time(ActionEvent event) {
        String DepartTime = DepartureTimeLabel.getValue();
        System.out.println(DepartTime);
    }
    public void get_return_time(ActionEvent event) {
        String ReturnTime = ReturnTimeLabel.getValue();
        System.out.println(ReturnTime);
    }
    public void get_depart_city(ActionEvent event) {
        String DepartCity = DepartureCityLabel.getValue();
        System.out.println(DepartCity);
    }
    public void get_return_city(ActionEvent event) {
        String ReturnCity = ReturnCityLabel.getValue();
        System.out.println(ReturnCity);
    }
    public void get_car_size(ActionEvent event) {
        String CarSize = CarSizeLabel.getValue();
        System.out.println(CarSize);
    }
    public void get_car_gearbox(ActionEvent event) {
        String CarGearbox = CarGearboxLabel.getValue();
        System.out.println(CarGearbox);
    }
    public void get_car_engine(ActionEvent event) {
        String CarEngine = CarEngineLabel.getValue();
        System.out.println(CarEngine);
    }
    public void next_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("car2-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void first_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
