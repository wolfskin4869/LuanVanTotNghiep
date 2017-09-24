package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelTrademark;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ThuongHieu;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewTrademark;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterTrademark {

    IViewTrademark iViewTrademark;
    ModelTrademark modelTrademark;

    public PresenterTrademark(IViewTrademark iViewTrademark) {
        this.iViewTrademark = iViewTrademark;
        modelTrademark = new ModelTrademark();
    }

    public void layDanhSachTrademark() {
        List<ThuongHieu> thuongHieuList = modelTrademark.layDanhSachTrademark();
        if(thuongHieuList.size() > 0){
            iViewTrademark.hienThiDanhSachTrademark(thuongHieuList);
        }
    }

}
