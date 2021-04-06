package com.example.exercise035;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TampilanKontak extends AppCompatActivity {
    TextView tvNama, tvNomor;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_kontak);

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("a");

        tvNama = (TextView) findViewById(R.id.tvNamaKontak);
        tvNomor = (TextView) findViewById(R.id.tvNomorTelepon);

        //Membuatfungsi untuk mengatur textview nama dan nomor telepon berdasarkan pesan yang dikirimkan dari activity sebelumnya
        switch (nama)
        {
            case "Sekar":
                tvNama.setText("Sekar Putri Retno");
                tvNomor.setText("0822xxxxxxxx");
                break;
            case "Yasmina":
                tvNama.setText("Yasmina A.A");
                tvNomor.setText("0853xxxxxxxx");
                break;
            case "Rio" :
                tvNama.setText("Rio A. A");
                tvNomor.setText("0812xxxxxxxx");
                break;
            case "Fadhillah" :
                tvNama.setText("Fadhillah R. S");
                tvNomor.setText("0896xxxxxxxx");
                break;
            case"Arip":
                tvNama.setText("M. Arip");
                tvNomor.setText("0812xxxxxxxx");
                break;
            case "Anisa":
                tvNama.setText("Anisa .N .A");
                tvNomor.setText("0852xxxxxxxx");
                break;
            case "Denise":
                tvNama.setText("Denise N. N");
                tvNomor.setText("0853xxxxxxxx");
                break;
            case "Adellia":
                tvNama.setText("Adelia P. A");
                tvNomor.setText("0812xxxxxxxx");
                break;
            case "Bima":
                tvNama.setText("Bima B. S");
                tvNomor.setText("0896xxxxxxxx");
                break;
            case "Sisilia":
                tvNama.setText("Sisilia I. L");
                tvNomor.setText("0823xxxxxxxx");
                break;
        }
    }
}