package com.app_chat;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {
    
    @FXML
    private Label Label_Titutlo;
    @FXML
    private Button btn_btn1;
    @FXML
    private Button btn_btn2;
    @FXML
    private Button btn_btn3;
    @FXML
    private TextField user;
    @FXML
    private TextField img;
    @FXML
    public static Label Label_info;
    @FXML
    private TextField ip;
    
    @FXML
    private void sesion(){
        stage.Mistage.setTitle("Inicio de sesion");
        Label_Titutlo.setStyle("-fx-min-width: 190; -fx-min-height: 33;");
        Label_Titutlo.setText("Inicio de sesion");
        btn_btn1.setText("Entrar");
        btn_btn2.setText("Registrarse");
        ip.setText("127.0.0.1");
        img.setText("src/main/resources/fxml/Default.png");
        btn_btn2.setVisible(false);
        
        btn_btn1.setOnAction((ActionEvent event) -> {
            try {
                System.out.println("entrar");
                guardar();
            } catch (Exception ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_btn2.setOnAction((ActionEvent event) -> {
            System.out.println("Registrarse");
            
            registrarse();
        });
        
        btn_btn3.setOnAction( event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        // Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(null);

        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            img.setText(imgFile.getAbsolutePath().toString());
        }
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
            try {
                guardar();
            } catch (Exception ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_btn2.setOnAction((ActionEvent event) -> {
            System.out.println("cancelar");
            sesion();
        });
    }
    
    static guadar usuario;
    @FXML
    private void guardar() throws Exception{
        usuario = new guadar(user.getText(),img.getText(),ip.getText());
        usuario.SetValidar();
    }
    
    public static guadar getuser(){
        return usuario;
    }
            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sesion();
    }    
}
