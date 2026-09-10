module org.example.maquinadecafejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    //Importante esta linea permite que tengan metodos @FXML
    opens org.example.maquinadecafejavafx.controllers to javafx.fxml;

    //Importante permite
    opens org.example.maquinadecafejavafx.entities to com.google.gson;

    opens org.example.maquinadecafejavafx to javafx.fxml;
    exports org.example.maquinadecafejavafx;
}