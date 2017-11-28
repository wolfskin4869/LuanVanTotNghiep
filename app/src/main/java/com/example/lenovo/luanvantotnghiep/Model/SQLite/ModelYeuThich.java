package com.example.lenovo.luanvantotnghiep.Model.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 11/18/2017.
 */

public class ModelYeuThich {

    SQLiteDatabase sqLiteDatabase;

    public void moKetNoi(Context context) {
        DBSanPham dbSanPham = new DBSanPham(context);
        sqLiteDatabase = dbSanPham.getWritableDatabase();
    }

    public boolean themYeuThich(SanPham sanPham) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBSanPham.TB_YEUTHICH_MASP, sanPham.getMaSanPham());
        contentValues.put(DBSanPham.TB_YEUTHICH_TENSP, sanPham.getTenSanPham());
        contentValues.put(DBSanPham.TB_YEUTHICH_GIATIEN, sanPham.getGiaSanPham());
        contentValues.put(DBSanPham.TB_YEUTHICH_HINHANH, sanPham.getHinhSQLite());
        contentValues.put(DBSanPham.TB_YEUTHICH_SOLUONGDAT, sanPham.getSoLuongDat());
        contentValues.put(DBSanPham.TB_YEUTHICH_SOLUONGTON, sanPham.getSoLuongTon());
//        contentValues.put(DBSanPham.TB_YEUTHICH_PHANTRAMKM, sanPham.getPhanTramKM());

        long id = sqLiteDatabase.insert(DBSanPham.TB_YEUTHICH, null, contentValues);
        return id > 0;
    }

    public boolean xoaSanPhamYeuThich(String masp) {
        int kiemtra = sqLiteDatabase.delete(DBSanPham.TB_YEUTHICH, DBSanPham.TB_YEUTHICH_MASP + " = '" + masp + "'", null);
        return kiemtra > 0;
    }

    public List<SanPham> layDanhSachSanPhamYeuThich(){
        List<SanPham> sanPhamList = new ArrayList<>();
        String truyvan = "SELECT * FROM "+DBSanPham.TB_YEUTHICH;
        Cursor cursor = sqLiteDatabase.rawQuery(truyvan,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int maSP = cursor.getInt(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_MASP));
            String tenSP = cursor.getString(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_TENSP));
            int giaTien = cursor.getInt(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_GIATIEN));
            byte[] hinhAnh = cursor.getBlob(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_HINHANH));
            int soLuong = cursor.getInt(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_SOLUONGDAT));
            int soLuongTon = cursor.getInt(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_SOLUONGTON));
//            int phanTramKM = cursor.getInt(cursor.getColumnIndex(DBSanPham.TB_YEUTHICH_PHANTRAMKM));

            SanPham sanPham = new SanPham();

            sanPham.setMaSanPham(maSP);
            sanPham.setTenSanPham(tenSP);
            sanPham.setGiaSanPham(giaTien);
            sanPham.setHinhSQLite(hinhAnh);
            sanPham.setSoLuongDat(soLuong);
            sanPham.setSoLuongTon(soLuongTon);
//            sanPham.setPhanTramKM(phanTramKM);

            sanPhamList.add(sanPham);
            cursor.moveToNext();
        }

        return sanPhamList;
    }
}
