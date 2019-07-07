package com.efsalokyay.filmleruygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;

    private Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.kategori_recycler_view);

        veritabaniKopyala();

        vt = new Veritabani(this);

        toolbar.setTitle("Kategoriler");
        setSupportActionBar(toolbar);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new KategoriDao().tumKategoriler(vt);

        adapter = new KategoriAdapter(this, kategorilerArrayList);
        recyclerView.setAdapter(adapter);
    }

    public void veritabaniKopyala() {
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        helper.openDataBase();
    }
}
