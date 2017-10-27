package com.example.lenovo.luanvantotnghiep.Model.Objects;

/**
 * Created by Lenovo on 10/3/2017.
 */

public class DanhGia {

    String maDanhGia, tenThietBi,tieuDe, noiDung, ngayDanhGia, maSP;
    float soSao;

    public DanhGia() {
    }

    public DanhGia(String maDanhGia, String tenThietBi, String tieuDe, String noiDung,
                   String ngayDanhGia, String maSP, float soSao) {
        this.maDanhGia = maDanhGia;
        this.tenThietBi = tenThietBi;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.ngayDanhGia = ngayDanhGia;
        this.maSP = maSP;
        this.soSao = soSao;
    }

    public String getMaDanhGia() {
        return maDanhGia;
    }

    public void setMaDanhGia(String maDanhGia) {
        this.maDanhGia = maDanhGia;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDanhGia() {
        return ngayDanhGia;
    }

    public void setNgayDanhGia(String ngayDanhGia) {
        this.ngayDanhGia = ngayDanhGia;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public float getSoSao() {
        return soSao;
    }

    public void setSoSao(float soSao) {
        this.soSao = soSao;
    }
}
