package com.decroly.apppersonasfx;

import com.decroly.apppersonasfx.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Clase Controladora.
 * Gestiona la comunicación entre la vista (FXML) y los datos (Modelo).
 */
public class PersonasController {

    // Atributo para manejar una persona individualmente
    private Persona pp;

    /**
     * ObservableList: Es una lista especial de JavaFX.
     * Si añades o borras una persona de aquí, la tabla de la pantalla
     * se actualizará automáticamente sin tener que refrescar nada.
     */
    private ObservableList<Persona> personas = FXCollections.observableArrayList();

    /**
     * @FXML: Esta etiqueta indica que el objeto 'welcomeText' está
     * definido en el archivo FXML (el diseño de Scene Builder).
     */
    @FXML
    private Label welcomeText;

    /**
     * Metodo que se ejecuta cuando el usuario hace clic en el botón "Hello".
     * El nombre debe coincidir con el campo "On Action" en Scene Builder.
     */
    @FXML
    protected void onHelloButtonClick() {
        // Cambia el texto de la etiqueta en la ventana
        welcomeText.setText("Bienvenido a JavaFX !");
    }
}