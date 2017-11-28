package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietHoaDon;
import com.example.lenovo.luanvantotnghiep.Model.Objects.HoaDon;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicThanhToan;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewThanhToan;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanActivity extends AppCompatActivity implements View.OnClickListener, IViewThanhToan {

    Toolbar toolBar;
    EditText txtTenNguoiNhan, txtDiaChi, txtSoDienThoai;
    ImageButton imgThanhToanKhiNhanHang, imgChuyenKhoan;
    Button btnThanhToan;
    CheckBox cbThoaThuan;
    TextView txtThanhToanKhiNhanHang, txtChuyenKhoan;
    PresenterLogicThanhToan presenterLogicThanhToan;
    List<ChiTietHoaDon> chiTietHoaDonList = new ArrayList<>();
    boolean hinhThucTT = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        txtTenNguoiNhan = (EditText) findViewById(R.id.txtTenNguoiNhan);
        txtDiaChi = (EditText) findViewById(R.id.txtDiaChi);
        txtSoDienThoai = (EditText) findViewById(R.id.txtSoDienThoai);
        txtThanhToanKhiNhanHang = (TextView) findViewById(R.id.txtThanhToanKhiNhanHang);
        txtChuyenKhoan = (TextView) findViewById(R.id.txtChuyenKhoan);
        imgThanhToanKhiNhanHang = (ImageButton) findViewById(R.id.imgThanhToanKhiNhanHang);
        imgChuyenKhoan = (ImageButton) findViewById(R.id.imgChuyenKhoan);
        cbThoaThuan = (CheckBox) findViewById(R.id.cbThoaThuan);
        btnThanhToan = (Button) findViewById(R.id.btnThanhToan);

        presenterLogicThanhToan = new PresenterLogicThanhToan(this, this);
        presenterLogicThanhToan.layDSSanPhamTrongGioHang();

        actionBar();
        btnThanhToan.setOnClickListener(this);
        imgThanhToanKhiNhanHang.setOnClickListener(this);
        imgChuyenKhoan.setOnClickListener(this);

    }

    private void actionBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnThanhToan:
                String tenNguoiNhan = txtTenNguoiNhan.getText().toString();
                String diaChi = txtDiaChi.getText().toString();
                String soDienThoai = txtSoDienThoai.getText().toString();

                if(tenNguoiNhan.trim().length() > 0  && diaChi.trim().length() > 0 && soDienThoai.trim().length() > 0){
                    if(cbThoaThuan.isChecked()){
                        HoaDon hoaDon = new HoaDon();
                        hoaDon.setTenNguoiNhan(tenNguoiNhan);
                        hoaDon.setDiaChiGiao(diaChi);
                        hoaDon.setSoDienThoai(soDienThoai);
                        if(hinhThucTT){
                            hoaDon.setHinhThucThanhToan("Chuyển khoản");
                        }else {
                            hoaDon.setHinhThucThanhToan("Thanh toán khi nhận hàng");
                        }

                        hoaDon.setChiTietHoaDonList(chiTietHoaDonList);
                        presenterLogicThanhToan.themHoaDon(hoaDon);
                    }else {
                        Toast.makeText(this, "Bạn chưa đồng ý thõa thuận với chúng tôi", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.imgThanhToanKhiNhanHang:
                chonHinhThucThanhToan(txtThanhToanKhiNhanHang, txtChuyenKhoan);
                hinhThucTT = false;
                break;

            case R.id.imgChuyenKhoan:
                chonHinhThucThanhToan(txtChuyenKhoan, txtThanhToanKhiNhanHang);
                hinhThucTT = true;
                break;
        }
    }

    private void chonHinhThucThanhToan(TextView txtChon, TextView txtKhongChon){
        txtChon.setTextColor(getIdColor(R.color.colorGoogle));
        txtKhongChon.setTextColor(getIdColor(R.color.colorLittleGray));
    }

    private int getIdColor(int idcolor){
        int color = 0;
        if(Build.VERSION.SDK_INT > 21){
            color = ContextCompat.getColor(this, idcolor);
        }else{
            color = getResources().getColor(idcolor);
        }
        return color;
    }

    @Override
    public void datHangThanhCong() {
        Toast.makeText(this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();

        Intent iDatHangTC = new Intent(this, MainActivity.class);
        startActivity(iDatHangTC);
    }

    @Override
    public void datHangThatBai() {
        Toast.makeText(this, "Đặt hàng thất bại!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void layDSSanPhamTrongGioHang(List<SanPham> sanPhamList) {
        for(int i = 0; i < sanPhamList.size(); i++){
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.setMaSanPham(sanPhamList.get(i).getMaSanPham());
            chiTietHoaDon.setSoLuongDat(sanPhamList.get(i).getSoLuongDat());

            chiTietHoaDonList.add(chiTietHoaDon);
        }
    }

    // Code back to previous page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ( id == android.R.id.home ) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
