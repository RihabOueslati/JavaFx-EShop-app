/*
 *   Deal For All is a Deal For All Inc. is a Tunisian multinational corporation and e-commerce company,
     providing consumer-to-consumer and business-to-consumer sales Reclamations via the internet.
      
      This project is realized by DivTeam Team is an group of 4 persons :Oueslati Rihab, TakTak Abedlhafidh ,Ouertani Med Firas
    Nasr Med Hedi . This group is associate to 3A3 , ESPRIT from Tunisia.
 */
package com.dealforall.div.entities;
 
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Reclamation {

	

	/**
	 * 
	 */
	private int id;
        private int id_utilisateur;
	/**
	 * 
	 */
	private String type;

	/**
	 * 
	 */
	private String contenu;

	/**
	 * 
	 */
	
	/**
	 * 
	 */
	

	/**
	 * 
	 */
	private Date date;
        
      
	/**
	 * 
	 */
	



        /**
	 * Default constructor
	 */
	public Reclamation() {
	}

        public Reclamation(int id, String type, String contenu, Date date,int id_utilisateur) {
            this.id = id;
            this.type = type;
            this.contenu = contenu;
            this.date = date;
            this.id_utilisateur=id_utilisateur;
            
        }

        public int getId() {
            return id;
        }
         public int getId_utilisateur() {
            return id_utilisateur;
        }
        public void setId_utilisateur(int id_utilisateur) {
            this.id_utilisateur = id_utilisateur;
        }
        public String getType() {
            return type;
        }

        public String getContenu() {
            return contenu;
        }

       
        public Date getDate() {
            return date;
        }

        
    
        
        
        public void setId(int id) {
            this.id = id;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setContenu(String contenu) {
            this.contenu = contenu;
        }

       

        public void setDate(Date date) {
            this.date = date;
        }

       
        @Override
        public String toString() {
            return "Reclamation{" + "id=" + id + ", type=" + type + ", contenu=" + contenu + ", date=" + date +'}';
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.type);
            hash = 79 * hash + Objects.hashCode(this.contenu);
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
            final Reclamation other = (Reclamation) obj;
            if (this.id != other.id) {
                return false;
            }
            if (!Objects.equals(this.type, other.type)) {
                return false;
            }
            if (!Objects.equals(this.contenu, other.contenu)) {
                return false;
            }
           
            if (!Objects.equals(this.date, other.date)) {
                return false;
            }
            
            return true;
        }

 
	/**
	 * 
	 */
	public void ExposerReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void ModifierReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void ConsulterReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void RechercherReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void RendreReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void SupprimerReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void CommenterReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void EvaluerReclamation() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void RepondreAppelOffre() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void ConsulterOffre() {
		// TODO implement here
	}

 

}