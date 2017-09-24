package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangNhap;
import com.example.lenovo.luanvantotnghiep.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Arrays;

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{

    Toolbar toolbar;
    CallbackManager callbackManager;
    GoogleApiClient mGoogleApiClient;
    public static int SIGN_IN_GOOGLE_PLUS = 111;
    ProgressDialog progressDialog;
    ModelDangNhap modelDangNhap;
    Button btnFacebook, btnGoogle, btnDangNhap;
    EditText txtTenDangNhap, txtMatKhau;
    TextView txtDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        modelDangNhap = new ModelDangNhap();
        mGoogleApiClient = modelDangNhap.layGoogleApiClient(DangNhapActivity.this,this);

        // Login Facebook
        FacebookSdk.sdkInitialize(getApplicationContext());

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        addControls();
        addEvents();
        toolBar();
    }

    private void addEvents() {
        btnDangNhap.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        txtDangKy.setOnClickListener(this);
    }

    private void addControls() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        txtTenDangNhap = (EditText) findViewById(R.id.txtTenDangNhap);
        txtMatKhau = (EditText) findViewById(R.id.txtMatKhauDN);
        txtDangKy = (TextView) findViewById(R.id.txtDangKy);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        btnFacebook = (Button) findViewById(R.id.btnFacebook);
        btnGoogle = (Button) findViewById(R.id.btnGoogle);
    }

    private void toolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnFacebook:
                LoginManager.getInstance().logInWithReadPermissions(DangNhapActivity.this, Arrays.asList("public_profile", "email"));
                break;
            case R.id.btnGoogle:
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(intent,SIGN_IN_GOOGLE_PLUS);
                showProgressDialog();
                break;
            case  R.id.btnDangNhap:
                String tendangnhap = txtTenDangNhap.getText().toString();
                String matkhau = txtMatKhau.getText().toString();
                boolean kiemtra = modelDangNhap.kiemTraDangNhap(getApplicationContext(),tendangnhap, matkhau);
                if(kiemtra){
                    Intent itrangchu = new Intent(getApplicationContext(), MainActivity.class);
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(itrangchu);
                }else {
                    Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
                break;
            case  R.id.txtDangKy:
                Intent iDangKy = new Intent(getApplicationContext(), DangKyActivity.class);
                startActivity(iDangKy);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void showProgressDialog(){
        if (progressDialog ==  null){
            progressDialog = new ProgressDialog(DangNhapActivity.this);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_GOOGLE_PLUS){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                progressDialog.cancel();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
