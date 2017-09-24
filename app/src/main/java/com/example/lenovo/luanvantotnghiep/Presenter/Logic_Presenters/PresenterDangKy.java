package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangKy;
import com.example.lenovo.luanvantotnghiep.Model.Objects.NguoiSuDung;
import com.example.lenovo.luanvantotnghiep.Presenter.Interface_Presenters.IPresenterDangKy;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewDangKy;

/**
 * Created by Lenovo on 6/20/2017.
 */

public class PresenterDangKy implements IPresenterDangKy {

    IViewDangKy iviewDangKy;
    ModelDangKy modelDangKy;

    public PresenterDangKy(IViewDangKy iviewDangKy) {
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
