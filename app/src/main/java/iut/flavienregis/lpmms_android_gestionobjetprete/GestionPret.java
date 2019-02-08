package iut.flavienregis.lpmms_android_gestionobjetprete;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GestionPret extends SQLiteOpenHelper {

    private static GestionPret instancePret = null
            ;

    public static final String PRET_CLE = "_id";

    public static final String PRET_DESIGNATION = "designation";

    public static final String PRET_DESCRIPTION = "description";

    public static final String PRET_PHOTO = "photo";

    public static final String PRET_DATE = "date";

    public static final String PRET_NOM = "nom";

    public static final String PRET_PRENOM = "prenom";

    public static final String PRET_TEL = "telephonne";

    public static final String PRET_INFO_SUPP = "infoSupp";

    public static final String NOM_TABLE_PRET = "tablePret";

    public static final String REQUETTE_TOUT_SELECTIONNER_PRET =
            "select "
                    + PRET_CLE + ", "
                    + PRET_DESIGNATION + ", "
                    + PRET_DESCRIPTION + ", "
                    + PRET_PHOTO + ", "
                    + PRET_DATE + ", "
                    + PRET_NOM + ", "
                    + PRET_PRENOM + ", "
                    + PRET_TEL + ", "
                    + PRET_INFO_SUPP
                    + " from " + NOM_TABLE_PRET
                    + " order by " + PRET_DATE + " desc";

    public static final String CREATION_TABLE_PRET =
            "Create table " + NOM_TABLE_PRET + " ( "
                    + PRET_CLE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + PRET_DESIGNATION + " VARCHAR(256) NOT NULL, "
                    + PRET_DESCRIPTION + " VARCHAR(256), "
                    + PRET_PHOTO + " BLOB, "
                    + PRET_DATE + " DATE NOT NULL, "
                    + PRET_NOM + " VARCHAR(256) NOT NULL, "
                    + PRET_PRENOM + " VARCHAR(256) NOT NULL, "
                    + PRET_TEL + " INTEGER(10), "
                    + PRET_INFO_SUPP + " BLOB "
                    + ");";

    public static final String SUPRESSION_TABLE_PRET =
            "DROP TABLE IF EXISTS " + NOM_TABLE_PRET + " ;";


    private GestionPret(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized GestionPret getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        if (instancePret == null) {
            instancePret = new GestionPret(context, name, factory, version);
        }

        return instancePret;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATION_TABLE_PRET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SUPRESSION_TABLE_PRET);
        onCreate(db);
    }
}
