package com.example.ps08209duanmau.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ps08209duanmau.DAO.HoadonDAO;
import com.example.ps08209duanmau.DAO.HoadonchitietDAO;
import com.example.ps08209duanmau.DAO.NguoiDungDAO;
import com.example.ps08209duanmau.DAO.SachDAO;
import com.example.ps08209duanmau.DAO.TheloaiDAO;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheloaiDAO.SQL_THE_LOAI);
        db.execSQL(SachDAO.SQL_SACH);
        db.execSQL(HoadonDAO.SQL_HOA_DON);
        db.execSQL(HoadonchitietDAO.SQL_HOA_DON_CHI_TIET);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+NguoiDungDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+TheloaiDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+SachDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoadonDAO.TABLE_NAME);
        db.execSQL("Drop table if exists "+HoadonchitietDAO.TABLE_NAME);

        onCreate(db);
    }
}

