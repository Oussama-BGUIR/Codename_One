/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author shini
 */
public class Fiche {
      private int id;
    private String nom;
    private String prenom;
     private int numtel;
    private String email;
    private String description;
    
    
public Fiche() {
    }


    //constructeur parametré
    public Fiche(int id, String nom, String prenom, String email, String description, int numtel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
         this.email = email;
          this.description = description;
    }

    public Fiche(String nom, String prenom, int numtel, String email, String description) {
        this.nom = nom;
        this.prenom = prenom;
        this.numtel = numtel;
        this.email = email;
        this.description = description;
    }

    //constructeur sans id
    public Fiche(String nom, String prenom, String email, String description) {
        this.nom = nom;
         this.prenom = prenom;
       
         this.email = email;
          this.description = description;
    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
     public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getDescription() {
        return description;
    }

    public void setDescription(String type) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Fiche{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ",numtel=" + numtel +",email=" + email + ", description=" + description + '}' ;
    }




}

