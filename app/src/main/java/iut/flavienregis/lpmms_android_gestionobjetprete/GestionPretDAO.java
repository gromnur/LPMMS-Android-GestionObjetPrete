package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GestionPretDAO {

    private static GestionPretDAO instanceDAO;

    private static final int VERSION = 1;

    private static final String NOM_BD = "pret.db";

    private GestionPret gestionnaireBase;

    private SQLiteDatabase base;

    private GestionPretDAO(Context context) {

        gestionnaireBase = GestionPret.getInstance(context, NOM_BD, null, VERSION);
        base = gestionnaireBase.getWritableDatabase();
    }

    public static synchronized GestionPretDAO getInstanceDAO(Context context) {
        if (instanceDAO == null) {
            instanceDAO = new GestionPretDAO(context);
        }
        return instanceDAO;
    }

    public Cursor toutSelectionner() {
        return base.rawQuery(GestionPret.REQUETTE_TOUT_SELECTIONNER_PRET, null);
    }

    public int createPret(String designation, String description, byte[] photo, String nom, String prenom, String infoSupp) {
        ContentValues enregistrement = new ContentValues();

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        enregistrement.put(GestionPret.PRET_DESIGNATION, designation);
        enregistrement.put(GestionPret.PRET_DESCRIPTION, description);
        enregistrement.put(GestionPret.PRET_NOM, nom);
        enregistrement.put(GestionPret.PRET_PRENOM, prenom);
        enregistrement.put(GestionPret.PRET_DATE, timeStamp);
        enregistrement.put(GestionPret.PRET_INFO_SUPP, infoSupp);
        enregistrement.put(GestionPret.PRET_PHOTO, photo);


        return (int) base.insert(GestionPret.NOM_TABLE_PRET, GestionPret.PRET_DESIGNATION, enregistrement);
    }

    public int deletePret(int id) {
        base.delete(GestionPret.NOM_TABLE_PRET, GestionPret.PRET_CLE +  " = ? ", new String[]{String.valueOf(id)} );
        return id;
    }

    public int updatePret(int id, String designation, String description, byte[] photo, String nom, String prenom, String infoSupp, String date) {

        ContentValues enregistrement = new ContentValues();

        enregistrement.put(GestionPret.PRET_DESIGNATION, designation);
        enregistrement.put(GestionPret.PRET_DESCRIPTION, description);
        enregistrement.put(GestionPret.PRET_NOM, nom);
        enregistrement.put(GestionPret.PRET_PRENOM, prenom);
        enregistrement.put(GestionPret.PRET_DATE, date);
        enregistrement.put(GestionPret.PRET_INFO_SUPP, infoSupp);
        enregistrement.put(GestionPret.PRET_PHOTO, photo);

        return base.update(GestionPret.NOM_TABLE_PRET, enregistrement, GestionPret.PRET_CLE +  " = ? ", new String[]{String.valueOf(id)});
    }


    public Item findByIdPret(String id) {

        Cursor curseur = base.rawQuery("select * from " + GestionPret.NOM_TABLE_PRET + " where _id = ? ", new String[]{String.valueOf(id)});
        Item item = new Item();

        while (curseur.moveToNext()) {
            item = new Item(curseur.getInt(0), // id
                    curseur.getString(1), // desi
                    curseur.getString(2), // desci
                    curseur.getString(4), // date
                    curseur.getBlob(3), // photo
                    curseur.getString(5), // nom
                    curseur.getString(6), // prenom
                    curseur.getString(8)); // info supp
        }
        curseur.close();
        return item;
    }

    public int findByDesignationPret(int designation) {
        return 0;
    }
}
