package com.efsalokyay.filmleruygulamasi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu> {

    private Context mContext;
    private List<Kategoriler> kategorilerListe;

    public KategoriAdapter(Context mContext, List<Kategoriler> kategorilerListe) {
        this.mContext = mContext;
        this.kategorilerListe = kategorilerListe;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.kategori_card_tasarim, viewGroup, false);

        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu cardTasarimTutucu, int i) {

        final Kategoriler kategori = kategorilerListe.get(i);

        cardTasarimTutucu.kategori_ad_text.setText(kategori.getKategori_ad());

        cardTasarimTutucu.kategori_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FilmlerActivity.class);
                intent.putExtra("kategori_nesne", kategori);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategorilerListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {

        private CardView kategori_card;
        private TextView kategori_ad_text;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            kategori_card = itemView.findViewById(R.id.kategori_card);
            kategori_ad_text = itemView.findViewById(R.id.kategori_ad_text);
        }
    }
}
