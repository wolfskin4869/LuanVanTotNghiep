package com.example.lenovo.luanvantotnghiep.Presenter.IPresenters;

import android.content.Context;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

/**
 * Created by Lenovo on 8/29/2017.
 */

public interface IPresenterChiTietSP {

    void layChiTietSanPham(String maSP);
    void layDanhSachDanhGiaSanPham(String maSP, int limit);
    void themGioHang(SanPham sanPham, Context context);
}
