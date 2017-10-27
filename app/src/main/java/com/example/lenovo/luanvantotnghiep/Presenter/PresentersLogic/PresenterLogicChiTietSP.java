package com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic;

import android.content.Context;
import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.GioHang.ModelGioHang;
import com.example.lenovo.luanvantotnghiep.Model.Models.ModelChiTietSP;
import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.IPresenters.IPresenterChiTietSP;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewChiTietSP;

import java.util.List;

/**
 * Created by Lenovo on 8/29/2017.
 */

public class PresenterLogicChiTietSP implements IPresenterChiTietSP{

    IViewChiTietSP iViewChiTietSP;
    ModelChiTietSP modelChiTietSP;
    ModelGioHang modelGioHang;

    public PresenterLogicChiTietSP() {
        modelGioHang = new ModelGioHang();
    }

    public PresenterLogicChiTietSP(IViewChiTietSP iViewChiTietSP) {
        this.iViewChiTietSP = iViewChiTietSP;
        modelChiTietSP = new ModelChiTietSP();
        modelGioHang = new ModelGioHang();
    }

    @Override
    public void layChiTietSanPham(String maSP) {
        SanPham sanPham = modelChiTietSP.layChiTietSanPham(maSP, "LaySPvaThongSoKyThuatTheoMaSP", "CHITIETSANPHAM");
        Log.d("thongtin", sanPham.getThongTinSP().toString());
        if (sanPham.getMaSanPham().length() > 0){
            String[] duongDanHSP = sanPham.getHinhNho().split(",");
//            Log.d("duongDanHSP", sanPham.getHinhNho().split(",").toString());
            iViewChiTietSP.hienThiSlider(duongDanHSP);
            iViewChiTietSP.hienThiChiTietSP(sanPham);
        }
    }

    @Override
    public void layDanhSachDanhGiaSanPham(String maSP, int limit) {
        List<DanhGia> danhGiaList = modelChiTietSP.layDanhSachDanhGia(maSP, limit);
        if(danhGiaList.size() > 0){
            iViewChiTietSP.hienThiDsDanhGia(danhGiaList);
        }
    }

    @Override
    public void themGioHang(SanPham sanPham, Context context) {
        modelGioHang.moKetNoi(context);
        boolean kiemtra = modelGioHang.themGioHang(sanPham);
        if(kiemtra){
            iViewChiTietSP.themGioHangThanhCong();
        }else {
            iViewChiTietSP.themGioHangThatBai();
        }
    }

    public int demSPCoTrongGioHang(Context context){
        modelGioHang.moKetNoi(context);
        List<SanPham> sanPhamList = modelGioHang.layDSSPTrongGioHang();
        int dem = sanPhamList.size();
        return dem;
    }
}
