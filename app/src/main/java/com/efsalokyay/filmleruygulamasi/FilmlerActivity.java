package com.efsalokyay.filmleruygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;

    private Veritabani vt;

    private Kategoriler kategoriler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);

        toolbar = findViewById(R.id.filmler_toolbar);
        recyclerView = findViewById(R.id.filmler_recycler_view);

        vt = new Veritabani(this);

        kategoriler = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        toolbar.setTitle(kategoriler.getKategori_ad());
        setSupportActionBar(toolbar);

        filmlerArrayList = new FilmlerDao().tumFilmlerByKategoriId(vt, kategoriler.getKategori_id());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new FilmlerAdapter(this, filmlerArrayList);

        recyclerView.setAdapter(adapter);
    }
}
