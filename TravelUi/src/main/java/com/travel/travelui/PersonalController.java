package com.travel.travelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PersonalController {
    Reservation reservation;

    @FXML
    private TextField PersonNameLabel;
    public void get_person_name() {
        String PersonName = PersonNameLabel.getText();
        System.out.println(PersonName);
        reservation.personalName = PersonName;
    }
    @FXML
    private TextField SurnameLabel;
    public void get_person_surname() {
        String PersonSurname = SurnameLabel.getText();
        System.out.println(PersonSurname);
        reservation.personalSurname = PersonSurname;
    }
    @FXML
    private TextField AddressLabel;
    public void get_person_address() {
        String PersonAddress = AddressLabel.getText();
        System.out.println(PersonAddress);
        reservation.personalAddress = PersonAddress;
    }
    @FXML
    private TextField EmailLabel;
    public void get_person_email() {
        String PersonEmail = EmailLabel.getText();
        System.out.println(PersonEmail);
        reservation.personalEmail = PersonEmail;
    }
    @FXML
    private TextField PhoneLabel;
    public void get_person_phone() {
        String PersonPhone = PhoneLabel.getText();
        System.out.println(PersonPhone);
        reservation.personalPhone = PersonPhone;
    }
    @FXML
    private TextField AgeLabel;
    public void get_person_age() {
        String PersonAge = AgeLabel.getText();
        System.out.println(PersonAge);
        reservation.personalAge = PersonAge;
    }
    @FXML
    private TextField LicenceAgeLabel;
    public void get_person_licence_age() {
        String PersonLicenceAge = LicenceAgeLabel.getText();
        System.out.println(PersonLicenceAge);
        reservation.personalAgeOfLicence = PersonLicenceAge;
    }
    public void next_page(ActionEvent event) throws IOException {
        get_person_name();
        get_person_surname();
        get_person_address();
        get_person_email();
        get_person_phone();
        get_person_age();
        get_person_licence_age();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("payment-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        PaymentController controller  = loader.getController();
        controller.reservation = this.reservation;
        controller.displayTotalPrice(String.valueOf(reservation.totalPrice));
    }
    public void previous_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("car2-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Car2Controller controller  = loader.getController();
        this.reservation.insurance = "False";
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
