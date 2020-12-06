package tps.application_transportgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText loginName, loginPassword;
    private Button connect, createAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginName = (EditText) findViewById(R.id.editTextLoginName);
        loginPassword = (EditText) findViewById(R.id.editTextPassword);
        connect = (Button) findViewById(R.id.buttonConnect);
        createAcc = (Button) findViewById(R.id.buttonCreateAcc);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection(loginName.getText().toString(), loginPassword.getText().toString());
            }
        });
        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void connection(String name, String password) {
        if(name.equals("Yourname") && password.equals("123456")){
            Intent connectIntent = new Intent(getApplicationContext(), ActivityMenu.class);
            startActivity(connectIntent);
        }else{
            Toast.makeText(getApplicationContext(), "login et mot de passe invalid", Toast.LENGTH_SHORT).show();
        }

    }
    private void createAccount() {
        Intent createAccIntent = new Intent(getApplicationContext(), ActivityCreateAcc.class);
        startActivity(createAccIntent);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
