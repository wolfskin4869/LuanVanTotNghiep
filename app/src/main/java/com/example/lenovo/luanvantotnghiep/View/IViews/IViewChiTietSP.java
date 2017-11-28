package com.example.lenovo.luanvantotnghiep.View.IViews;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

import java.util.List;

/**
 * Created by Lenovo on 8/29/2017.
 */

public interface IViewChiTietSP {

    void hienThiChiTietSP(SanPham sanPham);
    void hienThiSlider(String[] duongDanHSP);
    void hienThiDsDanhGia(List<DanhGia> danhGiaList);
    void themGioHangThanhCong();
    void themGioHangThatBai();

}
