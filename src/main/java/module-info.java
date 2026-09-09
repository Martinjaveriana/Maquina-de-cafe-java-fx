module org.example.maquinadecafejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    //Importante esta linea permite que tengan metodos @FXML
    opens org.example.maquinadecafejavafx.controllers to javafx.fxml;

    opens org.example.maquinadecafejavafx to javafx.fxml;
    exports org.example.maquinadecafejavafx;
}