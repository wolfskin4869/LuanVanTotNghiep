package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import android.view.View;
import android.widget.ProgressBar;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelTimKiem;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterThanhToan;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterTimKiem;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTimKiem;

import java.util.List;

/**
 * Created by Lenovo on 11/17/2017.
 */

public class PresenterLogicTimKiem implements IPresenterTimKiem {

    IViewTimKiem iViewTimKiem;
    ModelTimKiem modelTimKiem;

    public PresenterLogicTimKiem(IViewTimKiem iViewTimKiem) {
        this.iViewTimKiem = iViewTimKiem;
        modelTimKiem = new ModelTimKiem();
    }

    @Override
    public void timKiemSanPhamTheoTen(String tenSP, int limit) {
        List<SanPham> sanPhamList = modelTimKiem.layDanhSachSanPhamTimKiem(tenSP,limit);
        if(sanPhamList.size() > 0){
            iViewTimKiem.timKiemThanhCong(sanPhamList);
        }else {
            iViewTimKiem.timKiemThatBai();
        }
    }
}
