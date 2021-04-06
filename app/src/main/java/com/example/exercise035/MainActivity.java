package com.example.exercise035;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Emailid, Passwordid;
    Button submit;
    String Email;
    String Password;
    View BelumDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Emailid = findViewById(R.id.Emailid);
        Passwordid = findViewById(R.id.Passwordid);
        submit = (Button) findViewById(R.id.submit);
        BelumDaftar = findViewById(R.id.Daftar);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = Emailid.getText().toString();
                Password = Passwordid.getText().toString();

                if (Email.equals("sekar@gmail.com") && Password.equals("sekar83")) {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Berhasil LOG-IN, \nEmail : " + Email + "\nPassword : " + Password, Toast.LENGTH_LONG);
                    s.show();
                    Bundle b = new Bundle();
                    b.putString("Parameter1", Email.trim());
                    b.putString("Parameter2", Password.trim());

                    Intent intent = new Intent(MainActivity.this, Pendaftaran.class);
                    intent.putExtras(b);
                    startActivity(new Intent(getApplicationContext(), DataKontak.class ));
                } else if (!Email.equals("sekar@gmail.com") && Password.equals("sekar83")) {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Gagal LOG-IN (Email yang dimasukkan tidak terdaftar)", Toast.LENGTH_LONG);
                    s.show();
                } else if (Email.equals("sekar@gmail.com") && !Password.equals("sekar83")) {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Gagal LOG-IN (Password tidak sesuai)", Toast.LENGTH_LONG);
                    s.show();
                } else {
                    Toast s = Toast.makeText(getApplicationContext(),
                            "Gagal LOG-IN (Email dan Password yang dimasukkan Salah", Toast.LENGTH_LONG);
                    s.show();
                }
            }
        });
        BelumDaftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), Pendaftaran.class));
            }
        });
    }
    public boolean ValidasiData() {
        String EmailActive = "sekar@gmail.com";
        String PasswordActive = "sekar83";
        if (EmailActive.equals(Emailid.getText().toString()) && PasswordActive.equals(Passwordid.getText().toString())) {
            return true;
        }
        return false;
    }
}