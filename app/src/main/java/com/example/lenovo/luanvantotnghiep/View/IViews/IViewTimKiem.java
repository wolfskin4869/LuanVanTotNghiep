package com.example.lenovo.luanvantotnghiep.View.IViews;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;

import java.util.List;

/**
 * Created by Lenovo on 11/17/2017.
 */

public interface IViewTimKiem {
    void timKiemThanhCong(List<SanPham> sanPhamList);
    void timKiemThatBai();
}
