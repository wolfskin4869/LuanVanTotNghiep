package com.example.lenovo.luanvantotnghiep.View.Home;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.DangNhap.DangNhapActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBar;
    DrawerLayout drawerLayout;
    ViewFlipper viewFlipper;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        actionBar();
        actionViewFlipper();
    }

    private void addEvents() {
        navigationView.setItemIconTintList(null);
    }

    private void actionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/dautruongssj7prime.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/galaxys8.png");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/huaweimediated.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/laptopasuslenovohp.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/lenovo_dulich.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/macbookairpro.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/muaonline.png");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/smartphonehong.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/tablet.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/mtb.png");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/applechauau.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/applesh.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/laptopwavealpha.jpg");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/galaxytab3.png");
        mangquangcao.add("http://192.168.0.111/luanvantotnghiep/hinhquangcao/iphone.png");
        for(int i = 0; i < mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void addControls() {
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
    }

    private void actionBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trangchu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.iteDangNhap:
                Intent iDangNhap = new Intent(this, DangNhapActivity.class);
                startActivity(iDangNhap);
        }
        return true;
    }
}

