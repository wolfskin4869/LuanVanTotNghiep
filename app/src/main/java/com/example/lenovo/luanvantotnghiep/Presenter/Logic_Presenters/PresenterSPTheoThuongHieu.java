package com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelSPTheoThuongHieu;
import com.example.lenovo.luanvantotnghiep.Presenter.Interface_Presenters.IPresenterSPTheoThuongHieu;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewSPTheoThuongHieu;

import java.util.List;

/**
 * Created by Lenovo on 6/26/2017.
 */

public class PresenterSPTheoThuongHieu implements IPresenterSPTheoThuongHieu {


    IViewSPTheoThuongHieu iViewSPTheoThuongHieu;
    ModelSPTheoThuongHieu modelSPTheoThuongHieu;

    public PresenterSPTheoThuongHieu(IViewSPTheoThuongHieu iViewSPTheoThuongHieu) {
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
