package com.example.lenovo.luanvantotnghiep.View.IViews;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

import java.util.List;

/**
 * Created by Lenovo on 11/6/2017.
 */

public interface IViewThanhToan {
    void datHangThanhCong();
    void datHangThatBai();
    void layDSSanPhamTrongGioHang(List<SanPham> sanPhamList);
}
