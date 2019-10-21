/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 *
 * @author pintu
 */
public class FXMLChatController extends Thread implements Initializable  {
     @FXML
    private Button btn_enviar;

    @FXML
    private ImageView imguser;

    @FXML
    private TextArea box_chat;

    @FXML
    private TextField text_send;

    @FXML
    private ChoiceBox<?> OnUser;

    @FXML
    private Label name_user;

    super_chat usuario;
    BufferedReader in;
    PrintWriter out;
    
    public void getuser(){
       usuario = FXMLController.getuser();
       setname();
       setimg();
    }
    
    private void setname(){
        name_user.setText("Nombre: "+usuario.usuario);
    }
    
    private void setimg(){
        Image image = new Image("file:" + usuario.imagen);
        imguser.setImage(image);
    }

    private String direccionServidor(){
        return usuario.ip;
    }
    
    private String nombre(){
        return usuario.usuario;
    }
    
    @Override
    public void run(){
         try {
             String ds = direccionServidor();
             Socket sk = new Socket(ds, 9001);
             in = new BufferedReader(new InputStreamReader(
                     sk.getInputStream()));
             out = new PrintWriter(sk.getOutputStream(), true);
             while (true) {
                 String txt = in.readLine();
                 System.out.println(txt);
                 if (txt.startsWith("NOMBREE")) {
                     out.println(nombre());
                 } else if (txt.startsWith("NOMBREA")) {
                     text_send.setEditable(true);
                     btn_enviar.setDisable(false);
                 } else if (txt.startsWith("Mensaje")) {
                     box_chat.appendText(txt.substring(8) + "\n");
                 }
             }} catch (IOException ex) {
             Logger.getLogger(FXMLChatController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getuser();
        text_send.setEditable(false);
        btn_enviar.setDisable(true);
        start();
        btn_enviar.setOnAction((ActionEvent event) -> {
            out.println(text_send.getText());
            text_send.setText("");
        });
    }
    
}

