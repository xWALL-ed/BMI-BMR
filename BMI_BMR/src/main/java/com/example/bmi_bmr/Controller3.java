package com.example.bmi_bmr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller3 implements Initializable {
    @FXML
    TextField heightTxt;
    @FXML
    TextField weightTxt;
    @FXML
    TextField bmiTxt;
    @FXML
    TextField statusTxt;
    @FXML
    TextField statusTxt1;
    @FXML
    RadioButton ticCm;
    @FXML
    RadioButton ticFI;
    @FXML
    TextField heightTxtF;
    @FXML
    TextField heightTxtI;
    @FXML
    Button x;
    @FXML
    Button y;
    Parent root;
    Stage stage;
    Scene scene;
    @FXML
    public void clickCalcBmiBtn(){
        double heightCm=0.0;
        double heightF=0.0;
        double heightI=0.0;
        double weight= Double.parseDouble(weightTxt.getText());
        double height=0.0;
        if (ticCm.isSelected()){
            heightCm = Double.parseDouble(heightTxt.getText());
            height = heightCm;
        } else if (ticFI.isSelected()) {
            heightF= Double.parseDouble(heightTxtF.getText());
            heightI= Double.parseDouble(heightTxtI.getText());
            height = ((heightF*12.0)+heightI)*2.54;
        }
        double result = weight/((height/100.0)*(height/100.0));
        bmiTxt.setText(String.valueOf(result));
        if(result<18.5){
            statusTxt.setText("  Underweight");
            statusTxt1.setText(" Need some more weight ;) ");
        } else if (result>=18.5&&24.9>=result) {
            statusTxt.setText("  Normal weight  ");
            statusTxt1.setText(" Congratulation perfect Shape ");
        } else if (result>24.9&&29.9>=result) {
            statusTxt.setText("  Overweight  ");
            statusTxt1.setText(" Need to Loose some weight ");
        } else if (result>29.9){
            statusTxt.setText("  Obesity  ");
            statusTxt1.setText(" Need serious weight lose ");
        }
    }
    @FXML
    public void clickBackBtn(ActionEvent e) throws IOException {
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("p2.fxml"));
        root=fxmlLoader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void setTicCm(){
        ticCm.setSelected(true);
        heightTxt.setDisable(false);
        heightTxt.setVisible(true);
        heightTxt.setText("");
        heightTxtI.setVisible(false);
        heightTxtI.setDisable(true);
        heightTxtF.setVisible(false);
        heightTxtF.setDisable(true);
        if(ticFI.isSelected()){
            ticFI.setSelected(false);
        }
    }
    @FXML
    public void setTicFI(){
        ticFI.setSelected(true);
        heightTxt.setDisable(true);
        heightTxt.setVisible(false);
        heightTxtI.setVisible(true);
        heightTxtI.setDisable(false);
        heightTxtI.setText("");
        heightTxtF.setVisible(true);
        heightTxtF.setDisable(false);
        heightTxtF.setText("");
        if(ticCm.isSelected()){
            ticCm.setSelected(false);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        x.setDisable(true);
        x.setOpacity(1.0);
        y.setDisable(true);
        y.setOpacity(1.0);
        ticCm.setSelected(true);
        heightTxt.setDisable(false);
        heightTxt.setVisible(true);
        heightTxt.setText("");
        heightTxtI.setVisible(false);
        heightTxtI.setDisable(true);
        heightTxtF.setVisible(false);
        heightTxtF.setDisable(true);
        if(ticFI.isSelected()){
            ticFI.setSelected(false);
        }
    }
}