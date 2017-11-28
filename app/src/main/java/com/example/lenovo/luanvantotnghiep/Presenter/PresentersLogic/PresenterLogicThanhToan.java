package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import android.content.Context;

import com.example.lenovo.luanvantotnghiep.Model.SQLite.ModelGioHang;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelThanhToan;
import com.example.lenovo.luanvantotnghiep.Model.Objects.HoaDon;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterThanhToan;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewThanhToan;

import java.util.List;

/**
 * Created by Lenovo on 11/6/2017.
 */

public class PresenterLogicThanhToan implements IPresenterThanhToan {

    IViewThanhToan iViewThanhToan;
    ModelThanhToan modelThanhToan;
    ModelGioHang modelGioHang;
    List<SanPham> sanPhamList;
    int soLuongTon;

    public PresenterLogicThanhToan(IViewThanhToan iViewThanhToan, Context context) {
        this.iViewThanhToan = iViewThanhToan;
        modelThanhToan = new ModelThanhToan();
        modelGioHang = new ModelGioHang();
        modelGioHang.moKetNoi(context);
    }

    @Override
    public void themHoaDon(HoaDon hoaDon) {
        boolean kiemtra = modelThanhToan.themHoaDon(hoaDon);

        if(kiemtra){
            iViewThanhToan.datHangThanhCong();
            int dem = sanPhamList.size();
            for(int i = 0; i<dem ;i++){
                modelGioHang.xoaSanPhamTrongGioHang(sanPhamList.get(i).getMaSanPham());
            }
        }else {
            iViewThanhToan.datHangThatBai();
        }
    }

    @Override
    public void layDSSanPhamTrongGioHang() {
        sanPhamList = modelGioHang.layDSSPTrongGioHang();
        iViewThanhToan.layDSSanPhamTrongGioHang(sanPhamList);
    }
}
