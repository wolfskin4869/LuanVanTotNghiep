package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelChiTietSP;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;
import com.example.lenovo.luanvantotnghiep.Presenter.Interface_Presenters.IPresenterChiTietSP;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewChiTietSP;

import java.util.ArrayList;

/**
 * Created by Lenovo on 8/29/2017.
 */

public class PresenterChiTietSP implements IPresenterChiTietSP{

    IViewChiTietSP iViewChiTietSP;
    ModelChiTietSP modelChiTietSP;

    public PresenterChiTietSP(IViewChiTietSP iViewChiTietSP) {
        this.iViewChiTietSP = iViewChiTietSP;
        modelChiTietSP = new ModelChiTietSP();
    }

    @Override
    public void layChiTietSanPham(String maSP) {
        SanPham sanPham = modelChiTietSP.LayChiTietSanPham(maSP, "LaySPvaThongSoKyThuatTheoMaSP", "CHITIETSANPHAM");
        Log.d("thongtin", sanPham.getThongTinSP().toString());
        if (sanPham.getMaSanPham().length() > 0){
            String[] duongDanHSP = sanPham.getHinhNho().split(",");
//            Log.d("duongDanHSP", sanPham.getHinhNho().split(",").toString());
            iViewChiTietSP.hienThiSlider(duongDanHSP);
//            iViewChiTietSP.hienThiChiTietSP(sanPham);
        }
    }
}
