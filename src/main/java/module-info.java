module com.example.etrojfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.etrojfx to javafx.fxml;
    exports com.example.etrojfx;
    exports  com.example.etrojfx.Models;
    opens com.example.etrojfx.Models to javafx.fxml;
}