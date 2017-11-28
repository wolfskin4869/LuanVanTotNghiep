package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelTablet;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterTablet;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTablet;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterLogicTablet implements IPresenterTablet{

    IViewTablet iViewTablet;
    ModelTablet modelTablet;

    public PresenterLogicTablet(IViewTablet iViewTablet) {
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
