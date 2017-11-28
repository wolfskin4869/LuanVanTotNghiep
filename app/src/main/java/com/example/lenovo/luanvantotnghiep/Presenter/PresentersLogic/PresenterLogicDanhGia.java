package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import android.view.View;
import android.widget.ProgressBar;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDanhGia;
import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterDanhGia;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewDanhGia;

import java.util.List;

/**
 * Created by Lenovo on 10/3/2017.
 */

public class PresenterLogicDanhGia implements IPresenterDanhGia{

    IViewDanhGia iViewDanhGia;
    ModelDanhGia modelDanhGia;

    public PresenterLogicDanhGia(IViewDanhGia iViewDanhGia) {
        this.iViewDanhGia = iViewDanhGia;
        modelDanhGia = new ModelDanhGia();
    }

    @Override
    public void themDanhGia(DanhGia danhGia) {
        boolean kiemtra = modelDanhGia.themDanhGia(danhGia);
        if(kiemtra){
            iViewDanhGia.danhGiaThanhCong();
        }else{
            iViewDanhGia.danhGiaThatBai();
        }
    }

    @Override
    public void layDSDanhGiaTheoSP(int maSP, int limit) {
        List<DanhGia> danhGiaList = modelDanhGia.layDanhSachDanhGia(maSP,limit);
        if(danhGiaList.size() > 0){
            iViewDanhGia.hienThiDSDanhGiaTheoSP(danhGiaList);
        }
    }
}
