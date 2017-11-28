package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangNhap;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Activities.MainActivity;
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

/**
 * Created by Lenovo on 6/10/2017.
 */

public class FragmentDangNhap extends Fragment implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    Button btnFacebook, btnGoogle, btnDangNhap;
    CallbackManager callbackManager;
    GoogleApiClient mGoogleApiClient;
    public static int SIGN_IN_GOOGLE_PLUS = 111;
    ProgressDialog progressDialog;
    ModelDangNhap modelDangNhap;
    EditText txtTenDangNhap, txtMatKhau;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dangnhap, container, false);

        modelDangNhap = new ModelDangNhap();
        mGoogleApiClient = modelDangNhap.layGoogleApiClient(getContext(),this);

        // Login Facebook
        FacebookSdk.sdkInitialize(getContext().getApplicationContext());

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        txtTenDangNhap = (EditText) view.findViewById(R.id.txtTenDangNhap);
        txtMatKhau = (EditText) view.findViewById(R.id.txtMatKhauDN);

        btnDangNhap = (Button) view.findViewById(R.id.btnDangNhap);
        btnFacebook = (Button) view.findViewById(R.id.btnFacebook);
        btnGoogle = (Button) view.findViewById(R.id.btnGoogle);
        btnDangNhap.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        return view;
          /*try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(
                    "com.example.lenovo.luanvantotnghiep",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {
        }*/
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnFacebook:
                LoginManager.getInstance().logInWithReadPermissions(FragmentDangNhap.this, Arrays.asList("public_profile", "email"));
                break;
            case R.id.btnGoogle:
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(intent,SIGN_IN_GOOGLE_PLUS);
                showProgressDialog();
                break;
            case  R.id.btnDangNhap:
                String tendangnhap = txtTenDangNhap.getText().toString();
                String matkhau = txtMatKhau.getText().toString();
                boolean kiemtra = modelDangNhap.kiemTraDangNhap(getActivity(),tendangnhap, matkhau);
                if(kiemtra){
                    Intent itrangchu = new Intent(getActivity(), MainActivity.class);
                    Toast.makeText(getActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(itrangchu);
                }else {
                    Toast.makeText(getActivity(), "Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private void showProgressDialog(){
        if (progressDialog ==  null){
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_GOOGLE_PLUS){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()){
                progressDialog.cancel();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
