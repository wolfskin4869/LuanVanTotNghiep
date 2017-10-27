package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelSPTheoThuongHieu;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterSPTheoThuongHieu;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewSPTheoThuongHieu;

import java.util.List;

/**
 * Created by Lenovo on 6/26/2017.
 */

public class PresenterLogicSPTheoTH implements IPresenterSPTheoThuongHieu {


    IViewSPTheoThuongHieu iViewSPTheoThuongHieu;
    ModelSPTheoThuongHieu modelSPTheoThuongHieu;

    public PresenterLogicSPTheoTH(IViewSPTheoThuongHieu iViewSPTheoThuongHieu) {
        this.iViewSPTheoThuongHieu = iViewSPTheoThuongHieu;
        modelSPTheoThuongHieu = new ModelSPTheoThuongHieu();
    }

    @Override
    public void layDanhSachTheoMaThuongHieu(String maThuongHieu) {
        List<SanPham> sanPhamList = modelSPTheoThuongHieu.layDSSanPhamTheoThuongHieu(maThuongHieu, "SANPHAMTHEOTHUONGHIEU", "LayDanhSachSanPhamTheoMaThuongHieu",20);
        if(sanPhamList.size() > 0){
            iViewSPTheoThuongHieu.hienThiDSSanPham(sanPhamList);
        }else{
            iViewSPTheoThuongHieu.loiHienThiDSSanPham();
        }

    }
}
