package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterViewPagerDangNhap;
import com.example.lenovo.luanvantotnghiep.R;

public class DangNhapDangKyActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        tabLayout = (TabLayout) findViewById(R.id.tabDangNhap);
        viewPager = (ViewPager) findViewById(R.id.pagerDangNhap);
        toolbar = (Toolbar) findViewById(R.id.toolbarDangNhap);

        setSupportActionBar(toolbar);

        AdapterViewPagerDangNhap adapterViewPagerDangNhap = new AdapterViewPagerDangNhap(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPagerDangNhap);
        adapterViewPagerDangNhap.notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager);
    }
}