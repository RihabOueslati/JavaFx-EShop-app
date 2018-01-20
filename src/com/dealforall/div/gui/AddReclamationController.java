/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.gui;

import com.dealforall.div.dao.classes.ReclamationDao;
import com.dealforall.div.dao.interfaces.IReclamationDao;
import com.dealforall.div.entities.Particulier;
import com.dealforall.div.entities.Reclamation;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author aikikai
 */
public class AddReclamationController  {
 ObservableList<String> Services=FXCollections.observableArrayList(
    
    "Services d’entretien et de réparation", 
"Services de transports  ",
"Transports de courrier par transport terrestre et par air",
"Services de télécommunications",
"Services financiers",
"Services informatiques et services connexes",
"Services de recherche et de développemenet",
 
"Services d’études de marché et de sondages",
"Services de conseil en gestion  et services  de connexes",
"Services d’architecture",
"Services d’ingénierie",
"Services de publicité",
"Services de nettoyage",
"Services de publication et d’impression"
    
    );
    
    
    @FXML
    private TextField TNom;
     @FXML
    private TextField TAdresse;
     @FXML
    private ComboBox CbCategorie;
     @FXML
    private DatePicker TDate;
     @FXML
    private TextArea TDescription;
     @FXML
    private ImageView IImage;
     @FXML
    private Button btnChoisirImage;
    
    private Image imageSer;
    
     private File selecFile;
    
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
  public void initialize() {
      
         // TODO
  CbCategorie.setValue("Services d’entretien et de réparation");
  CbCategorie.setItems(Services);
      
   }    
  public void ChoiceImage(ActionEvent event) throws IOException
    {
     
        FileChooser fc = new FileChooser();
       selecFile = fc.showOpenDialog(null);
        
        if(selecFile !=null)
        {
            BufferedImage bufferedImage = ImageIO.read(selecFile);
          imageSer   = SwingFXUtils.toFXImage(bufferedImage, null);
                IImage.setImage(imageSer);
        }
        else
        {
            System.out.println("file is not valid");
        }
       
  
  }
public void goAddService(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("AddReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajouter Service--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
      
      
       public void goUpdateService(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("UpdateReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Modifier Service--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
       
       
        public void goDeleteService(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("DeleteReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Supprimer Service--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
         public void goDisplayServicesFirst(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("DisplayReclamationFirst.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Les Services--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }

         
          public void goRendreService(ActionEvent event) {
        try
        {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root =  loader.load(getClass().getResource("RendreReclamation.fxml"));    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Rendre Service--Deal For All");
            primaryStage.show();    
        }catch(Exception e)
        {
            
        }
        
    
    }
    
      public void ExposerService(ActionEvent event)
    {
 
        Reclamation reclamation = new Reclamation();
        reclamation.setType(TAdresse.getText());
          
        reclamation.setContenu(TDescription.getText());
      
       // service.setImage(imageSer);
         
        //To Convert Date : on doit changer le type Date dans la classe entite service en type LocalDate 
        LocalDate localDate = TDate.getValue();
          
       
        IReclamationDao serviceDao = new ReclamationDao();
        Particulier part =new Particulier(); 
        /* 
         A ne pas oublier d'intégrer l'identificateur de particulier
        */
        
        serviceDao.setFileimage(selecFile);
        serviceDao.addReclamation(reclamation);
        
        
        
    }
}
