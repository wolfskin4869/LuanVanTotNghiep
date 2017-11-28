package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.NguoiSuDung;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicDangKy;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewDangKy;

/**
 * Created by Lenovo on 6/10/2017.
 */

public class FragmentDangKy extends Fragment implements IViewDangKy, View.OnClickListener, View.OnFocusChangeListener{

    PresenterLogicDangKy presenterLogicDangKy;
    Button btnDangKy;
    EditText txtHoTen, txtEmail, txtMatKhau, txtMatKhauAgain;
    TextInputLayout input_HoTen, input_MatKhau, input_Email,input_MKhauAgain;
    Boolean testFields = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dangky, container, false);
        btnDangKy = (Button) v.findViewById(R.id.btnDangKy);

        txtHoTen = (EditText) v.findViewById(R.id.txtHoTen);
        txtEmail = (EditText) v.findViewById(R.id.txtEmail);
        txtMatKhau = (EditText) v.findViewById(R.id.txtMatKhau);
        txtMatKhauAgain = (EditText) v.findViewById(R.id.txtMatKhauAgain);

        input_HoTen = (TextInputLayout) v.findViewById(R.id.input_txtHoTen);
        input_Email = (TextInputLayout) v.findViewById(R.id.input_txtEmail);
        input_MatKhau = (TextInputLayout) v.findViewById(R.id.input_txtMatKhau);
        input_MKhauAgain = (TextInputLayout) v.findViewById(R.id.input_txtMatKhauAgain);

        btnDangKy.setOnClickListener(this);
        presenterLogicDangKy = new PresenterLogicDangKy(this);
        txtHoTen.setOnFocusChangeListener(this);
        txtEmail.setOnFocusChangeListener(this);
        txtMatKhauAgain.setOnFocusChangeListener(this);
        return v;
    }

    @Override
    public void dangKyThanhCong() {
        Toast.makeText(getActivity(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        txtHoTen.setText("");
        txtHoTen.hasFocus();
        txtEmail.setText("");
        txtMatKhauAgain.setText("");
        txtMatKhau.setText("");
    }

    @Override
    public void dangKyThatBai() {
        Toast.makeText(getActivity(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getActivity(), "Lỗi nhập thông tin", Toast.LENGTH_SHORT).show();
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
     //   String matkhauagain = txtMatKhauAgain.getText().toString();

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
