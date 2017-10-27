package com.example.lenovo.luanvantotnghiep.Model.GioHang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 10/14/2017.
 */

public class ModelGioHang {

    SQLiteDatabase sqLiteDatabase;

    public void moKetNoi(Context context){
        DBSanPham dbSanPham = new DBSanPham(context);
        sqLiteDatabase = dbSanPham.getWritableDatabase();
    }

    public boolean xoaSanPhamTrongGioHang(String masp){

        int kiemtra = sqLiteDatabase.delete(DBSanPham.TB_GIOHANG,DBSanPham.TB_GIOHANG_MASP+" = '"+masp+"'",null);
        return kiemtra > 0;
    }

    public boolean themGioHang(SanPham sanPham){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSanPham.TB_GIOHANG_MASP,sanPham.getMaSanPham());
        contentValues.put(DBSanPham.TB_GIOHANG_TENSP,sanPham.getTenSanPham());
        contentValues.put(DBSanPham.TB_GIOHANG_GIATIEN,sanPham.getGiaSanPham());
        contentValues.put(DBSanPham.TB_GIOHANG_HINHANH,sanPham.getHinhgiohang());

        long id = sqLiteDatabase.insert(DBSanPham.TB_GIOHANG,null,contentValues);
        return id > 0;
    }

    public List<SanPham> layDSSPTrongGioHang(){
        List<SanPham> sanPhamList = new ArrayList<>();
        String truyvan = "SELECT * FROM "+DBSanPham.TB_GIOHANG;
        Cursor cursor = sqLiteDatabase.rawQuery(truyvan,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String maSP = cursor.getString(cursor.getColumnIndex(DBSanPham.TB_GIOHANG_MASP));
            String tenSP = cursor.getString(cursor.getColumnIndex(DBSanPham.TB_GIOHANG_TENSP));
            int giaTien = cursor.getInt(cursor.getColumnIndex(DBSanPham.TB_GIOHANG_GIATIEN));
            byte[] hinhAnh = cursor.getBlob(cursor.getColumnIndex(DBSanPham.TB_GIOHANG_HINHANH));

            SanPham sanPham = new SanPham();
            sanPham.setMaSanPham(maSP);
            sanPham.setTenSanPham(tenSP);
            sanPham.setGiaSanPham(giaTien);
            sanPham.setHinhgiohang(hinhAnh);

            sanPhamList.add(sanPham);
            cursor.moveToNext();
        }

        return sanPhamList;
    }
}
