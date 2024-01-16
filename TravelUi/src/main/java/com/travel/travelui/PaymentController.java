package com.travel.travelui;

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

    public void checkbox_change() {
        if (InsuranceCheckBox.isSelected()) {
            displayTotalPrice(String.valueOf(reservation.totalPrice + 2 * reservation.totalDays));
            reservation.insurance = "True";
        } else {
            displayTotalPrice(String.valueOf(reservation.totalPrice));
            reservation.insurance = "False";
        }
    }

    @FXML
    private Label PriceLabel;
    @FXML
    private Label DaysOfRentLabel;
    public void displayTotalPrice(String TotalPrice) {
        PriceLabel.setText(TotalPrice);
        DaysOfRentLabel.setText(String.valueOf(reservation.totalDays));
    }
    @FXML
    private ChoiceBox<String> PaymentMethodLabel;
    private final String[] Methods = {"Gotovina", "Kartica"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        PaymentMethodLabel.getItems().addAll(Methods);
        PaymentMethodLabel.setOnAction(this::get_payment_method);
    }
    @FXML
    private TextField CreditCardLabel;
    @FXML
    private TextField CCVLabel;
    public void get_payment_method(ActionEvent event) {
        String PaymentMethod = PaymentMethodLabel.getValue();
        System.out.println(PaymentMethod);
        reservation.paymentMethod = PaymentMethod;
        if (Objects.equals(PaymentMethod, "Kartica")) {
            CreditCardLabel.setDisable(false);
            CCVLabel.setDisable(false);
        } else {
            CreditCardLabel.setDisable(true);
            CCVLabel.setDisable(true);
        }
    }
    public void get_credit_card() {
        reservation.cardNumber = CreditCardLabel.getText();
    }
    public void get_CCV() {
        reservation.cardCCV = CCVLabel.getText();
    }
    public void next_page(ActionEvent event) throws IOException {
        get_credit_card();
        get_CCV();
        reservation.totalPrice = Integer.parseInt(PriceLabel.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("final-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        FinalController controller  = loader.getController();
        controller.reservation = this.reservation;
        controller.displayAll(this.reservation);
    }
    public void previous_page(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("personal-scene.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        PersonalController controller  = loader.getController();
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
