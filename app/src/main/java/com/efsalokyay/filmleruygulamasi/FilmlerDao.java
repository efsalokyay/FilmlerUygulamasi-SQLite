package com.efsalokyay.filmleruygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FilmlerDao {

    public ArrayList<Filmler> tumFilmlerByKategoriId(Veritabani vt, int kategori_id) {

        ArrayList<Filmler> filmlerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kategoriler,filmler,yonetmenler WHERE filmler.kategori_id = kategoriler.kategori_id and filmler.yonetmen_id = yonetmenler.yonetmen_id and filmler.kategori_id=" + kategori_id, null);

        while (cursor.moveToNext()) {
            Kategoriler k = new Kategoriler(
                    cursor.getInt(cursor.getColumnIndex("kategori_id")),
                    cursor.getString(cursor.getColumnIndex("kategori_ad"))
            );

            Yonetmenler y = new Yonetmenler(
                    cursor.getInt(cursor.getColumnIndex("yonetmen_id")),
                    cursor.getString(cursor.getColumnIndex("yonetmen_ad"))
            );

            Filmler f = new Filmler(
                    cursor.getInt(cursor.getColumnIndex("film_id")),
                    cursor.getString(cursor.getColumnIndex("film_ad")),
                    cursor.getInt(cursor.getColumnIndex("film_yil")),
                    cursor.getString(cursor.getColumnIndex("film_resim")),
                    k, y
            );
            filmlerArrayList.add(f);
        }
        return filmlerArrayList;
    }
}
