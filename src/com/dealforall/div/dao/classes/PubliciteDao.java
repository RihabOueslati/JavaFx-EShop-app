/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.dao.classes;
 
import com.dealforall.div.dao.interfaces.IPubliciteDao;
import com.dealforall.div.entities.Particulier;
import com.dealforall.div.entities.Publicite;
import com.dealforall.div.utils.MyConnection;
import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AsusRog
 */
public class PubliciteDao implements IPubliciteDao<Publicite>{
    
    private Connection connection ;   
    private PreparedStatement preStm ;
    private ResultSet resultSet;
    private final String reqInsert="insert into publiciter (nom,information,affiche) values (?,?,?)";
    private final String reqUpdate="UPDATE publiciter SET nom=?,information=?,affiche=? where id=? ";
    private final String reqDel="DELETE FROM publiciter WHERE id=? ";
    private final String requete = "select * from publiciter ";
    
    public PubliciteDao() {
          connection =(MyConnection.getInstance()).getConnection();
    }
    
    
    @Override
    public void addPublicite(Publicite publicite) {
       try {
             Particulier particulier= new Particulier();
            preStm=connection.prepareStatement(reqInsert);
            preStm.setString(1, publicite.getNom());
            preStm.setString(2, publicite.getInformation());
            preStm.setBlob(3, (Blob)publicite.getImage());
            preStm.setInt(4, particulier.getID());
            preStm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePublicite(Publicite publicite, int id) {
         try {
            PreparedStatement preparedStatement = connection.prepareStatement(reqUpdate);
            preStm=connection.prepareStatement(reqInsert);
            preStm.setString(1, publicite.getNom());
            preStm.setString(2, publicite.getInformation());
            preStm.setBlob(3, (Blob)publicite.getImage()); 
            preStm.executeUpdate();
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public void deletePublicite(Publicite publicite) {
  try {
            PreparedStatement preparedStatement = connection.prepareStatement(reqDel);
            preparedStatement.setInt(1, publicite.getIdPub());
            preparedStatement.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }    }

    @Override
    public List<Publicite> displayAllPublicite() {
       List<Publicite> listePublicite = new ArrayList<>();
        
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Publicite publicite = new Publicite();
                publicite.setNom(resultat.getString(1));
                publicite.setInformation(resultat.getString(2));
                publicite.setImage((Image) resultat.getBlob(3));
                listePublicite.add(publicite);
            }
            return listePublicite;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Publicite findByIdPublicite(int id) {
         Publicite publicite = new Publicite();
      
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                publicite.setIdPub(resultat.getInt(1));
              
            }
            return publicite;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    
}
