package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelTablet;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewTablet;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterTablet {

    IViewTablet iViewTablet;
    ModelTablet modelTablet;

    public PresenterTablet(IViewTablet iViewTablet) {
        this.iViewTablet = iViewTablet;
        modelTablet = new ModelTablet();
    }

    public void layDanhSachTablet() {
        List<SanPham> sanPhamList = modelTablet.layDanhSachTablet();
        if(sanPhamList.size() > 0){
            iViewTablet.hienThiDanhSachTablet(sanPhamList);
        }
    }
}
