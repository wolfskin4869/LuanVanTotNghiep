package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangKy;
import com.example.lenovo.luanvantotnghiep.Model.Objects.NguoiSuDung;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterDangKy;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewDangKy;

/**
 * Created by Lenovo on 6/20/2017.
 */

public class PresenterLogicDangKy implements IPresenterDangKy {

    IViewDangKy iviewDangKy;
    ModelDangKy modelDangKy;

    public PresenterLogicDangKy(IViewDangKy iviewDangKy) {
        this.iviewDangKy = iviewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void thucHienDangKy(NguoiSuDung nsd) {
       Boolean data = modelDangKy.dangKyThanhVien(nsd);
        if (data){
            this.iviewDangKy.dangKyThanhCong();
        }else{
            this.iviewDangKy.dangKyThatBai();
        }
    }
}
