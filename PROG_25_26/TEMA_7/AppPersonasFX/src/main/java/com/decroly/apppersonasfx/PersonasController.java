package com.decroly.apppersonasfx;

import com.decroly.apppersonasfx.model.Persona;
import com.decroly.apppersonasfx.model.SQLAccessPersona;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.security.PrivateKey;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label; // Debe ser este

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

    private String [] estadosLabel= {"Se ha creado el registro correctamente",
            "Error al crear el registro",
            "Se ha producido una excepción",};


    @FXML
    private AnchorPane mainView;

    @FXML
    private AnchorPane formView;

    @FXML
    private AnchorPane listView;

    @FXML
    private Label infoLabel;

    private Button guardarFormButton;

    private ListView<Persona> personasListView;

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
        this.selectPanelVisible(0);

        //Insertar listerners a las propiedades de focus tesxtfields
        this.dniTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!this.validateDni(dniTextF.getText())){
                    this.dniTextF.setText("");
                    this.dniTextF.setPromptText("Debe ingresar un dni correcto");
                }
            }
        });

        this.nombreTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!this.validateName(nombreTextF.getText())){
                    this.nombreTextF.setText("");
                    this.nombreTextF.setPromptText("El nombre debe de tener al menos 3 caracteres");
                }
            }
        });

        this.apellidoTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!this.validateName(apellidoTextF.getText())){
                    this.apellidoTextF.setText("");
                    this.apellidoTextF.setPromptText("El apellido debe de tener al menos 3 caracteres");

                }
            }
        });

        this.emailTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!this.validateEmail(emailTextF.getText())){
                    this.emailTextF.setText("");
                    this.emailTextF.setPromptText("Ingresa un email valido");
                }
            }
        });

        this.edadTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!this.validateAge(edadTextF.getText())){
                    this.edadTextF.setText("");

                    this.edadTextF.getStyleClass().add("my-error-text");
                    this.edadTextF.setPromptText("La edad debe ser un numero entre 1 y 150");
                }
            }
        });

        this.telefonoTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue){
                if(!this.validatePhone(telefonoTextF.getText())){
                    this.telefonoTextF.setText("");
                    this.telefonoTextF.setPromptText("El telefono debe tener 9 digitos");
                }
            }
        });

        //Para hacer un filtro de busqueda rapido
        this.nombreTextF.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Persona> personas = SQLAccessPersona.
                    getpersonasByNameContains(this.nombreTextF.getText());

            //Pintamos el numero de elementos que encontramos
            this.infoLabel.setText(personas.size() + " personas encontrados");
            //Lo comento para que no sea vea, ya que es una prueba.
            //this.infoLabel.setVisible(true);
        });


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
        //Guardar en el formulario, insertar en el SQL
        try {
            this.pp = Persona.builder()
                    .dni(this.dniTextF.getText())
                    .name(this.nombreTextF.getText())
                    .surname(this.apellidoTextF.getText())
                    .email(this.emailTextF.getText())
                    .age(Integer.parseInt(this.edadTextF.getText()))
                    .phone(this.telefonoTextF.getText())
                    .build();

            if (SQLAccessPersona.createPersona(pp)) {
                this.clearFieldTexts();
                this.infoLabel.setText(this.estadosLabel[0]);
                this.infoLabel.setVisible(true);
            } else {
                this.infoLabel.setText(this.estadosLabel[1]);
                this.infoLabel.setVisible(true);
            }
        }catch(NumberFormatException e){
            this.edadTextF.setText("");
            this.edadTextF.setPromptText("Escriba un numero");

        }catch(Exception e){
            this.infoLabel.setText(this.estadosLabel[2]);
            this.infoLabel.setVisible(true);
        }
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
        this.dniTextF.clear();
        this.nombreTextF.clear();
        this.apellidoTextF.clear();
        this.emailTextF.clear();
        this.telefonoTextF.clear();
        this.edadTextF.clear();

        this.dniTextF.setPromptText("12345678Z");
        this.nombreTextF.setPromptText("Pedro");
        this.apellidoTextF.setPromptText("Picapiedra Marmol");
        this.emailTextF.setPromptText("ppm@gmail.com");
        this.telefonoTextF.setPromptText("123789444");
        this.edadTextF.setPromptText("33");

        this.infoLabel.setVisible(false);
    }

    private boolean validateDni(String dni){
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }

    private boolean validateAge(String age){
        return age.matches("[1-9]{1,3}");
    }

    private boolean validateEmail(String email){
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(emailPattern);
    }

    private boolean validatePhone(String phone){
        return phone.matches("[0-9]{9}");
    }

    private boolean validateName(String name){
        return (name.length() > 3 && name.matches("[A-Z]{1}[a-z]{2,25}"));
    }

    private void selectPanelVisible(int panel){
        switch (panel){

            case 0: //PANEL PRINCIPAL
                this.mainView.setVisible(true);
                this.listView.setVisible(false);
                this.formView.setVisible(false);
                break;

            case 1: //PANEL FORMULARIO
                this.mainView.setVisible(false);
                this.listView.setVisible(false);
                this.formView.setVisible(true);
                break;
            case 2://PANEL FORMULARIO
                this.mainView.setVisible(false);
                this.listView.setVisible(true);
                this.formView.setVisible(false);
                break;
            case 3://PANEL FORMULARIO
                this.mainView.setVisible(false);
                this.listView.setVisible(false);
                this.formView.setVisible(false);
                break;
            default:
                this.mainView.setVisible(true);
                this.listView.setVisible(false);
                this.formView.setVisible(false);
        }
    }

    public void onEditarListViewButtonClick(ActionEvent actionEvent) {
    }

    public void onEliminarListViewButtonClick(ActionEvent actionEvent) {
    }

    public void onCancelListViewButtonClick(ActionEvent actionEvent) {
        this.personasListView.setVisible(false);
        this.mainView.setVisible(true);
    }
}