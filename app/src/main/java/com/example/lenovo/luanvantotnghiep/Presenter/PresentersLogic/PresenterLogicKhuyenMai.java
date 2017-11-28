package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterKhuyenMai;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewKhuyenMai;

import java.util.List;

/**
 * Created by Lenovo on 11/8/2017.
 */

public class PresenterLogicKhuyenMai implements IPresenterKhuyenMai {

    IViewKhuyenMai iViewKhuyenMai;
    ModelKhuyenMai modelKhuyenMai;

    public PresenterLogicKhuyenMai(IViewKhuyenMai iViewKhuyenMai) {
        this.iViewKhuyenMai = iViewKhuyenMai;
        modelKhuyenMai = new ModelKhuyenMai();
    }

    @Override
    public void layDanhSachKhuyenMai() {
        List<KhuyenMai> khuyenMaiList = modelKhuyenMai.layDanhSachKhuyenMai("LayDanhSachKhuyenMai","DANHSACHKHUYENMAI");
        if (khuyenMaiList.size()>0){
            iViewKhuyenMai.hienThiDanhSachKhuyenMai(khuyenMaiList);
        }

    }
}
