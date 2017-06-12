package com.example.lenovo.luanvantotnghiep.Presenter.Home;

import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Home.DownloadJSON;
import com.example.lenovo.luanvantotnghiep.View.Home.IViewDownload;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 6/7/2017.
 */

public class PresenterDownloadLogic implements IPresenterDownload {

    IViewDownload iViewDownload;
    String pathURL = "";
    String maThuongHieu = "";

    public PresenterDownloadLogic(IViewDownload iViewDownload, String pathURL, String maThuongHieu) {
        this.iViewDownload = iViewDownload;
        this.pathURL = pathURL;
        this.maThuongHieu = maThuongHieu;
    }

    @Override
    public void dowloadDuLieu() {
        DownloadJSON downloadJSON = new DownloadJSON();
        downloadJSON.execute(pathURL, maThuongHieu);
        try {
            String dulieuParse = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuParse);
            JSONArray jsThuongHieu = jsonObject.getJSONArray("THUONGHIEU");
            for (int i = 0; i < jsThuongHieu.length(); i++){
                JSONObject layDuLieu = jsThuongHieu.getJSONObject(i);
                String tenThuongHieu = layDuLieu.getString("TENTHUONGHIEU");
                Log.d("JSON", tenThuongHieu);
            }


            String dulieu = downloadJSON.get();
            if(dulieu == null && dulieu.equals("")){
                dulieu = "Kiểm tra lại kết nối";
                iViewDownload.downloadThatBai(dulieu);
            }else{
                iViewDownload.dowloadThanhCong(dulieu);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
