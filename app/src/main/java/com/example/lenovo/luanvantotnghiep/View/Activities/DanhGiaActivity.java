package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicDanhGia;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewDanhGia;

import java.util.List;

public class DanhGiaActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener, IViewDanhGia, View.OnClickListener {

    TextInputLayout input_txtTieuDe, input_txtNoiDung;
    TextView txtTieuDe, txtNoiDung;
    Button btnDongY;
    RatingBar rbDanhGia;
    String maSP;
    float soSao = 0;
    PresenterLogicDanhGia presenterLogicDanhGia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia);

        input_txtTieuDe = (TextInputLayout) findViewById(R.id.input_txtTieuDe);
        input_txtNoiDung = (TextInputLayout) findViewById(R.id.input_txtNoiDung);
        txtTieuDe = (TextView) findViewById(R.id.txtTieuDe);
        txtNoiDung = (TextView) findViewById(R.id.txtNoiDung);
        btnDongY = (Button) findViewById(R.id.btnDongY);
        rbDanhGia = (RatingBar) findViewById(R.id.rbDanhGia);

        maSP = getIntent().getStringExtra("MASANPHAM");

        rbDanhGia.setOnRatingBarChangeListener(this);
        btnDongY.setOnClickListener(this);
        presenterLogicDanhGia = new PresenterLogicDanhGia(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        soSao = rating;
    }

    @Override
    public void danhGiaThanhCong() {
        Toast.makeText(this, "Đánh giá thành công !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void danhGiaThatBai() {
        Toast.makeText(this, "Bạn không thể đánh giá sản phẩm này !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hienThiDSDanhGiaTheoSP(List<DanhGia> danhGiaList) {

    }

    @Override
    public void onClick(View v) {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        String maDanhGia = telephonyManager.getDeviceId();
        String tenThietBi = Build.MODEL;
        String tieuDe = txtTieuDe.getText().toString();
        String noiDung = txtNoiDung.getText().toString();

        if (tieuDe.trim().length()>0){
            input_txtTieuDe.setErrorEnabled(false);
            input_txtTieuDe.setError("");
        }else {
            input_txtTieuDe.setErrorEnabled(true);
            input_txtTieuDe.setError("Bạn chưa nhập tiêu đề cho đánh giá");
        }

        if (noiDung.trim().length() > 0){
            input_txtNoiDung.setErrorEnabled(false);
            input_txtNoiDung.setError("");
        }else{
            input_txtNoiDung.setErrorEnabled(true);
            input_txtNoiDung.setError("Bạn chưa nhập nội dung đánh giá");
        }

        if(!input_txtTieuDe.isErrorEnabled() && !input_txtNoiDung.isErrorEnabled()){
            DanhGia danhGia = new DanhGia();
            danhGia.setMaDanhGia(maDanhGia);
            danhGia.setMaSP(maSP);
            danhGia.setTenThietBi(tenThietBi);
            danhGia.setTieuDe(tieuDe);
            danhGia.setNoiDung(noiDung);
            danhGia.setSoSao(soSao);
            presenterLogicDanhGia.themDanhGia(danhGia);
            finish();
        }
    }
}
