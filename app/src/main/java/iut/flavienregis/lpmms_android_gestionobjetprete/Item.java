package iut.flavienregis.lpmms_android_gestionobjetprete;

public class Item {
    int id;
    String designation;
    String description;
    String date;
    String thumbnail;
    String nom;
    String prenom;
    String commentaire;

    public Item(int id, String designation, String description, String date, String thumbnail, String nom, String prenom, String commentaire) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.date = date;
        this.thumbnail = thumbnail;
        this.nom = nom;
        this.prenom = prenom;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
