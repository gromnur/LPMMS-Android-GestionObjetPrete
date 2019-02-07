package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public int createPret(String designation, String description, String photo, String nom, String prenom, String infoSupp) {
        ContentValues enregistrement = new ContentValues();


        String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

        enregistrement.put(GestionPret.PRET_DESIGNATION, designation);
        enregistrement.put(GestionPret.PRET_DESCRIPTION, description);
        enregistrement.put(GestionPret.PRET_NOM, nom);
        enregistrement.put(GestionPret.PRET_PRENOM, prenom);
        enregistrement.put(GestionPret.PRET_DATE, timeStamp);

        return 0;
    }

    public int deletePret(int id) {
        base.delete(GestionPret.NOM_TABLE_PRET, GestionPret.PRET_CLE +  " = ? ", new String[]{String.valueOf(id)} );
        return id;
    }

    public int findByIdPret(int id) {
        return 0;
    }

    public int findByDesignationPret(int designation) {
        return 0;
    }
}
