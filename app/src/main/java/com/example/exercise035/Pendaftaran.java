package com.example.exercise035;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);
    }
    public class Menu extends AppCompatActivity {
        EditText Nama, Alamat, Email2, Password2, Password3;
        Button Batal, Daftar;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pendaftaran);

            Nama = findViewById(R.id.Nama);
            Alamat = findViewById(R.id.Alamat);
            Email2 = findViewById(R.id.Email2);
            Password2 = findViewById(R.id.Password2);
            Password3 = findViewById(R.id.Password3);
            Batal = findViewById(R.id.Batal);
            Daftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Nama.getText().toString().isEmpty() ||
                            Alamat.getText().toString().isEmpty() ||
                            Email2.getText().toString().isEmpty() ||
                            Password2.getText().toString().isEmpty() ||
                            Password3.getText().toString().isEmpty()) {
                        Snackbar.make(v, "WAJIB!!! (Mengisikan Seluruh Data)", Snackbar.LENGTH_LONG).show();
                    } else {
                        if (Password2.getText().toString().equals(Password3.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Pendaftaran yang Dilakukan Berhasil",
                                    Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Snackbar.make(v, "Password pertama dan Password kedua harus sama !!!!",
                                    Snackbar.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }
    }
}