/*
 *   Deal For All is a Deal For All Inc. is a Tunisian multinational corporation and e-commerce company,
     providing consumer-to-consumer and business-to-consumer sales services via the internet.
      
      This project is realized by DivTeam Team is an group of 4 persons :Oueslati Rihab , TakTak Abedlhafidh ,Ouertani Med Firas
    Nasr Med Hedi  . This group is associate to 3A3 , ESPRIT from Tunisia.
 */
package com.dealforall.div.entities;
import java.awt.Image;
import java.util.*;

/**
 * 
 */
public class Publicite {

	

	/**
	 * 
	 */
	private int IdPub;

	/**
	 * 
	 */
	private String Nom;

	/**
	 * 
	 */
	private String Information;

	/**
	 * 
	 */
	private Image Image;


        /**
	 * Default constructor
	 */
	public Publicite() {
	}

        public Publicite(int IdPub, String Nom, String Information, Image Image) {
            this.IdPub = IdPub;
            this.Nom = Nom;
            this.Information = Information;
            this.Image = Image;
        }

        public int getIdPub() {
            return IdPub;
        }

        public void setIdPub(int IdPub) {
            this.IdPub = IdPub;
        }

        public String getNom() {
            return Nom;
        }

        public void setNom(String Nom) {
            this.Nom = Nom;
        }

        public String getInformation() {
            return Information;
        }

        public void setInformation(String Information) {
            this.Information = Information;
        }

        public Image getImage() {
            return Image;
        }

        public void setImage(Image Image) {
            this.Image = Image;
        }

        @Override
        public String toString() {
            return "Publicite{" + "IdPub=" + IdPub + ", Nom=" + Nom + ", Information=" + Information + ", Image=" + Image + '}';
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + Objects.hashCode(this.Nom);
            hash = 97 * hash + Objects.hashCode(this.Information);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Publicite other = (Publicite) obj;
            if (!Objects.equals(this.Nom, other.Nom)) {
                return false;
            }
            if (!Objects.equals(this.Information, other.Information)) {
                return false;
            }
            if (!Objects.equals(this.Image, other.Image)) {
                return false;
            }
            return true;
        }

        
	/**
	 * 
	 */
	public void ProposerPublicite() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void ModifierPublicite() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void Operation1() {
		// TODO implement here
	}

}