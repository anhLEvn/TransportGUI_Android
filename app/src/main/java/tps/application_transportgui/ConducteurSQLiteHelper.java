package tps.application_transportgui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConducteurSQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "conducteurs.db";
    public static final int DATABASE_VERSION = 01;
    public static final String TABLE_NAME  = "conducteurs";

    public static final String CONDUCTEURS_NOM = "NOM";
    public static final String CONDUCTEURS_PRENOM = "PRENOM";
    public static final String CONDUCTEURS_TELEPHONE = "TELEPHONE";
    public static final String CONDUCTEURS_EMAIL = "EMAIL";
    public static final String CONDUCTEURS_LOGIN = "LOGIN";
    public static final String CONDUCTEURS_PW = "PASSWORD";
    public static final String ID = "ID";

    public ConducteurSQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 01);
    }
    // create la BD
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONDUCTEURS_NOM + " TEXT, " + CONDUCTEURS_PRENOM + " TEXT, " +
            "" + CONDUCTEURS_TELEPHONE + " TEXT, " + CONDUCTEURS_EMAIL + " TEXT, " + CONDUCTEURS_LOGIN + " TEXT, " + CONDUCTEURS_PW + " TEXT  )";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("Drop table if exists " + TABLE_NAME);
    onCreate(db);
    }
    // ajoute des information dans la BD
    public boolean addInfo(String nomConducteur,
             String prenomConducteur,
             String phoneConducteur,
             String emailConducteur,
             String nomLogin,
             String pwConducteur ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CONDUCTEURS_NOM, nomConducteur);
        cv.put(CONDUCTEURS_PRENOM, prenomConducteur);
        cv.put(CONDUCTEURS_TELEPHONE, phoneConducteur );
        cv.put(CONDUCTEURS_EMAIL, emailConducteur);
        cv.put(CONDUCTEURS_LOGIN, nomLogin );
        cv.put(CONDUCTEURS_PW,pwConducteur );

      long insert = db.insert(TABLE_NAME, null, cv);
        if (insert ==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
