package tps.application_transportgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityMenu extends AppCompatActivity {
    private Button buttonPropose, buttonDeconnect, buttonConsult ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonDeconnect = (Button) findViewById(R.id.buttonDeconnect);
        buttonPropose   = (Button) findViewById(R.id.buttonPropose);
        buttonConsult   = (Button) findViewById(R.id.buttonConsulter);

        buttonDeconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentHome);
            }
        });
        buttonPropose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFormul = new Intent(getApplicationContext(), ActivityFormulaire.class);
                startActivity(intentFormul);
            }
        });
        buttonConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOffre = new Intent(getApplicationContext(), ActivityOffre.class);
                startActivity(intentOffre);
            }
        });
    }
}
