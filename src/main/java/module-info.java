module com.rok.rentalui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.github.roknikolic to javafx.fxml;
    exports com.github.roknikolic;
}