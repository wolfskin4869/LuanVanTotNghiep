package com.example.lenovo.luanvantotnghiep.View.IViews;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;

import java.util.List;

/**
 * Created by Lenovo on 10/3/2017.
 */

public interface IViewDanhGia {

    void danhGiaThanhCong();
    void danhGiaThatBai();
    void hienThiDSDanhGiaTheoSP(List<DanhGia> danhGiaList);
}
