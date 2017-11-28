package com.example.lenovo.luanvantotnghiep.View.IViews;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

import java.util.List;

/**
 * Created by Lenovo on 11/18/2017.
 */

public interface IViewYeuThich {

    void hienThiDanhSachSanPhamYeuThich(List<SanPham> sanPhamList);
    void themVaoGioHangThanhCong();
    void themVaoGioHangThatBai();
}
