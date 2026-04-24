package com.decroly.apppersonasfx;

import com.decroly.apppersonasfx.model.Persona;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase Controladora.
 * Gestiona la comunicación entre la vista (FXML) y los datos (Modelo).
 */
public class PersonasController implements Initializable {

    // Atributo para manejar una persona individualmente
    private Persona pp;

    /**
     * ObservableList: Es una lista especial de JavaFX. (Parecido a un arraylist)
     * Si añades o borras una persona de aquí, la tabla de la pantalla se actualizará automáticamente sin tener que refrescar nada.*/

    private ObservableList<Persona> personas = FXCollections.observableArrayList();

    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane formView;

    //CAMPOS DE TESTO DEL FORMULARIO
    @FXML
    private TextField dniTextF;
    @FXML
    private TextField nombreTextF;
    @FXML
    private TextField apellidoTextF;
    @FXML
    private TextField emailTextF;
    @FXML
    private TextField edadTextF;
    @FXML
    private TextField telefonoTextF;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Codigo que queremos o necesitamos que se ejecute al principio
        this.mainView.setVisible(true);
        this.formView.setVisible(false);
        this.clearFieldTexts();
    }

    @FXML
    public void onInsertButtonClick(ActionEvent event) {
        this.mainView.setVisible(false);
        this.formView.setVisible(true);
    }

    @FXML
    public void onListadoButtonClick(ActionEvent event) {
    }
    @FXML
    public void onBuscarButtonClick(ActionEvent event) {
    }
    @FXML
    public void onGuardarFormClick(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    public void onSalirButtonOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void onCancelFormClick(ActionEvent event) {
        this.formView.setVisible(false);
        this.mainView.setVisible(true);
        this.clearFieldTexts();
    }


    private void clearFieldTexts() {
        this.dniTextF.setText("");
        this.nombreTextF.setText("");
        this.apellidoTextF.setText("");
        this.emailTextF.setText("");
        this.edadTextF.setText("");
        this.telefonoTextF.setText("");
    }

}