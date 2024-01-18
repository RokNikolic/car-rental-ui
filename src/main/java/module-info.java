module com.rok.rentalui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.rok.rentalui to javafx.fxml;
    exports com.rok.rentalui;
}