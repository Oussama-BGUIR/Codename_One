package pidev.entities;

import com.codename1.util.BigDecimal;

public class Menu {
    private int id  ;
    private int  calorie ;
    private int  disponibilite ;
    private String nom;
    private String description;

    //constructeur par défaut
    public Menu() {
    }

    public Menu(int calorie, int disponibilite, String nom, String description) {
        this.calorie = calorie;
        this.disponibilite = disponibilite;
        this.nom = nom;
        this.description = description;
    }


    //constructeur parametré
    public Menu(int id, String nom, String description, int calorie , int disponibilite) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.calorie = calorie;
        this.disponibilite = disponibilite;
    }

    //constructeur sans id
    public Menu(String nom, String description) {
        this.nom = nom;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getCalorie() {
    return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    } 
    
    public int getDisponibilite() {
    return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    
    

    @Override
    public String toString() {
        return "menuRepository{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", calorie=" + calorie + ", disponibilite=" + disponibilite +'}';
    }




}
