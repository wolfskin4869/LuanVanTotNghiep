package com.example.lenovo.luanvantotnghiep.Model.Home;

import android.net.Uri;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lenovo on 6/7/2017.
 */

public class DownloadJSON extends AsyncTask<String,Void,String>{

    StringBuilder data;
    @Override
    protected String doInBackground(String... params) {
        try {
            URL url = new URL(params[0]); // params[0] <=> duongdan
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

           /* Gửi lên Webservice dạng JSON để bảo mật cao hơn
            connection.addRequestProperty("Content-type","text/json; charset=utf-8");
            ...
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("mathuonghieu",params[1]);
            bufferedWriter.write(query);*/

            connection.setRequestMethod("POST");    // Khai báo phương thức truyền dạng GET hay POST
            connection.setDoInput(true);    // Mở luồng InputStream
            connection.setDoOutput(true);   // Mở luồng OutputStream

            // Khai báo dữ liệu mà ta muốn truyền ngầm
            Uri.Builder uri = new Uri.Builder();
            uri.appendQueryParameter("mathuonghieu",params[1]); // params[1] <=> mathuonghieu
            String query = uri.build().getEncodedQuery();

                /*Ghi dữ liệu dạng POST này vào OutputStream*/
            // Mở OutputStream thông qua connection
            OutputStream outputStream = connection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(query);

            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            writer.close();

            connection.connect();

                /* Bắt đầu đọc dữ liệu*/
            // Mở luồng nhận
            InputStream inputStream = connection.getInputStream();
            // Đọc luồng nhận
            InputStreamReader reader = new InputStreamReader(inputStream);

            // Tạo Buffer lưu TẠM dữ liệu mới đọc từ reader
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            data = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                data.append(line);
            }
            Log.d("Kiem tra", data.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
