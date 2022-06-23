module com.example.bmi_bmr {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.bmi_bmr to javafx.fxml;
    exports com.example.bmi_bmr;
}