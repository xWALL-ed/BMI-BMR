package com.example.bmi_bmr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 {
    Parent root;
    Stage stage;
    Scene scene;
    String genIdP2;
    public void clickBmiBtn(ActionEvent e) throws IOException {

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("p3.fxml"));
        root=fxmlLoader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void clickBmrBtn(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("p4.fxml"));
        root=fxmlLoader.load();
        Controller4 con4 = fxmlLoader.getController();
        con4.setGenIdP4(genIdP2);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}