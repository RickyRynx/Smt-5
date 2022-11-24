package com.if51.buku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBuku;
    MyDatabaseHelper myDB;
    AdapterBuku adapterBuku;
    ArrayList<String> arrJudul, arrPenulis, arrTahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new MyDatabaseHelper(MainActivity.this);

        arrJudul = new ArrayList<>();
        arrPenulis = new ArrayList<>();
        arrTahun = new ArrayList<>();

        SQLiteToArrayList();

        rvBuku = findViewById(R.id.rv_buku);
        adapterBuku = new AdapterBuku(MainActivity.this,arrJudul,arrPenulis,arrTahun);
        rvBuku.setAdapter(adapterBuku);
        rvBuku.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    public void bukaActivityTambah(View view) {
        startActivity(new Intent(MainActivity.this, TambahActivity.class));

    }

    private void SQLiteToArrayList() {
        Cursor cursor = myDB.bacaSemuaData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()) {
                arrJudul.add(cursor.getString(1));
                arrPenulis.add(cursor.getString(2));
                arrTahun.add(cursor.getString(3));
            }
        }
    }
}