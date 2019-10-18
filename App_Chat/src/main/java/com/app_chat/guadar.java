/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app_chat;


import javafx.scene.control.Alert;

/**
 *
 * @author pintu
 */
public class guadar{
    String usuario, contrasena;
    boolean TrueSave;
    
    public guadar(String user, String pass){
        usuario = user;
        contrasena = pass;
    }
    
    public void SetValidar(){
        if(usuario.length() > 0){
           if(usuario != null || !usuario.isEmpty()){
                if(contrasena.length() > 0){
                    if(contrasena != null || !contrasena.isEmpty()){
                        guardado();
                    }else{
                        err();
                    }
                }else{
                    err();
                }
            }else{
                err();
            }
        }else{
            err();
        }
    }
    
    
    private void err(){
        Alert err = new Alert(Alert.AlertType.ERROR);
        err.setTitle("Campo vacio");
        err.setHeaderText("Rellene todos los campos");
        err.showAndWait();
    }
    
    private void guardado(){
        Alert err = new Alert(Alert.AlertType.INFORMATION);
        err.setTitle("Usuario guardado");
        err.setHeaderText("Se registro con exito");
        err.showAndWait();   
    }
}





//Label_info.setStyle("-fx-min-width: 233; -fx-min-height: 33; -fx-translate-x: 0;");
       // Label_info.setText("");