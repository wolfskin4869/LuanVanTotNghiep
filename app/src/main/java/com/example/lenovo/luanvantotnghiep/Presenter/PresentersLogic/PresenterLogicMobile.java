package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelMobile;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterMobile;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewMobile;

import java.util.List;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class PresenterLogicMobile implements IPresenterMobile {

    IViewMobile iViewMobile;
    ModelMobile modelMobile;

    public PresenterLogicMobile(IViewMobile iViewMobile) {
        this.iViewMobile = iViewMobile;
        modelMobile = new ModelMobile();
    }

    public void layDanhSachMobile() {
        List<SanPham> sanPhamList = modelMobile.layDanhSachDienThoai();
        if(sanPhamList.size() > 0){
            iViewMobile.hienThiDanhSachMobile(sanPhamList);
        }
    }
}
