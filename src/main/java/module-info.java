module ma.example.dev {
    // Exporte les packages contenant les classes accessibles depuis d'autres modules
    exports ma.example.dev;

    // Requiert JavaFX modules pour utiliser JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // Requiert Jackson pour la sérialisation/désérialisation JSON
    requires com.fasterxml.jackson.databind;
    requires java.base;
    opens ma.example.dev to com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.datatype.jsr310;


    // Si vous utilisez Lombok pour la génération de code
    requires static lombok;
}
