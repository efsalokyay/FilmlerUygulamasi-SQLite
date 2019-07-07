package com.efsalokyay.filmleruygulamasi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu> {

    private Context mContext;
    private List<Filmler> filmlerListe;

    public FilmlerAdapter(Context mContext, List<Filmler> filmlerListe) {
        this.mContext = mContext;
        this.filmlerListe = filmlerListe;
    }

    @NonNull
    @Override
    public FilmlerAdapter.CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.film_card_tasarim, viewGroup, false);

        return new FilmlerAdapter.CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmlerAdapter.CardTasarimTutucu cardTasarimTutucu, int i) {

        final Filmler film = filmlerListe.get(i);

        cardTasarimTutucu.film_isim_text.setText(film.getFilm_ad());

        cardTasarimTutucu.film_resim.setImageResource(mContext.getResources().getIdentifier(film.getFilm_resim(), "drawable", mContext.getPackageName()));

        cardTasarimTutucu.film_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivity.class);
                intent.putExtra("nesne", film);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmlerListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {

        private CardView film_card;
        private TextView film_isim_text;
        private ImageView film_resim;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            film_card = itemView.findViewById(R.id.film_card);
            film_isim_text = itemView.findViewById(R.id.film_isim_text);
            film_resim = itemView.findViewById(R.id.film_resim_image_view);
        }
    }
}
