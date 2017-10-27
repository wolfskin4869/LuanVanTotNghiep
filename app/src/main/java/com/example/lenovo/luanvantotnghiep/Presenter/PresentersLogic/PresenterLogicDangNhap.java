package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangNhap;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterDangNhap;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTrangChu;
import com.facebook.AccessToken;

/**
 * Created by Lenovo on 6/13/2017.
 */

public class PresenterLogicDangNhap implements IPresenterDangNhap {

    IViewTrangChu iViewTrangChu;


    public PresenterLogicDangNhap(IViewTrangChu iViewTrangChu) {
        this.iViewTrangChu = iViewTrangChu;
    }

    @Override
    public AccessToken getTenNguoiDungFaceBook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.layTokenFacebookHienTai();
        return accessToken;
    }
}
