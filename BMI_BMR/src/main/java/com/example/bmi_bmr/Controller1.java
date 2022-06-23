package com.example.bmi_bmr;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {

    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    ComboBox<String> g;
    @FXML
    public void clickNxtBtn(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("p2.fxml"));
        root=fxmlLoader.load();
        Controller2 con = fxmlLoader.getController();
        con.genIdP2=g.getValue();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        g.setItems(FXCollections.observableArrayList("Male","Female"));
    }
}