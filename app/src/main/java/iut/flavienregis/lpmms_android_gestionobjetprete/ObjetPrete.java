package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.graphics.Bitmap;

public class ObjetPrete {

    private String designation;

    private String description;

    private Bitmap photo;

    private String date;

    private String nom;

    private String prenom;

    private String telephonne;

    private String infoSupp;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getTelephonne() {
        return telephonne;
    }

    public void setTelephonne(String telephonne) {
        this.telephonne = telephonne;
    }

    public String getInfoSupp() {
        return infoSupp;
    }

    public void setInfoSupp(String infoSupp) {
        this.infoSupp = infoSupp;
    }
}
