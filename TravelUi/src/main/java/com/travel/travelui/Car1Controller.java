package com.travel.travelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
    @FXML
    private Label ErrorLabel;
    private LocalDate DepartureDate;
    private LocalDate ReturnDate;
    private final String[] times = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    private final String[] cities = {"Ljubljana", "Maribor", "Celje", "Kranj", "Velenje", "Koper", "Novo Mesto", "Murska Sobota", "Jesenice", "Portoroz", "letalisce Brnik", "letalisce Maribor"};
    private final String[] sizes = {"Velik", "Srednji", "Majhen"};
    private final String[] gearboxes = {"Ročni", "Samodejen"};
    private final String[] engines = {"Bencinski", "Dizelski"};

    public void getDepartureDate() {
        DepartureDate = DepartureDateLabel.getValue();
        String formattedDepartureDate = DepartureDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedDepartureDate);
        reservation.departureDate = formattedDepartureDate;
        ErrorLabel.setText("");
    }

    public void getReturnDate() {
        ReturnDate = ReturnDateLabel.getValue();
        String formattedReturnDate = ReturnDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        System.out.println(formattedReturnDate);
        reservation.returnDate = formattedReturnDate;
        ErrorLabel.setText("");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        DepartureTimeLabel.getItems().addAll(times);
        DepartureTimeLabel.setOnAction(this::getDepartTime);
        ReturnTimeLabel.getItems().addAll(times);
        ReturnTimeLabel.setOnAction(this::getReturnTime);
        DepartureCityLabel.getItems().addAll(cities);
        DepartureCityLabel.setOnAction(this::getDepartCity);
        ReturnCityLabel.getItems().addAll(cities);
        ReturnCityLabel.setOnAction(this::getReturnCity);
        CarSizeLabel.getItems().addAll(sizes);
        CarSizeLabel.setOnAction(this::getCarSize);
        CarGearboxLabel.getItems().addAll(gearboxes);
        CarGearboxLabel.setOnAction(this::getCarGearbox);
        CarEngineLabel.getItems().addAll(engines);
        CarEngineLabel.setOnAction(this::getCarEngine);
    }

    public void getDepartTime(ActionEvent event) {
        String DepartTime = DepartureTimeLabel.getValue();
        System.out.println(DepartTime);
        reservation.departureTime = DepartTime;
        ErrorLabel.setText("");
    }

    public void getReturnTime(ActionEvent event) {
        String ReturnTime = ReturnTimeLabel.getValue();
        System.out.println(ReturnTime);
        reservation.returnTime = ReturnTime;
        ErrorLabel.setText("");
    }

    public void getDepartCity(ActionEvent event) {
        String DepartCity = DepartureCityLabel.getValue();
        System.out.println(DepartCity);
        reservation.departureLocation = DepartCity;
        ErrorLabel.setText("");
    }

    public void getReturnCity(ActionEvent event) {
        String ReturnCity = ReturnCityLabel.getValue();
        System.out.println(ReturnCity);
        reservation.returnLocation = ReturnCity;
        ErrorLabel.setText("");
    }

    public void getCarSize(ActionEvent event) {
        String CarSize = CarSizeLabel.getValue();
        System.out.println(CarSize);
        reservation.carSize = CarSize;
        ErrorLabel.setText("");
    }

    public void getCarGearbox(ActionEvent event) {
        String CarGearbox = CarGearboxLabel.getValue();
        System.out.println(CarGearbox);
        reservation.carGearbox = CarGearbox;
        ErrorLabel.setText("");
    }

    public void getCarEngine(ActionEvent event) {
        String CarEngine = CarEngineLabel.getValue();
        System.out.println(CarEngine);
        reservation.carEngine = CarEngine;
        ErrorLabel.setText("");
    }

    private int checkDates() {
        if (DepartureDate == null) {
            ErrorLabel.setText("Izpolni dan prevzema!");
            return 0;
        } else if (ReturnDate == null) {
            ErrorLabel.setText("Izpolni dan oddaje!");
            return 0;
        } else {
            ErrorLabel.setText("");
            return 1;
        }
    }

    private int checkForErrors() {
            if (reservation.departureTime == null) {
                ErrorLabel.setText("Izpolni čas prevzema!");
                return 0;
            } else if (reservation.departureLocation == null) {
                ErrorLabel.setText("Izpolni mesto prevzema!");
                return 0;
            } else if (reservation.returnTime == null) {
                ErrorLabel.setText("Izpolni čas oddaje!");
                return 0;
            } else if (reservation.returnLocation == null) {
                ErrorLabel.setText("Izpolni mesto oddaje!");
                return 0;
            } else if (reservation.carSize == null) {
                ErrorLabel.setText("Izpolni velikost avtomobila!");
                return 0;
            } else if (reservation.carGearbox == null) {
                ErrorLabel.setText("Izpolni menjalnik avtomobila!");
                return 0;
            } else if (reservation.carEngine == null) {
                ErrorLabel.setText("Izpolni motor avtomobila!");
                return 0;
            } else if (reservation.totalDays < 0) {
                ErrorLabel.setText("Datum oddaje nastavljen pred prevzemom");
                return 0;
            } else {
                ErrorLabel.setText("");
                return 1;
            }
    }

    public void nextPage(ActionEvent event) throws IOException {
        if (checkDates() == 1) {
            reservation.totalDays = Period.between(DepartureDate, ReturnDate).getDays();
            if (checkForErrors() == 1) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("car2-scene.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                Car2Controller controller = loader.getController();
                controller.reservation = this.reservation;
                controller.displaySize(reservation.carSize);
                controller.displayGearbox(reservation.carGearbox);
                controller.displayEngine(reservation.carEngine);
            }
        }
    }

    public void firstPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
