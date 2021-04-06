package com.example.exercise035;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

public class DataKontak extends AppCompatActivity {
    private ListView list;
    private ListViewAdapter adapter;
    String[] listNama;
    public static ArrayList<ClassNama>classNamaArrayList = new ArrayList();
    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kontak);

        listNama = new String[]{"Sekar", "Yasmina", "Rio", "Fadhillah","Arip", "Anisa", "Denise", "Adellia", "Bima", "Sisilia"};
        list = findViewById(R.id.ListKontak);
        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listNama.length; i++) {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getNama();
                bundle.putString("a", nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }
}