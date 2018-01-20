/*
 *   Deal For All is a Deal For All Inc. is a Tunisian multinational corporation and e-commerce company,
     providing consumer-to-consumer and business-to-consumer sales Reclamations via the internet.
      
      This project is realized by DivTeam Team is an group of 5 persons :Bouzid Med Taher , TakTak Abedlhafidh ,Ouertani Med Firas
    Nasr Med Hedi and Nasri Souha  . This group is associate to 3A3 , ESPRIT from Tunisia.
 */
package com.dealforall.div.dao.interfaces;

import com.dealforall.div.entities.Particulier;
import com.dealforall.div.entities.Publicite;
import com.dealforall.div.entities.Reclamation;
import com.dealforall.div.entities.Reclamation;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rihab
 */
public interface IReclamationDao {
     
   
    File getFileimage();
    void setFileimage(File fileimage);
    void addReclamation(Reclamation Reclamation );// normalement à ajouter user
    void updateReclamation(Reclamation Reclamation,  int idReclamationAModifier);
    void deleteReclamation(Reclamation Reclamation);
     List<Reclamation> displayAllReclamation();
     Reclamation findByIdReclamation(int id);
    Reclamation findByNameReclamation(String Name);
    
}
