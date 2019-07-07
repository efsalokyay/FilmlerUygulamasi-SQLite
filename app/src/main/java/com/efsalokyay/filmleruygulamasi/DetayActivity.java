package com.efsalokyay.filmleruygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {

    private ImageView film_resim;
    private TextView film_ad;
    private TextView film_yil;
    private TextView film_yonetmen;

    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        film_resim = findViewById(R.id.detay_resim_image_view);
        film_ad = findViewById(R.id.detay_film_ad_text);
        film_yil = findViewById(R.id.detay_yil_text);
        film_yonetmen = findViewById(R.id.detay_yonetmen_text);

        film = (Filmler) getIntent().getSerializableExtra("nesne");

        film_ad.setText(film.getFilm_ad());
        film_yil.setText(String.valueOf(film.getFilm_yil()));
        film_yonetmen.setText(film.getYonetmen().getYonetmen_ad());

        film_resim.setImageResource(getResources().getIdentifier(film.getFilm_resim(), "drawable", getPackageName()));
    }
}
