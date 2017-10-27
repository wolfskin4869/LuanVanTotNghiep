package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelSale;
import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewSale;

import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class PresenterLogicSale {

    IViewSale iViewSale;
    ModelSale modelSale;

    public PresenterLogicSale(IViewSale iViewSale) {
        this.iViewSale = iViewSale;
        modelSale = new ModelSale();
    }

    public void layDanhSachSale() {
        List<KhuyenMai> khuyenMaiList = modelSale.layDanhSachSale();
        if(khuyenMaiList.size() > 0){
            iViewSale.hienThiDanhSachSale(khuyenMaiList);
        }
    }

}
