package com.example.lenovo.luanvantotnghiep.View.DangNhap.Fragments;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.luanvantotnghiep.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Lenovo on 6/10/2017.
 */

public class DangNhapFragment extends Fragment implements View.OnClickListener {

    Button btnFacebook;
    CallbackManager callbackManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_dangnhap, container, false);

        FacebookSdk.sdkInitialize(getContext().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("Kiem tra","Thành công");
            }

            @Override
            public void onCancel() {
                Log.d("Kiem tra","Thoát");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("Kiem tra","Lỗi");
            }
        });

        btnFacebook = (Button) view.findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(this);
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
        return view;
    }

    @Override
    public void onClick(View v) {
        LoginManager.getInstance().logInWithReadPermissions(DangNhapFragment.this, Arrays.asList("public_profile"));

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
