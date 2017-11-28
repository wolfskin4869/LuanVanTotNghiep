package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelSanPhamPMoi;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterSanPhamMoi;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewSanPhamMoi;

import java.util.List;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class PresenterLogicSanPhamMoi implements IPresenterSanPhamMoi {

    IViewSanPhamMoi iViewSanPhamMoi;
    ModelSanPhamPMoi modelSanPhamPMoi;

    public PresenterLogicSanPhamMoi(IViewSanPhamMoi iViewSanPhamMoi) {
        this.iViewSanPhamMoi = iViewSanPhamMoi;
        modelSanPhamPMoi = new ModelSanPhamPMoi();
    }

    @Override
    public void layDanhSachSPMoi() {
        List<SanPham> sanPhamList = modelSanPhamPMoi.layDsSanPhamMoi();
        if(sanPhamList.size() > 0){
            iViewSanPhamMoi.hienThiDanhSachSPMoi(sanPhamList);
        }
    }
}
