package com.example.lenovo.luanvantotnghiep.Model.Models;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.luanvantotnghiep.MyPublic.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 6/13/2017.
 */

public class ModelDangNhap {

    AccessToken accessToken;
    AccessTokenTracker accessTokenTracker;
    public AccessToken layTokenFacebookHienTai(){


        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                accessToken = currentAccessToken;
            }
        };
        accessToken = AccessToken.getCurrentAccessToken();
        return accessToken;
    }

    public String layCatchDangNhap(Context context){
        SharedPreferences cacthDN = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        String tennsd = cacthDN.getString("tennsd", "");
        return tennsd;
    }

    /*public String layCatchTenDN(Context context){
        SharedPreferences cacthTDN = context.getSharedPreferences("dangnhap",Context.MODE_PRIVATE);
        String tendn = cacthTDN.getString("tendangnhap", "");
        return tendn;
    }*/

    public void capNhatDuLieu(Context context, String tennsd){

        SharedPreferences catchDangNhap = context.getSharedPreferences("dangnhap", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = catchDangNhap.edit();
        editor.putString("tennsd", tennsd);
        editor.commit();
    }

    public Boolean kiemTraDangNhap(Context context, String tendangnhap, String matkhau){
        boolean kiemtra = false;
        String path = Server.SERVER_NAME;
        List<HashMap<String, String>> attrs = new ArrayList<>();

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "KiemTraDangNhap");

        HashMap<String, String> hsTenDangNhap = new HashMap<>();
        hsTenDangNhap.put("tendangnhap", tendangnhap);

        HashMap<String, String> hsMatKhau = new HashMap<>();
        hsMatKhau.put("matkhau", matkhau);

        attrs.add(hsHam);
        attrs.add(hsTenDangNhap);
        attrs.add(hsMatKhau);

        DownloadJSON downloadJSON = new DownloadJSON(path,attrs);
        downloadJSON.execute();

        try {
            String dulieu = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieu);
            String JSONketqua = jsonObject.getString("ketqua");
            if(JSONketqua.equals("true")){
                kiemtra = true;
                String tennsd = jsonObject.getString("tennsd");
                capNhatDuLieu(context, tennsd);
            }else{
                kiemtra = false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return kiemtra;
    }

    public GoogleApiClient layGoogleApiClient(Context context, GoogleApiClient.OnConnectionFailedListener failedListener){
        GoogleApiClient mGoogleApiClient;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail() // Muốn yêu cầu thêm thì request thêm VD: requestId(),.v.v
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(((AppCompatActivity)context),failedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        return mGoogleApiClient;
    }

    public GoogleSignInResult layThongTinDNGoogle(GoogleApiClient googleApiClient){
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            return opr.get();
        }else {
            return null;
        }
    }

    public void huyTokenTracker(){
        accessTokenTracker.stopTracking();
    }
}
