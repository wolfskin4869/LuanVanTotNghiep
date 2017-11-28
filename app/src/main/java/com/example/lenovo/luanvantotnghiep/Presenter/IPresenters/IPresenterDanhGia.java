package com.example.lenovo.luanvantotnghiep.Presenter.IPresenters;

import android.widget.ProgressBar;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;

/**
 * Created by Lenovo on 10/3/2017.
 */

public interface IPresenterDanhGia {
    void themDanhGia(DanhGia danhGia);
    void layDSDanhGiaTheoSP(int maSP, int limit);
}
