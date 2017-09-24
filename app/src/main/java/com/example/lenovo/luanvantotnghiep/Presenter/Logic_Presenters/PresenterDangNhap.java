package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangNhap;
import com.example.lenovo.luanvantotnghiep.Presenter.Interface_Presenters.IPresenterDangNhap;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewTrangChu;
import com.facebook.AccessToken;

/**
 * Created by Lenovo on 6/13/2017.
 */

public class PresenterDangNhap implements IPresenterDangNhap {

    IViewTrangChu iViewTrangChu;


    public PresenterDangNhap(IViewTrangChu iViewTrangChu) {
        this.iViewTrangChu = iViewTrangChu;
    }

    @Override
    public AccessToken getTenNguoiDungFaceBook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.layTokenFacebookHienTai();
        return accessToken;
    }
}
