package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelSPMoi;
import com.example.lenovo.luanvantotnghiep.Presenter.Interface_Presenters.IPresenterSPMoi;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewSPMoi;

import java.util.List;

/**
 * Created by Lenovo on 6/21/2017.
 */

public class PresenterSPMoi implements IPresenterSPMoi {

    IViewSPMoi iViewSPMoi;
    ModelSPMoi modelSPMoi;

    public PresenterSPMoi(IViewSPMoi iViewSPMoi) {
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
