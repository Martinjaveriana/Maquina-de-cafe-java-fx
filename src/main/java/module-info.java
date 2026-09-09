module org.example.maquinadecafejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.maquinadecafejavafx to javafx.fxml;
    exports org.example.maquinadecafejavafx;
}