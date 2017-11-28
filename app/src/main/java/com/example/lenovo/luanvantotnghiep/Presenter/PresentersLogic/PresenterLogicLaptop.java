package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelLaptop;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterLaptop;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewLaptop;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterLogicLaptop implements IPresenterLaptop {

    IViewLaptop iViewLaptop;
    ModelLaptop modelLaptop;

    public PresenterLogicLaptop(IViewLaptop iViewLaptop) {
        this.iViewLaptop = iViewLaptop;
        modelLaptop = new ModelLaptop();
    }

    public void layDanhSachLaptop() {
        List<SanPham> sanPhamList = modelLaptop.layDanhSachLaptop();
        if(sanPhamList.size() > 0){
            iViewLaptop.hienThiDanhSachLaptop(sanPhamList);
        }
    }
}
