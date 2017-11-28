package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelTrademark;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ThuongHieu;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterTrademark;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTrademark;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterLogicTrademark implements IPresenterTrademark {

    IViewTrademark iViewTrademark;
    ModelTrademark modelTrademark;

    public PresenterLogicTrademark(IViewTrademark iViewTrademark) {
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
