package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import android.content.Context;

import com.example.lenovo.luanvantotnghiep.Model.SQLite.ModelGioHang;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterGioHang;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewGioHang;

import java.util.List;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class PresenterLogicGioHang implements IPresenterGioHang {

    IViewGioHang iViewGioHang;
    ModelGioHang modelGioHang;

    public PresenterLogicGioHang(IViewGioHang iViewGioHang) {
        this.iViewGioHang = iViewGioHang;
        modelGioHang = new ModelGioHang();
    }

    @Override
    public void layDSSPTrongGioHang(Context context) {
        modelGioHang.moKetNoi(context);
        List<SanPham> sanPhamList = modelGioHang.layDSSPTrongGioHang();
        if(sanPhamList.size() > 0){
            iViewGioHang.hienThiDanhSachSanPhamTrongGioHang(sanPhamList);
        }
    }
}
