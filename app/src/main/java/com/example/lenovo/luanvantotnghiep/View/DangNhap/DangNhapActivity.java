package com.example.lenovo.luanvantotnghiep.View.DangNhap;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.lenovo.luanvantotnghiep.Presenter.Adapter.ViewPagerDangNhapAdapter;
import com.example.lenovo.luanvantotnghiep.R;
import com.facebook.FacebookSdk;

public class DangNhapActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    ViewPagerDangNhapAdapter viewPagerDangNhapAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        addControls();
    }

    private void addControls() {
        tabLayout = (TabLayout) findViewById(R.id.tabDangNhap);
        viewPager = (ViewPager) findViewById(R.id.pagerDangNhap);
        toolbar = (Toolbar) findViewById(R.id.toolbarDangNhap);
        setSupportActionBar(toolbar);
        viewPagerDangNhapAdapter = new ViewPagerDangNhapAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerDangNhapAdapter);
        viewPagerDangNhapAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);
    }
}
