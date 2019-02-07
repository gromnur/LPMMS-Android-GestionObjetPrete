package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
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

    protected Item(Parcel in) {
        id = in.readInt();
        designation = in.readString();
        description = in.readString();
        date = in.readString();
        thumbnail = in.readString();
        nom = in.readString();
        prenom = in.readString();
        commentaire = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(id);
        parcel.writeString(designation);
        parcel.writeString(description);
        parcel.writeString(date);
        parcel.writeString(thumbnail);
        parcel.writeString(nom);
        parcel.writeString(prenom);
        parcel.writeString(commentaire);

    }
}
