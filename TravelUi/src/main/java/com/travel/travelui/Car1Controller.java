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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class Car1Controller implements Initializable {
    Reservation reservation;
    @FXML
    private DatePicker DepartureDateLabel;
    @FXML
    private DatePicker ReturnDateLabel;
    @FXML
    private ChoiceBox<String> DepartureTimeLabel;
    @FXML
    private ChoiceBox<String> ReturnTimeLabel;
    @FXML
    private ChoiceBox<String> DepartureCityLabel;
    @FXML
    private ChoiceBox<String> ReturnCityLabel;
    @FXML
    private ChoiceBox<String> CarSizeLabel;
    @FXML
    private ChoiceBox<String> CarGearboxLabel;
    @FXML
    private ChoiceBox<String> CarEngineLabel;
    private LocalDate DepartureDate;
    private LocalDate ReturnDate;
    public void get_departure_date() {
        DepartureDate = DepartureDateLabel.getValue();
        String formattedDepartureDate = DepartureDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedDepartureDate);
        reservation.departureDate = formattedDepartureDate;
    }
    public void get_return_date() {
        ReturnDate = ReturnDateLabel.getValue();
        String formattedReturnDate = ReturnDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedReturnDate);
        reservation.returnDate = formattedReturnDate;
    }
    private final String[] Times = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private final String[] Cities = {"Ljubljana", "Maribor", "Celje", "Kranj", "Velenje", "Koper", "Novo Mesto", "Murska Sobota", "Jesenice", "Portoroz", "letalisce Brnik", "letalisce Maribor"};
    private final String[] Sizes = {"Velik", "Srednji", "Majhen"};
    private final String[] Gearboxes = {"Ročni", "Samodejen"};
    private final String[] Engines = {"Bencinski", "Dizelski"};

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
        reservation.departureTime = DepartTime;
    }
    public void get_return_time(ActionEvent event) {
        String ReturnTime = ReturnTimeLabel.getValue();
        System.out.println(ReturnTime);
        reservation.returnTime = ReturnTime;
    }
    public void get_depart_city(ActionEvent event) {
        String DepartCity = DepartureCityLabel.getValue();
        System.out.println(DepartCity);
        reservation.departureLocation = DepartCity;
    }
    public void get_return_city(ActionEvent event) {
        String ReturnCity = ReturnCityLabel.getValue();
        System.out.println(ReturnCity);
        reservation.returnLocation = ReturnCity;
    }
    public void get_car_size(ActionEvent event) {
        String CarSize = CarSizeLabel.getValue();
        System.out.println(CarSize);
        reservation.carSize = CarSize;
    }
    public void get_car_gearbox(ActionEvent event) {
        String CarGearbox = CarGearboxLabel.getValue();
        System.out.println(CarGearbox);
        reservation.carGearbox = CarGearbox;
    }
    public void get_car_engine(ActionEvent event) {
        String CarEngine = CarEngineLabel.getValue();
        System.out.println(CarEngine);
        reservation.carEngine = CarEngine;
    }
    public void next_page(ActionEvent event) throws IOException {
        reservation.totalDays = Period.between(DepartureDate, ReturnDate).getDays();
        System.out.println(reservation.totalDays);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("car2-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Car2Controller controller  = loader.getController();
        controller.reservation = this.reservation;
        controller.displaySize(reservation.carSize);
        controller.displayGearbox(reservation.carGearbox);
        controller.displayEngine(reservation.carEngine);
    }
    public void first_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
