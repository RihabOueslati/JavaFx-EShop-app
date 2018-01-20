/*
 *   Deal For All is a Deal For All Inc. is a Tunisian multinational corporation and e-commerce company,
     providing consumer-to-consumer and business-to-consumer sales services via the internet.
      
      This project is realized by DivTeam Team is an group of 5 persons :Bouzid Med Taher , TakTak Abedlhafidh ,Ouertani Med Firas
    Nasr Med Hedi and Nasri Souha  . This group is associate to 3A3 , ESPRIT from Tunisia.
 */
package com.dealforall.div.dao.interfaces;

import com.dealforall.div.entities.Particulier;

/**
 *
 * @author aikikai
 */
public interface IParticulierDao <Particulier>{
    void addParticuler(Particulier particulier);

    void updateParticulier(Particulier particulier , int id);
 
    void removeParticulierById(int id);
   
    Particulier findPannierById(int id); 
}
