package com.example.bmi_bmr;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller4 implements Initializable {
    @FXML
    ComboBox<String> boxActivity;
    @FXML
    TextField txtAge;
    @FXML
    TextField txtHeight;
    @FXML
    TextField txtHeightF;
    @FXML
    TextField txtHeightI;
    @FXML
    TextField txtWeight;
    @FXML
    TextField txtBmr;
    @FXML
    CheckBox ticMale;
    @FXML
    CheckBox ticFemale;
    @FXML
    RadioButton cmTic;
    @FXML
    RadioButton fiTic;
    @FXML
    Button a;
    @FXML
    Button b;
    @FXML
    Button c;
    @FXML
    Button d;
    @FXML
    Label msg;
    Parent root;
    Stage stage;
    Scene scene;
    String genIdP4="Male";
    public void setGenIdP4(String x){
        genIdP4=x;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(genIdP4);
        if (genIdP4=="Male"){
            ticMale.setSelected(true);
            ticFemale.setSelected(false);
        } else if (genIdP4=="Female") {
            ticFemale.setSelected(true);
            ticMale.setSelected(false);
        }
        a.setDisable(true);
        a.setOpacity(1.0);
        b.setDisable(true);
        b.setOpacity(1.0);
        c.setDisable(true);
        c.setOpacity(1.0);
        d.setDisable(true);
        d.setOpacity(1.0);
        boxActivity.setItems(FXCollections.observableArrayList(
                "Little or no exercise",
                "Light exercise or sports 1-3 days/week",
                "Moderate exercise 3-5 days/week",
                "Hard exercise 6-7 days/week",
                "Very hard exercise and a physical job"
                ));
        cmTic.setSelected(true);
        txtHeight.setDisable(false);
        txtHeight.setVisible(true);
        txtHeight.setText("");
        txtHeightI.setVisible(false);
        txtHeightI.setDisable(true);
        txtHeightF.setVisible(false);
        txtHeightF.setDisable(true);
        if(fiTic.isSelected()){
            fiTic.setSelected(false);
        }
    }
    public double activity(String x){
        switch (x){
            case "Little or no exercise": return 1.2;
            case "Light exercise or sports 1-3 days/week": return 1.375;
            case "Moderate exercise 3-5 days/week": return 1.55;
            case "Hard exercise 6-7 days/week": return 1.725;
            case "Very hard exercise and a physical job": return 1.9;
        }
        return 1.0;
    }
    @FXML
    public void clickCalcBtn(){
        double act = activity(boxActivity.getValue());
        double age=Double.parseDouble(txtAge.getText());
        double heightCm=0.0;
        double heightF=0.0;
        double heightI=0.0;
        double weight=Double.parseDouble(txtWeight.getText());
        double height=0.0;
        if (cmTic.isSelected()){
            heightCm = Double.parseDouble(txtHeight.getText());
            height = heightCm;
        } else if (fiTic.isSelected()) {
            heightF= Double.parseDouble(txtHeightF.getText());
            heightI= Double.parseDouble(txtHeightI.getText());
            height = ((heightF*12.0)+heightI)*2.54;
        }
        double resultMale=((10.0*weight)+(6.25*height)-(5.0*age)+5.0)*act;
        String rM=String.valueOf(resultMale);
        double resultFemale=((10.0 * weight) + (6.25 * height) - (5.0 * age) - 161.0)*act;
        String rF=String.valueOf(resultFemale);
        if (ticMale.isSelected() && !ticFemale.isSelected()){
            txtBmr.setText(rM+" Calorie");
            msg.setText("Your Body needs "+rM+" Calorie to perform its most basic functions");
        }else {
            txtBmr.setText(rF+" Calorie");
            msg.setText("Your Body needs "+rF+" Calorie to perform its most basic functions");
        }
    }
    @FXML
    public void setTicMale(){
        ticMale.setSelected(true);
        if (ticFemale.isSelected()){
            ticFemale.setSelected(false);
        }
    }
    @FXML
    public void setTicFemale(){
        ticFemale.setSelected(true);
        if (ticMale.isSelected()){
            ticMale.setSelected(false);
        }
    }
    @FXML
    public void setCmTic(){
        cmTic.setSelected(true);
        txtHeight.setDisable(false);
        txtHeight.setVisible(true);
        txtHeight.setText("");
        txtHeightI.setVisible(false);
        txtHeightI.setDisable(true);
        txtHeightF.setVisible(false);
        txtHeightF.setDisable(true);
        if(fiTic.isSelected()){
            fiTic.setSelected(false);
        }
    }
    @FXML
    public void setFiTic(){
        fiTic.setSelected(true);
        txtHeight.setDisable(true);
        txtHeight.setVisible(false);
        txtHeightI.setVisible(true);
        txtHeightI.setDisable(false);
        txtHeightI.setText("");
        txtHeightF.setVisible(true);
        txtHeightF.setDisable(false);
        txtHeightF.setText("");
        if(cmTic.isSelected()){
            cmTic.setSelected(false);
        }
    }
    public void clickBackBtn(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("p2.fxml"));
        root=fxmlLoader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
