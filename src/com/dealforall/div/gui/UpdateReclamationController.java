/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.gui;

import com.dealforall.div.dao.classes.ParticulierDao;
import com.dealforall.div.dao.interfaces.IParticulierDao;
import com.dealforall.div.entities.Particulier;
import com.dealforall.div.entities.Reclamation;
import java.awt.image.BufferedImage;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * FXML Controller class
 *
 * @author aikikai
 */
public class UpdateReclamationController  {
 @FXML
    private TextField TNomServieAModif;
    ObservableList<String> Reclamations=FXCollections.observableArrayList(
    
    "Reclamations d’entretien et de réparation", 
"Reclamations de transports  ",
"Transports de courrier par transport terrestre et par air",
"Reclamations de télécommunications",
"Reclamations financiers",
"Reclamations informatiques et Reclamations connexes",
"Reclamations de recherche et de développemenet",
"Reclamations d’études de marché et de sondages",
"Reclamations de conseil en gestion  et Reclamations  de connexes",
"Reclamations d’architecture",
"Reclamations d’ingénierie",
"Reclamations de publicité",
"Reclamations de nettoyage",
"Reclamations de publication et d’impression"
    
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
    @FXML
    private GridPane grUpdateReclamation;
    
    @FXML
    private Label LabelImage;
    
    
    private Image imageSer;
     private File selecFile;
     
     
     
     
     
     
    
     public void initialize(URL url, ResourceBundle rb){
       
  CbCategorie.setValue("Reclamations d’entretien et de réparation");
  CbCategorie.setItems(Reclamations);
     
  
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
          
          
               public void LoadData(ActionEvent event) throws FileNotFoundException, IOException {
              /*
              A implémenter l'id de l'utilisateur lors de requette select
              */
              
              ParticulierDao particulierDao = new ParticulierDao();
              
              Particulier svAModifier  = particulierDao.findByNameParticulier(TNomServieAModif.getText());
              
              
              grUpdateReclamation.setDisable(false);
              TNom.setText(svAModifier.getNom());
              TAdresse.setText(svAModifier.getPrenom());

             
              
            
//              BufferedImage bufferedImage = ImageIO.read(selecFile);
//          imageSer   = SwingFXUtils.toFXImage(bufferedImage, null);
//                IImage.setImage(imageSer);
              
             // InputStream f = new FileInputStream(svAModifier.getImage()) ;

            
    }  


        public void updateParticulier(ActionEvent event)
    {
 
        Reclamation Reclamation = new Reclamation();
        Reclamation.setType(TAdresse.getText());
        Reclamation.setContenu(CbCategorie.getValue().toString());//   
       
        
       // Reclamation.setImage(imageSer);
         
        //To Convert Date : on doit changer le type Date dans la classe entite Reclamation en type LocalDate 
       
         ParticulierDao particulierDao = new ParticulierDao();
          Particulier svAModifier  = particulierDao.findByNameParticulier(TNomServieAModif.getText());
             
        
        
       
       
        Particulier particulier =new Particulier(); 
        /* 
         A ne pas oublier d'intégrer l'identificateur de particulier
        */
        
  
        
        
      
        //ParticulierDao.updateParticulier(particulier,svAModifier.getID());
        
        
        
    }

}
