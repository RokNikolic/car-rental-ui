package com.github.roknikolic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {
    Reservation reservation;

    @FXML
    private CheckBox InsuranceCheckBox;
    @FXML
    private Label PriceLabel;
    @FXML
    private Label DaysOfRentLabel;
    @FXML
    private ChoiceBox<String> PaymentMethodLabel;
    @FXML
    private TextField CreditCardLabel;
    @FXML
    private TextField CCVLabel;
    @FXML
    private Label ErrorLabel;
    private final String[] Methods = {"Cash", "Card"};

    public void checkboxChange() {
        if (InsuranceCheckBox.isSelected()) {
            displayTotalPrice(String.valueOf(reservation.totalPrice + 2 * reservation.totalDays));
            reservation.insurance = "True";
        } else {
            displayTotalPrice(String.valueOf(reservation.totalPrice));
            reservation.insurance = "False";
        }
    }

    public void displayTotalPrice(String TotalPrice) {
        PriceLabel.setText(TotalPrice);
        DaysOfRentLabel.setText(String.valueOf(reservation.totalDays));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        PaymentMethodLabel.getItems().addAll(Methods);
        PaymentMethodLabel.setOnAction(this::getPaymentMethod);
    }

    public void getPaymentMethod(ActionEvent event) {
        String PaymentMethod = PaymentMethodLabel.getValue();
        System.out.println(PaymentMethod);
        reservation.paymentMethod = PaymentMethod;
        if (Objects.equals(PaymentMethod, "Card")) {
            CreditCardLabel.setDisable(false);
            CCVLabel.setDisable(false);
        } else {
            CreditCardLabel.setDisable(true);
            CCVLabel.setDisable(true);
        }
    }

    public void getCreditCard() {
        reservation.cardNumber = CreditCardLabel.getText();
    }

    public void getCCV() {
        reservation.cardCCV = CCVLabel.getText();
    }

    private int checkForErrors() {
        if (reservation.insurance == null) {
            ErrorLabel.setText("Enter insurance!");
            return 0;
        } else if (reservation.paymentMethod == null) {
            ErrorLabel.setText("Enter payment method!");
            return 0;
        } else if (reservation.paymentMethod.equals("Card") && Objects.equals(reservation.cardNumber, "")) {
            ErrorLabel.setText("Enter time number!");
            return 0;
        } else if (reservation.paymentMethod.equals("Card") && !Objects.equals(reservation.cardNumber.length(), 16)) {
            ErrorLabel.setText("Card number must be 16 digits long!");
            return 0;
        } else if (reservation.paymentMethod.equals("Card") && Objects.equals(reservation.cardCCV, "")) {
            ErrorLabel.setText("Enter CCV!");
            return 0;
        } else if (reservation.paymentMethod.equals("Card") && !Objects.equals(reservation.cardCCV.length(), 3)) {
            ErrorLabel.setText("CCV must be 3 digits long!");
            return 0;
        } else {
            ErrorLabel.setText("");
            return 1;
        }
    }

    public void nextPage(ActionEvent event) throws IOException {
        getCreditCard();
        getCCV();

        if (checkForErrors() == 1) {
            reservation.totalPrice = Integer.parseInt(PriceLabel.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("final-scene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            FinalController controller = loader.getController();
            controller.reservation = this.reservation;
            controller.displayAll(this.reservation);
        }
    }

    public void previousPage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("personal-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        PersonalController controller  = loader.getController();
        controller.reservation = this.reservation;
    }

    public void firstPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing-scene.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
