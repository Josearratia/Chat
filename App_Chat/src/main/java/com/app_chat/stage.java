/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app_chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author pintu
 */
public class stage extends Application{
    public static Stage Mistage;
    @Override
    public void start(Stage stage) throws Exception {
        Mistage = stage; 
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNIFIED);
        stage.show();
    }
    
    public void chat() throws Exception {
        Parent schat = FXMLLoader.load(getClass().getResource("/fxml/chat.fxml"));
        Stage chat = new Stage();
        //ene scene = new Scene();
        //scene.getStylesheets().add("/styles/Styles.css");
        chat.setTitle("Chat");
        chat.setScene(new Scene(schat));
        chat.initStyle(StageStyle.UNIFIED);
        chat.show();
    }
}
