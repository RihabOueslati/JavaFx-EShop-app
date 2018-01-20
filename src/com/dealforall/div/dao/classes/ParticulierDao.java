/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.dao.classes; 
import com.dealforall.div.dao.interfaces.IParticulierDao;
import com.dealforall.div.entities.Particulier;
import com.dealforall.div.entities.Reclamation;
import com.dealforall.div.utils.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author AsusRog
 */
public class ParticulierDao implements IParticulierDao<Particulier>{
    
    private Connection connection ;   
    private PreparedStatement preStm ;
    private ResultSet resultSet;
    private final String reqInsert="insert into utilisateur (nom,prenom,age,date_de_naissance,type,adresse,login,password) values (?,?,?,?,?,?,?,?)";
    private final String reqUpdate="UPDATE utilisateur SET nom=?,prenom=?,age=?,date_de_naissance=?,type=?,adresse=?,login=?,password=? where id=? ";
    private final String reqDel="DELETE FROM utilisateur WHERE id=? ";
    private final String query = "select * from utilisateur where login = ? and password = ?";
    private final String requete = "select * from utilisateur where id=?";

    
    
    
      public ParticulierDao() {
          connection =(MyConnection.getInstance()).getConnection();
    }
  
      public boolean isLogin(String login , String password) throws SQLException
{
	  PreparedStatement preparedStatement = null;
	  ResultSet resultSet = null ;
	  try
	  {
		  preparedStatement =connection.prepareStatement(query);
		  preparedStatement.setString(1, login);
		  preparedStatement.setString(2, password);
		  resultSet = preparedStatement.executeQuery();
		  if(resultSet.next())
		  {
			  return true;
		  }
		  else 
		  {
			  return false;
		  }
	  } catch (Exception ex) {
         
          return false;
      }finally
	  {
		  preparedStatement.close();
		  resultSet.close();
	  }
  }
      
          @Override
    public void addParticuler(Particulier particulier) {
       try {
            
            preStm=connection.prepareStatement(reqInsert);
            preStm.setString(1, particulier.getNom());
            preStm.setString(2, particulier.getPrenom());
            preStm.setDate(3, (Date) particulier.getDateDeNaissance());
            preStm.setInt(4, particulier.getAge());
            preStm.setString(5, "Particulier");
            preStm.setString(6, particulier.getAdresse());
            preStm.setString(7, particulier.getLogin());
            preStm.setString(8, particulier.getPassword());
            preStm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParticulierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    
@Override
    public void updateParticulier(Particulier particulier, int id) {
     try {
            String req = "UPDATE `utilisateur` SET  "
                    + "`nom`=?,"
                    + "`prenom`=?,"
                   
                    + "WHERE `id`='"+id+"'";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, particulier.getNom());
            ps.setString(2, particulier.getPrenom());
           /* ps.setString(3, service.getCategorie());
            ps.setString(4, Integer.toString(service.getPointBonus()));
           // ps.setString(5,"SYSDATE()");// service.getDateDePublication().toString());
            ps.setString(5, service.getDateDeExpiration().toString());
            ps.setString(6, service.getDescription());*/
            /*
            Bloc d ' ajout d'image  : Début 
            
            */
           /* File image = fileimage;
            FileInputStream fis = new FileInputStream(image);
            if(image!=null)
            {ps.setBinaryStream(7, (InputStream)fis, (int)(image.length()));
            }
            else
            {
                ps.setBinaryStream(7, service.getImage());
            }
            
            
              /*
            Bloc d ' ajout d'image  : Fin
            
            */
   
             // System.out.println(ps);
              ps.executeUpdate();
              System.out.println("Mise a jour de service effectué avec succès");
              
              
              
        } catch (SQLException ex) {
          //  Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("erreur lors de le mise à jour de service " + ex.getMessage());
        }
    
    
    }

    @Override
    public void removeParticulierById(int id) {
       
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(reqDel);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public Particulier findPannierById(int id) {
         
         Particulier particulier = new Particulier();
      
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                particulier.setID(resultat.getInt(1));
                particulier.setAdresse(resultat.getString(2));
            }
            return particulier;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    public Particulier findByNameParticulier(String nom) {

      String requete = "SELECT * FROM `utilisateur` WHERE `nom`='"+nom+"'";

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
             
            
            Particulier particulier = new Particulier();
            while (resultat.next()) {

                particulier.setID(resultat.getInt(1));
                particulier.setNom(resultat.getString(2));
                particulier.setPrenom(resultat.getString(3));
               
                
                /*
                Convert String to Date : Date publication
                */
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date startDate = df.parse(resultat.getString(4));

            }

            return particulier;
        } catch (SQLException ex) {
            System.out.println(requete);
            System.out.println("erreur lors du chargement" + ex.getMessage());
           
            
        } catch (ParseException ex) {
            Logger.getLogger(ParticulierDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

   

    }
