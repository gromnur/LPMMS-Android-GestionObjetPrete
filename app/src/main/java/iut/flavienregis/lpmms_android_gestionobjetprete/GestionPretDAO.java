package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GestionPretDAO {

    private static GestionPretDAO instanceDAO;

    private static final int VERSION = 1;

    private static final String NOM_BD = "pret.db";

    private GestionBDPret gestionnaireBase;

    private SQLiteDatabase base;

    private GestionPretDAO(Context context) {
        gestionnaireBase = GestionBDPret.getInstance(context, NOM_BD, null, VERSION);
        base = gestionnaireBase.getWritableDatabase();
    }

    public static synchronized GestionPretDAO getInstanceDAO(Context context) {
        if (instanceDAO == null) {
            instanceDAO = new GestionPretDAO(context);
        }
        return instanceDAO;
    }

    public Cursor toutSelectionner() {
        return base.rawQuery(GestionBDPret.REQUETTE_TOUT_SELECTIONNER_PRET, null);
    }

    public int createPret(String designation, String description, String photo, String nom, String prenom, String infoSupp) {
        ContentValues enregistrement = new ContentValues();


        enregistrement.put(GestionBDPret.PRET_DESIGNATION, designation);
        enregistrement.put(GestionBDPret.PRET_DESCRIPTION, description);
        enregistrement.put(GestionBDPret.PRET_NOM, nom);
        enregistrement.put(GestionBDPret.PRET_PRENOM, prenom);

        return 0;
    }

    public int deletePret(int id) {
        return 0;
    }

    public int findByIdPret(int id) {
        return 0;
    }
}
