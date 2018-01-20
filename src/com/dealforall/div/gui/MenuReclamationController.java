/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aikikai
 */
public class MenuReclamationController   {

      public void goAddReclamation(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("AddReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter Reclamation--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
      
      
       public void goUpdateReclamation(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("UpdateReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Modifier Reclamation--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
       
       
        public void goDeleteReclamation(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("DeleteReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Supprimer Reclamation--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
         public void goDisplayReclamationsFirst(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("DisplayReclamationFirst.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Les Reclamation--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }

         
          public void goRendreReclamation(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("RendreReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Rendre Reclamation--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
         
        
}
