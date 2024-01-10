module com.travel.travelui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.travel.travelui to javafx.fxml;
    exports com.travel.travelui;
}