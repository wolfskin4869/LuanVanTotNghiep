package com.example.lenovo.luanvantotnghiep.Model.Objects;

/**
 * Created by Lenovo on 8/29/2017.
 */

public class ThongSoKyThuat {

    String tenThongSo, giaTriThongSo;

    public ThongSoKyThuat() {
    }

    public ThongSoKyThuat(String tenThongSo, String giaTriThongSo) {
        this.tenThongSo = tenThongSo;
        this.giaTriThongSo = giaTriThongSo;
    }

    public String getTenThongSo() {
        return tenThongSo;
    }

    public void setTenThongSo(String tenThongSo) {
        this.tenThongSo = tenThongSo;
    }

    public String getGiaTriThongSo() {
        return giaTriThongSo;
    }

    public void setGiaTriThongSo(String giaTriThongSo) {
        this.giaTriThongSo = giaTriThongSo;
    }
}
