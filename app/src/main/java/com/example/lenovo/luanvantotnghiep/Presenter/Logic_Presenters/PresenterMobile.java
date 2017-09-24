package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelMobile;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewMobile;

import java.util.List;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class PresenterMobile {

    IViewMobile iViewMobile;
    ModelMobile modelMobile;

    public PresenterMobile(IViewMobile iViewMobile) {
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
