package com.efsalokyay.filmleruygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {

    public ArrayList<Kategoriler> tumKategoriler(Veritabani vt) {

        ArrayList<Kategoriler> kategorilerArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM kategoriler", null);

        while (cursor.moveToNext()) {
            Kategoriler k = new Kategoriler(
                    cursor.getInt(cursor.getColumnIndex("kategori_id")),
                    cursor.getString(cursor.getColumnIndex("kategori_ad"))
            );
            kategorilerArrayList.add(k);
        }
        return kategorilerArrayList;
    }
}
