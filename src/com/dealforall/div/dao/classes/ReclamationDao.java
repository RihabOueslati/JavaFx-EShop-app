/*
 *   Deal For All is a Deal For All Inc. is a Tunisian multinational corporation and e-commerce company,
     providing consumer-to-consumer and business-to-consumer sales Reclamations via the internet.
      
      This project is realized by DivTeam Team is an group of 5 persons :Bouzid Med Taher , TakTak Abedlhafidh ,Ouertani Med Firas
    Nasr Med Hedi and Nasri Souha  . This group is associate to 3A3 , ESPRIT from Tunisia.
 */
package com.dealforall.div.dao.classes;

import com.dealforall.div.dao.interfaces.IReclamationDao;
import com.dealforall.div.entities.Reclamation;
import com.dealforall.div.entities.Particulier;
import com.dealforall.div.utils.MyConnection;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Rihab
 */
public class ReclamationDao implements IReclamationDao{
    private Connection connection;
     private File fileimage;
     private byte[] imageBytes;
     
    public ReclamationDao() {
         connection = MyConnection.getInstance().getConnection();
    }

    
    
    @Override
     public void addReclamation(Reclamation reclamation ) {
          try {
            String req = "INSERT INTO reclamationtest (type,contenu) VALUES ( ?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
        
    
//       preStm.setInt(1, usr.getId());
       ps.setString(1, reclamation.getType());
       ps.setString(2, reclamation.getContenu());
          

   
              System.out.println(ps);
              ps.executeUpdate();
              System.out.println("Ajout de Reclamation effectué avec succès");
              
              
              
        } catch (SQLException ex) {
          //  Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
     }

    @Override
    public void updateReclamation(Reclamation Reclamation, int idReclamationAModifier) {
     try {
            String req = "UPDATE `reclamationtest` SET  "
                    + "`type`=?,"
                    + "`contenu`=?,"
                    + "WHERE `id`='"+idReclamationAModifier+"'";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, Reclamation.getType());
            ps.setString(2, Reclamation.getContenu());
           // ps.setInt(3, Reclamation.getId_utilisateur());
          
            /*
            Bloc d ' ajout d'image  : Début 
            
            */
            
            
              /*
            Bloc d ' ajout d'image  : Fin
            
            */
    
             // System.out.println(ps);
              ps.executeUpdate();
              System.out.println("Mise a jour de Reclamation effectué avec succès");
              
              
              
        } catch (SQLException ex) {
          //  Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("erreur lors de le mise à jour de Reclamation " + ex.getMessage());
        }
    
    
    }

    @Override
    public void deleteReclamation(Reclamation Reclamation) {

       String requete = "DELETE FROM `reclamationtest` WHERE `id`=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, Reclamation.getId());
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    
    
    }

    @Override
    public  List<Reclamation> displayAllReclamation() {
  
        List<Reclamation> listReclamations = new ArrayList<>();
        String requete = "select * from `reclamationtest`";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             
            while (resultat.next()) {
                Reclamation Reclamation = new Reclamation();
                Reclamation.setId(resultat.getInt(1));
                Reclamation.setType(resultat.getString(2));
                Reclamation.setContenu(resultat.getString(3));
               
               
                /*
                Convert String to Date : Date publication
                */
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                Date startDate = df.parse(resultat.getString(4));
                Reclamation.setDate(startDate);
                /*
                Convert String to Date : End
                */
               /*
                Convert String to Date : Date Expiration
                */
       

                /*
                Convert String to Date : End
                */
 
            
                listReclamations.add(Reclamation);
           
            }
            return listReclamations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
       return null;
        }
   
    }

    @Override
    public Reclamation findByIdReclamation(int id) {
   String requete = "SELECT * FROM `reclamationtest` WHERE `id`='"+id+"'";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
             
            
            Reclamation Reclamation = new Reclamation();
            while (resultat.next()) {

                Reclamation.setId(resultat.getInt(1));
                Reclamation.setType(resultat.getString(2));
                Reclamation.setContenu(resultat.getString(3));
               
                
                /*
                Convert String to Date : Date publication
                */
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                Date startDate = df.parse(resultat.getString(4));
                Reclamation.setDate(startDate);
                /*
                Convert String to Date : End
                */
                
                /*
                Convert String to Date : Date Expiration
                */
       
             
                /*
                Convert String to Date : End
                */
                
              
                 
//                imageBytes = resultat.getBytes(9);
//                ImageIcon image = new ImageIcon(imageBytes);
//                Image im = image.getImage(); 
//                Reclamation.setImage(im); 
//                
              
                
                
            }
            
            
            
            return Reclamation;
        } catch (SQLException ex) {
            System.out.println(requete);
            System.out.println("erreur lors du chargement" + ex.getMessage());
           
            
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
}

    @Override
    public File getFileimage() {
 return fileimage;
    }

    @Override
    public void setFileimage(File fileimage) {
         this.fileimage = fileimage;
     }

     @Override
    public Reclamation findByNameReclamation(String type) {

      String requete = "SELECT * FROM `reclamationtest` WHERE `type`='"+type+"'";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
             
            
            Reclamation Reclamation = new Reclamation();
            while (resultat.next()) {

                Reclamation.setId(resultat.getInt(1));
                Reclamation.setType(resultat.getString(2));
                Reclamation.setContenu(resultat.getString(3));
               
                
                /*
                Convert String to Date : Date publication
                */
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                Date startDate = df.parse(resultat.getString(4));
                Reclamation.setDate(startDate);
                /*
                Convert String to Date : End
                */
                
                /*
                Convert String to Date : Date Expiration
                */
       
            
                /*
                Convert String to Date : End
                */
                
                
                 
//                imageBytes = resultat.getBytes(9);
//                ImageIcon image = new ImageIcon(imageBytes);
//                Image im = image.getImage(); 
//                Reclamation.setImage(im); 
//             
                
                
                
            }
            
            
            
            return Reclamation;
        } catch (SQLException ex) {
            System.out.println(requete);
            System.out.println("erreur lors du chargement" + ex.getMessage());
           
            
        } catch (ParseException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

    
}
