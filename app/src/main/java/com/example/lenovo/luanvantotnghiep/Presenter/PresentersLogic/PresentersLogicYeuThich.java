package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import android.content.Context;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.SQLite.ModelYeuThich;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterYeuThich;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewYeuThich;

import java.util.List;

/**
 * Created by Lenovo on 11/18/2017.
 */

public class PresentersLogicYeuThich implements IPresenterYeuThich{

    IViewYeuThich iViewYeuThich;
    ModelYeuThich modelYeuThich;

    public PresentersLogicYeuThich(IViewYeuThich iViewYeuThich, Context context) {
        this.iViewYeuThich = iViewYeuThich;
        modelYeuThich = new ModelYeuThich();
        modelYeuThich.moKetNoi(context);
    }

    @Override
    public void layDanhSachSanPhamYeuThich(Context context) {
        List<SanPham> sanPhamList = modelYeuThich.layDanhSachSanPhamYeuThich();
        if(sanPhamList.size() > 0){
            iViewYeuThich.hienThiDanhSachSanPhamYeuThich(sanPhamList);
        }
    }
}
