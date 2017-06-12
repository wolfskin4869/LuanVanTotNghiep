package com.example.lenovo.luanvantotnghiep.View.SpashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Home.MainActivity;


public class SplashScreenActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView txtPercent;
    private int status = 0;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtPercent = (TextView) findViewById(R.id.txtPercent);

        progressBar.setProgress(0);
        progressBar.setMax(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(status < 100){
                    status = updateStatus();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(status);
                            txtPercent.setText(status+" %");
                        }
                    });
                }
                if(status >= 100){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                txtPercent.setText("Starting application...");
                            }
                        });
                        Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    status = 0;
                }
            }
        }).start();
    }

    private int updateStatus() {
        if (status<100){
            status++;
        }
        return status;
    }
}
