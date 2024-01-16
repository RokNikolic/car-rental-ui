package com.travel.travelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PersonalController {
    Reservation reservation;

    @FXML
    private TextField PersonNameLabel;
    @FXML
    private TextField SurnameLabel;
    @FXML
    private TextField AddressLabel;
    @FXML
    private TextField EmailLabel;
    @FXML
    private TextField PhoneLabel;
    @FXML
    private TextField AgeLabel;
    @FXML
    private TextField LicenceAgeLabel;
    @FXML
    private Label ErrorLabel;

    public void getPersonName() {
        String PersonName = PersonNameLabel.getText();
        System.out.println(PersonName);
        reservation.personalName = PersonName;
        ErrorLabel.setText("");
    }

    public void getPersonSurname() {
        String PersonSurname = SurnameLabel.getText();
        System.out.println(PersonSurname);
        reservation.personalSurname = PersonSurname;
        ErrorLabel.setText("");
    }

    public void getPersonAddress() {
        String PersonAddress = AddressLabel.getText();
        System.out.println(PersonAddress);
        reservation.personalAddress = PersonAddress;
        ErrorLabel.setText("");
    }

    public void getPersonEmail() {
        String PersonEmail = EmailLabel.getText();
        System.out.println(PersonEmail);
        reservation.personalEmail = PersonEmail;
        ErrorLabel.setText("");
    }

    public void getPersonPhone() {
        String PersonPhone = PhoneLabel.getText();
        System.out.println(PersonPhone);
        reservation.personalPhone = PersonPhone;
        ErrorLabel.setText("");
    }

    public void getPersonAge() {
        String PersonAge = AgeLabel.getText();
        System.out.println(PersonAge);
        reservation.personalAge = PersonAge;
        ErrorLabel.setText("");
    }

    public void getPersonLicenceAge() {
        String PersonLicenceAge = LicenceAgeLabel.getText();
        System.out.println(PersonLicenceAge);
        reservation.personalAgeOfLicence = PersonLicenceAge;
        ErrorLabel.setText("");
    }

    private int checkForErrors() {
        if (Objects.equals(reservation.personalName, "")) {
            ErrorLabel.setText("Izpolni ime osebe!");
            return 0;
        } else if (reservation.personalName.matches("[0-9]+")) {
            ErrorLabel.setText("Ime ne sme vsebovati števil ali simbolov");
            return 0;
        } else if (Objects.equals(reservation.personalSurname, "")) {
            ErrorLabel.setText("Izpolni priimek osebe!");
            return 0;
        } else if (reservation.personalSurname.matches("[0-9]+")) {
            ErrorLabel.setText("Priimek ne sme vsebovati števil ali simbolov");
            return 0;
        } else if (Objects.equals(reservation.personalAddress, "")) {
            ErrorLabel.setText("Izpolni naslov osebe!");
            return 0;
        } else if (Objects.equals(reservation.personalEmail, "")) {
            ErrorLabel.setText("Izpolni email osebe!");
            return 0;
        } else if (Objects.equals(reservation.personalPhone, "")) {
            ErrorLabel.setText("Izpolni telefon osebe!");
            return 0;
        } else if (reservation.personalPhone.matches("[a-zA-Z]+")) {
            ErrorLabel.setText("Telefonska številka ne sme vsebovati črk");
            return 0;
        } else if (Objects.equals(reservation.personalAge, "")) {
            ErrorLabel.setText("Izpolni starost osebe!");
            return 0;
        }else if (reservation.personalAge.matches("[a-zA-Z]+")) {
            ErrorLabel.setText("Starost osebe ne sme vsebovati črk");
            return 0;
        } else if (Objects.equals(reservation.personalAgeOfLicence, "")) {
            ErrorLabel.setText("Izpolni leta od pridobitve vozniškega izpita!");
            return 0;
        } else if (reservation.personalAgeOfLicence.matches("[a-zA-Z]+")) {
            ErrorLabel.setText("Leta ne smejo vsebovati črk");
            return 0;
        } else {
            ErrorLabel.setText("");
            return 1;
        }
    }

    public void nextPage(ActionEvent event) throws IOException {
        getPersonName();
        getPersonSurname();
        getPersonAddress();
        getPersonEmail();
        getPersonPhone();
        getPersonAge();
        getPersonLicenceAge();

        if (checkForErrors() == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("payment-scene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            PaymentController controller = loader.getController();
            controller.reservation = this.reservation;
            controller.displayTotalPrice(String.valueOf(reservation.totalPrice));
            controller.reservation.insurance = "False";
        }
    }

    public void previousPage(ActionEvent event) throws IOException {
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

    public void firstPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
