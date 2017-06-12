package com.example.lenovo.luanvantotnghiep.Model.Class;

/**
 * Created by Lenovo on 6/9/2017.
 */

public class SanPhamMoi {
    String maSP, tenSP, giaSP, hinhSP;

    public SanPhamMoi() {
    }

    public SanPhamMoi(String maSP, String tenSP, String giaSP, String hinhSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.hinhSP = hinhSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public String getHinhSP() {
        return hinhSP;
    }

    public void setHinhSP(String hinhSP) {
        this.hinhSP = hinhSP;
    }
}
