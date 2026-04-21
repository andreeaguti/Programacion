module PrimeraPracticaJFX {
    requires javafx.controls;
    requires javafx.fxml;

    // Debes usar el nombre exacto de tu paquete
    opens com.primerJFX to javafx.fxml;
    exports com.primerJFX;
}