package tps.application_transportgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityCreateAcc extends AppCompatActivity {
    ConducteurSQLiteHelper myDb;
    Button buttonCancel, buttonValider;
    EditText et_nom, et_prenom, et_telephone, et_email, et_login, et_password, et_pw_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonValider = (Button) findViewById(R.id.buttonValider2);
        et_nom = (EditText) findViewById(R.id.et_Nom);
        et_prenom = (EditText) findViewById(R.id.et_Prenom);
        et_telephone = (EditText) findViewById(R.id.et_Modele);
        et_email = (EditText) findViewById(R.id.et_Couleur);
        et_login = (EditText) findViewById(R.id.et_Immatri);
        et_password = (EditText) findViewById(R.id.et_Lieu);
        et_pw_confirm = (EditText) findViewById(R.id.et_Destination);

        myDb = new ConducteurSQLiteHelper(this);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentHome);
            }
        });

        buttonValider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String getNom = et_nom.getText().toString();
                String getPrenom = et_prenom.getText().toString();
                String getTelephone = et_telephone.getText().toString();
                String getEmail = et_email.getText().toString();
                String getLogin = et_login.getText().toString();
                String getPassword = et_password.getText().toString();
                String getPwConfiirm = et_pw_confirm.getText().toString();

                //verifier si mot de passe confirmation ok
                try {
                    if (!getPwConfiirm.equals(getPassword)) {
                        Toast.makeText(ActivityCreateAcc.this, "Erreur: mot de pass doit être le même ", Toast.LENGTH_SHORT).show();
                    }
                    //verifier si mot de passe confirmation ok
                    else if (!getTelephone.equals(Integer.parseInt(getTelephone))) {
                        Toast.makeText(ActivityCreateAcc.this, "Erreur: Telephone format numeric ", Toast.LENGTH_SHORT).show();
                    } else {
                        //Entre nouveax base de données
                        boolean addOK = myDb.addInfo(getNom, getPrenom, getTelephone, getEmail, getLogin, getPassword);
                        Toast.makeText(ActivityCreateAcc.this, "info adjouter OK =" + addOK, Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(ActivityCreateAcc.this, "Erreur:", Toast.LENGTH_SHORT).show();
                }
                Intent intentHome2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentHome2);
            }
        });
    }
}
