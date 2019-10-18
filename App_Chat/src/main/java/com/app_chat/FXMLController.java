package com.app_chat;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private Label Label_Titutlo;
    @FXML
    private Button btn_btn1;
    @FXML
    private Button btn_btn2;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    public static Label Label_info;
    
    @FXML
    private void sesion(){
        stage.Mistage.setTitle("Inicio de sesion");
        Label_Titutlo.setStyle("-fx-min-width: 190; -fx-min-height: 33;");
        Label_Titutlo.setText("Inicio de sesion");
        btn_btn1.setText("Entrar");
        btn_btn2.setText("Registrarse");
        
        btn_btn1.setOnAction((ActionEvent event) -> {
            System.out.println("entrar");
            
        });
        
        btn_btn2.setOnAction((ActionEvent event) -> {
            System.out.println("Registrarse");
            
            registrarse();
        });
    }
    
    @FXML
    private void registrarse(){
        stage.Mistage.setTitle("Registro de usuario");
        Label_Titutlo.setStyle("-fx-min-width: 233; -fx-min-height: 33; -fx-translate-x: -24;");
        Label_Titutlo.setText("Registro de usuario");
        btn_btn1.setText("Guardar");
        btn_btn2.setText("Cancelar");
        
        btn_btn1.setOnAction((ActionEvent event) -> {
            System.out.println("Guardar");
            guardar();
        });
        
        btn_btn2.setOnAction((ActionEvent event) -> {
            System.out.println("cancelar");
            sesion();
        });
    }
    
    @FXML
    private void guardar(){
        new guadar(user.getText(),pass.getText()).SetValidar();
    }
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sesion();
    }    
}
