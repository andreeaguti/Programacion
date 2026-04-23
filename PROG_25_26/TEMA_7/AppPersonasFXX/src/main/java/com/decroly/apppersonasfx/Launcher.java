package com.decroly.apppersonasfx;

import javafx.application.Application;

/**
 * Clase Lanzadora del proyecto.
 * Su única función es arrancar el entorno de JavaFX sin conflictos.
 */
public class Launcher {

    /**
     * Metodo principal (Main) que ejecuta el sistema operativo.
     */
    public static void main(String[] args) {

        // Llama al metodo launch de JavaFX, indicándole que la lógica
        // principal de la ventana está en la clase 'PersonasApp'.
        Application.launch(PersonasApp.class, args);
    }
}