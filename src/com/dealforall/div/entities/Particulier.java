/*
 *   Deal For All is a Deal For All Inc. is a Tunisian multinational corporation and e-commerce company,
     providing consumer-to-consumer and business-to-consumer sales services via the internet.
      
      This project is realized by DivTeam Team is an group of 5 persons :Bouzid Med Taher , TakTak Abedlhafidh ,Ouertani Med Firas
    Nasr Med Hedi and Nasri Souha  . This group is associate to 3A3 , ESPRIT from Tunisia.
 */
package com.dealforall.div.entities;
import java.util.*;

/**
 * 
 */
public class Particulier {

	
        private int Id;
	/**
	 * 
	 */
	private String Nom;

	/**
	 * 
	 */
	private String Prenom;

	/**
	 * 
	 */
	private int Age;

	/**
	 * 
	 */
	private Date DateDeNaissance;

	/**
	 * 
	 */
	private enum GenreUser{Masculin,Feminin};

	/**
	 * 
	 */
	private enum TypeUser {Particulier,Entreprise};

	/**
	 * 
	 */
	private String Adresse;

	/**
	 * 
	 */
	private String Login;

	/**
	 * 
	 */
	private String Password;

	/**
	 * 
	 */
        
        
        /**
	 * Default constructor
	 */
	public Particulier() {
	}

        public Particulier(int Id,String Nom, String Prenom, int Age, Date DateDeNaissance, String Adresse, String Login, String Password) {
            this.Nom = Nom;
            this.Prenom = Prenom;
            this.Age = Age;
            this.DateDeNaissance = DateDeNaissance;
            this.Adresse = Adresse;
            this.Login = Login;
            this.Password = Password;
        }

        public String getNom() {
            return Nom;
        }

        public void setNom(String Id) {
            this.Nom = Nom;
        }
        public int getID() {
            return Id;
        }

        public void setID(int Id) {
            this.Id = Id;
        }

        public String getPrenom() {
            return Prenom;
        }

        public void setPrenom(String Prenom) {
            this.Prenom = Prenom;
        }

        public int getAge() {
            return Age;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public Date getDateDeNaissance() {
            return DateDeNaissance;
        }

        public void setDateDeNaissance(Date DateDeNaissance) {
            this.DateDeNaissance = DateDeNaissance;
        }

        public String getAdresse() {
            return Adresse;
        }

        public void setAdresse(String Adresse) {
            this.Adresse = Adresse;
        }

        public String getLogin() {
            return Login;
        }

        public void setLogin(String Login) {
            this.Login = Login;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }

        @Override
        public String toString() {
            return "Particulier{" + "Nom=" + Nom + ", Prenom=" + Prenom + ", Age=" + Age + ", DateDeNaissance=" + DateDeNaissance + ", Adresse=" + Adresse + ", Login=" + Login + ", Password=" + Password + '}';
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + Objects.hashCode(this.Nom);
            hash = 97 * hash + this.Age;
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
            final Particulier other = (Particulier) obj;
            if (!Objects.equals(this.Nom, other.Nom)) {
                return false;
            }
            if (!Objects.equals(this.Prenom, other.Prenom)) {
                return false;
            }
            if (this.Age != other.Age) {
                return false;
            }
            if (!Objects.equals(this.DateDeNaissance, other.DateDeNaissance)) {
                return false;
            }
            return true;
        }

        
	public void ModifierCompte() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void DeseactiverCompte() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void SupprimerCompte() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void AjouterEmploye() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void ModifierEmploye() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void SupprimerEmploye() {
		// TODO implement here
	}

}