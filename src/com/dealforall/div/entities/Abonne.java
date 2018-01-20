/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dealforall.div.entities;

/**
 *
 * @author reznov
 */
public class Abonne extends User{
    protected int type;

    public Abonne(){};
    public Abonne(int type, int idUser, String nom, String prenom, String email, String adresse, String tel, String profile_pic, int points, int badge) {
        super(idUser, nom, prenom, email, adresse, tel, profile_pic, points, badge);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Abonne{" + super.toString() + " type=" + type + '}';
    }
    
    
}
