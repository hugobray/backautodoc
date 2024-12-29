module com.example.backautodoc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.backautodoc to javafx.fxml;
    exports com.example.backautodoc;
}