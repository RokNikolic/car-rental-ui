package com.travel.travelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FinalController {
    Reservation reservation;
    @FXML
    private Label DepartDayLabel;
    @FXML
    private Label DepartHourLabel;
    @FXML
    private Label DepartCityLabel;
    @FXML
    private Label ReturnDayLabel;
    @FXML
    private Label ReturnHourLabel;
    @FXML
    private Label ReturnCityLabel;
    @FXML
    private Label CarSizeLabel;
    @FXML
    private Label CarGearboxLabel;
    @FXML
    private Label CarEngineLabel;
    @FXML
    private Label CarNameLabel;
    @FXML
    private Label PersonNameLabel;
    @FXML
    private Label PersonSurnameLabel;
    @FXML
    private Label PersonAgeLabel;
    @FXML
    private Label LicenceAgeLabel;
    @FXML
    private Label PersonAddressLabel;
    @FXML
    private Label PersonEmailLabel;
    @FXML
    private Label PersonPhoneLabel;
    @FXML
    private Label InsuranceLabel;
    @FXML
    private Label FinalPriceLabel;
    @FXML
    private Label WayOfPayLabel;
    @FXML
    private Label CardLabel;
    @FXML
    private Label CCVLabel;

    public void displayAll(Reservation reservation_in) {
        DepartDayLabel.setText(reservation_in.departureDate);
        DepartHourLabel.setText(reservation_in.departureTime);
        DepartCityLabel.setText(reservation_in.departureLocation);
        ReturnDayLabel.setText(reservation_in.returnDate);
        ReturnHourLabel.setText(reservation_in.returnTime);
        ReturnCityLabel.setText(reservation_in.returnLocation);
        CarSizeLabel.setText(reservation_in.carSize);
        CarGearboxLabel.setText(reservation_in.carGearbox);
        CarEngineLabel.setText(reservation_in.carEngine);
        CarNameLabel.setText(reservation_in.carName);
        PersonNameLabel.setText(reservation_in.personalName);
        PersonSurnameLabel.setText(reservation_in.personalSurname);
        PersonAgeLabel.setText(reservation_in.personalAge);
        LicenceAgeLabel.setText(reservation_in.personalAgeOfLicence);
        PersonAddressLabel.setText(reservation_in.personalAddress);
        PersonEmailLabel.setText(reservation_in.personalEmail);
        PersonPhoneLabel.setText(reservation_in.personalPhone);
        InsuranceLabel.setText(reservation_in.insurance);
        InsuranceLabel.setText(String.valueOf(reservation_in.insurance));
        FinalPriceLabel.setText(String.valueOf(reservation_in.totalPrice));
        WayOfPayLabel.setText(reservation_in.paymentMethod);
        CardLabel.setText(reservation_in.cardNumber.replaceAll("[0-9]", "x"));
        CCVLabel.setText(reservation_in.cardCCV.replaceAll("[0-9]", "x"));
    }

    public void previous_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("payment-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        PaymentController controller  = loader.getController();
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
