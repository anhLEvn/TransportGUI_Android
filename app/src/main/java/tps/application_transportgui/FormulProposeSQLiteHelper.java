package tps.application_transportgui;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FormulProposeSQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "formul_propose.db";
    public static final int DATABASE_VERSION = 01;
    public static final String TABLE_NAME = "formul_propose";

    public static final String ID = "ID";
    public static final String CONDUCTEURS_NOM = "NOM";
    public static final String CONDUCTEURS_PRENOM = "PRENOM";
    public static final String VEHICUL_MODEL = "MODELE";
    public static final String VEHICULE_COULEUR = "COULEUR";
    public static final String VEHICULE_IMMATRI = "IMMATRICULATION";
    public static final String LIEU_RV = "LIEU de RV";
    public static final String HEURE_RV = "HEURE de RV";
    public static final String DESTI_RV = "HEURE de RV";
    public static final String NBR_PLACES = "NOMBRE PLACES";

    public FormulProposeSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 01);
    }

    private static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + CONDUCTEURS_NOM + " TEXT, " + CONDUCTEURS_PRENOM + " TEXT, " + VEHICUL_MODEL + " TEXT, " + VEHICULE_COULEUR + " TEXT," +
            " " + VEHICULE_IMMATRI + " TEXT, " + LIEU_RV + " TEXT," + DESTI_RV + " TEXT, " + HEURE_RV + " TEXT, " + NBR_PLACES + " TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addInfoPropose(String nomConducteur,
                                  String prenomConducteur,
                                  String nomVehicule,
                                  String couleurVehicule,
                                  String immatriVehicule,
                                  String lieuRV,
                                  String destiRV,
                                  String heureRV,
                                  String nbrPlaces) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CONDUCTEURS_NOM, nomConducteur);
        cv.put(CONDUCTEURS_PRENOM, prenomConducteur);
        cv.put(VEHICUL_MODEL, nomVehicule);
        cv.put(VEHICULE_COULEUR, couleurVehicule);
        cv.put(VEHICULE_IMMATRI, immatriVehicule);
        cv.put(LIEU_RV, lieuRV);
        cv.put(DESTI_RV, destiRV);
        cv.put(HEURE_RV, heureRV);
        cv.put(NBR_PLACES, nbrPlaces);

        long insert = db.insert(TABLE_NAME, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}
