/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app_chat;


import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author pintu
 */
public class guadar extends super_chat{
    public guadar(String user, String pass, String ip){
        usuario = user;
        imagen = pass;
        this.ip = ip;
    }
    
    @Override
    public void SetValidar() throws Exception{
        if(usuario.length() > 0){
           if(usuario != null || !usuario.isEmpty()){
                if(imagen.length() > 0){
                    if(imagen != null || !imagen.isEmpty()){
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
    
    private void guardado() throws Exception{
        Alert err = new Alert(Alert.AlertType.INFORMATION);
        err.setTitle("Usuario guardado");
        err.setHeaderText("Se registro con exito");
        err.showAndWait();
        Stage chat = null;
        new stage().chat();
    }
}





//Label_info.setStyle("-fx-min-width: 233; -fx-min-height: 33; -fx-translate-x: 0;");
       // Label_info.setText("");