package tps.application_transportgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityFormulaire extends AppCompatActivity {
    FormulProposeSQLiteHelper myDb2;
    Button buttonValider2;
    EditText et_nom, et_prenom, et_modele, et_couleur, et_immatri, et_lieuRV, et_destiRV, et_heureRV, et_nbrPlaces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formull_propose);
        et_nom = (EditText) findViewById(R.id.et_Nom);
        et_prenom = (EditText) findViewById(R.id.et_Prenom);
        et_modele = (EditText) findViewById(R.id.et_Modele);
        et_couleur = (EditText) findViewById(R.id.et_Couleur);
        et_immatri = (EditText) findViewById(R.id.et_Immatri);
        et_lieuRV = (EditText) findViewById(R.id.et_Lieu);
        et_destiRV = (EditText) findViewById(R.id.et_Destination);
        et_heureRV = (EditText) findViewById(R.id.et_HeureRV);
        et_nbrPlaces = (EditText) findViewById(R.id.et_NbrPlace);
        buttonValider2 = (Button) findViewById(R.id.buttonValider2);

        buttonValider2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNom = et_nom.getText().toString();
                String getPrenom = et_prenom.getText().toString();
                String getModele = et_modele.getText().toString();
                String getCouleur = et_couleur.getText().toString();
                String getImmatri = et_immatri.getText().toString();
                String getLieuRV = et_lieuRV.getText().toString();
                String getDestiRV = et_destiRV.getText().toString();
                String getHeureRV = et_heureRV.getText().toString();
                String getNbrPlaces = et_nbrPlaces.getText().toString();
                try {
                    boolean addOK = myDb2.addInfoPropose(getNom, getPrenom, getModele, getCouleur, getImmatri, getLieuRV, getDestiRV, getHeureRV, getNbrPlaces);
                    Toast.makeText(ActivityFormulaire.this, "info adjouter OK =" + addOK, Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(ActivityFormulaire.this, "Erreur! " ,  Toast.LENGTH_SHORT).show();
                }
                Intent intentValiderOK = new Intent(getApplicationContext(), ActivityValiderOffre.class);
                startActivity(intentValiderOK);
            }
        });
    }
}
