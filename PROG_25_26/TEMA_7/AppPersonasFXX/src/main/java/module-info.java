module AppPersonasFXX {
    requires javafx.controls; //Le dice a Java que vas a usar botones, etiquetas y ventanas de JavaFX.
    requires javafx.fxml; //Necesario para que el programa pueda leer tus archivos .fxml
    requires java.sql;//Obligatorio si en el futuro conectas tu App de Personas con una base de datos.


    exports com.decroly.apppersonasfx;
    opens com.decroly.apppersonasfx to javafx.fxml; //Indica que cualquier otro módulo que use el tuyo puede ver y utilizar las clases que están dentro de ese paquete.
}
/**Es el archivo que define la identidad y las fronteras de tu proyecto. En Java moderno, los proyectos no son solo un montón de carpetas, sino "módulos" cerrados por defecto por seguridad y eficiencia. Si no tuvieras este archivo, Java no sabría qué piezas de JavaFX necesitas ni permitiría que JavaFX viera tu código.**/