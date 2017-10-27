package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.NguoiSuDung;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicDangKy;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewDangKy;

public class DangKyActivity extends AppCompatActivity implements IViewDangKy, View.OnClickListener, View.OnFocusChangeListener{

    PresenterLogicDangKy presenterLogicDangKy;
    Button btnDangKy;
    EditText txtHoTen, txtEmail, txtMatKhau, txtMatKhauAgain;
    TextInputLayout input_HoTen, input_MatKhau, input_Email,input_MKhauAgain;
    Toolbar toolbar;
    Boolean testFields = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        addControls();
        addEvents();
        toolBar();
    }

    private void addControls() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        btnDangKy = (Button) findViewById(R.id.btnDangKy);

        txtHoTen = (EditText) findViewById(R.id.txtHoTen);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtMatKhau = (EditText) findViewById(R.id.txtMatKhau);
        txtMatKhauAgain = (EditText) findViewById(R.id.txtMatKhauAgain);

        input_HoTen = (TextInputLayout) findViewById(R.id.input_txtHoTen);
        input_Email = (TextInputLayout) findViewById(R.id.input_txtEmail);
        input_MatKhau = (TextInputLayout) findViewById(R.id.input_txtMatKhau);
        input_MKhauAgain = (TextInputLayout) findViewById(R.id.input_txtMatKhauAgain);
    }

    private void addEvents() {
        btnDangKy.setOnClickListener(this);
        presenterLogicDangKy = new PresenterLogicDangKy(this);
        txtHoTen.setOnFocusChangeListener(this);
        txtEmail.setOnFocusChangeListener(this);
        txtMatKhauAgain.setOnFocusChangeListener(this);
    }

    private void toolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Boolean ktraEmail = Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches();
        switch (id){
            case R.id.btnDangKy:
                if(txtHoTen.getText().toString().equals("") || txtHoTen.getText().toString().equals(null)||
                        txtEmail.getText().toString().equals("")|| txtEmail.getText().toString().equals(null) ||
                        txtMatKhau.getText().toString().equals("")|| txtMatKhau.getText().toString().equals(null)||
                        txtMatKhauAgain.getText().toString().equals("") || txtMatKhauAgain.getText().toString().equals(null) ||
                        !ktraEmail){
                    Toast.makeText(DangKyActivity.this, "Lỗi nhập thông tin", Toast.LENGTH_SHORT).show();
                    txtHoTen.requestFocus();
                }else{
                    dangKyEvent();
                }
                break;
        }
    }

    private void dangKyEvent() {
        String hoten = txtHoTen.getText().toString();
        String email = txtEmail.getText().toString();
        String matkhau = txtMatKhau.getText().toString();

        if(testFields){
            NguoiSuDung nsd = new NguoiSuDung();
            nsd.setTenNSD(hoten);
            nsd.setTenDangNhap(email);
            nsd.setMatKhau(matkhau);
            nsd.setMaLoaiNSD("LNSD002");
            presenterLogicDangKy.thucHienDangKy(nsd);
        }
    }


    @Override
    public void dangKyThanhCong() {
        Toast.makeText(DangKyActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        txtHoTen.setText("");
        txtHoTen.hasFocus();
        txtEmail.setText("");
        txtMatKhauAgain.setText("");
        txtMatKhau.setText("");
    }

    @Override
    public void dangKyThatBai() {
        Toast.makeText(DangKyActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();
        switch (id){
            case R.id.txtHoTen:
                if(!hasFocus){
                    String chuoi = ((EditText)v).getText().toString();
                    if(chuoi.trim().equals("") || chuoi.equals(null)){
                        input_HoTen.setErrorEnabled(true);
                        input_HoTen.setError("Bạn chưa nhập họ tên");
                        testFields = false;
                    }else{
                        input_HoTen.setErrorEnabled(false);
                        input_HoTen.setError("");
                        testFields = true;
                    }
                }
                break;
            case R.id.txtEmail:
                if(!hasFocus){
                    String chuoi = ((EditText)v).getText().toString();
                    if(chuoi.trim().equals("") || chuoi.equals(null)){
                        input_Email.setErrorEnabled(true);
                        input_Email.setError("Bạn chưa nhập Email");
                        testFields = false;
                    }else{
                        Boolean ktraEmail = Patterns.EMAIL_ADDRESS.matcher(chuoi).matches();
                        if(!ktraEmail){
                            input_Email.setErrorEnabled(true);
                            input_Email.setError("Lỗi nhập Email");
                            testFields = false;
                        }else{
                            input_Email.setErrorEnabled(false);
                            input_Email.setError("");
                            testFields = true;
                        }
                    }
                }
                break;

            case R.id.txtMatKhau:
                break;

            case R.id.txtMatKhauAgain:
                String chuoi = ((EditText)v).getText().toString();
                String matkhau = txtMatKhau.getText().toString();
                if(chuoi.equals("") || chuoi.equals(null)){
                    input_MKhauAgain.setErrorEnabled(false);
                    input_MKhauAgain.setError("");
                }else if(!chuoi.trim().equals(matkhau)){
                    input_MKhauAgain.setErrorEnabled(true);
                    input_MKhauAgain.setError("Mật khẩu không trùng khớp");
                    testFields = false;
                }else{
                    input_MKhauAgain.setErrorEnabled(false);
                    input_MKhauAgain.setError("");
                    testFields = true;
                }
                break;
        }
    }
}
