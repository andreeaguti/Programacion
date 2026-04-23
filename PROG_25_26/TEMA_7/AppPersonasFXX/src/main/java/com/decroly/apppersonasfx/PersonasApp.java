package com.decroly.apppersonasfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la interfaz gráfica.
 * Hereda de 'Application', lo que le permite gestionar el ciclo de vida de una ventana JavaFX.
 */
public class PersonasApp extends Application {

    /**
     * El metodo start es el punto de entrada para la interfaz.
     * @param stage Representa la ventana principal (el "marco").
     */
    @Override
    public void start(Stage stage) throws IOException {

        // 1. Cargador de FXML: Busca el archivo de diseño visual en la carpeta de recursos.
        FXMLLoader fxmlLoader = new FXMLLoader(PersonasApp.class.getResource("personas-view.fxml"));

        // 2. Escena: Carga el contenido del FXML y define el tamaño de la ventana (640x640 píxeles).
        // fxmlLoader.load() es el momento real en que se lee el archivo y se crea la vista.
        Scene scene = new Scene(fxmlLoader.load(), 640, 640);

        // 3. Configuración de la ventana:
        stage.setTitle("App administración Personas"); // Título que sale arriba en la barra de la ventana.
        stage.setScene(scene);                         // Le dice a la ventana qué escena debe mostrar.

        // 4. Mostrar: Hace que la ventana sea visible para el usuario.
        stage.show();
    }
}