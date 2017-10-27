package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelSPMoi;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterSPMoi;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewSPMoi;

import java.util.List;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class PresenterLogicSPMoi implements IPresenterSPMoi {

    IViewSPMoi iViewSPMoi;
    ModelSPMoi modelSPMoi;

    public PresenterLogicSPMoi(IViewSPMoi iViewSPMoi) {
        this.iViewSPMoi = iViewSPMoi;
        modelSPMoi = new ModelSPMoi();
    }

    @Override
    public void layDanhSachSPMoi() {
        List<SanPham> sanPhamList = modelSPMoi.layDsSanPhamMoi();
        if(sanPhamList.size() > 0){
            iViewSPMoi.hienThiDanhSachSPMoi(sanPhamList);
        }
    }
}
