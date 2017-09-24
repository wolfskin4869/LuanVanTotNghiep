package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelLaptop;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewLaptop;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterLaptop {

    IViewLaptop iViewLaptop;
    ModelLaptop modelLaptop;

    public PresenterLaptop(IViewLaptop iViewLaptop) {
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
