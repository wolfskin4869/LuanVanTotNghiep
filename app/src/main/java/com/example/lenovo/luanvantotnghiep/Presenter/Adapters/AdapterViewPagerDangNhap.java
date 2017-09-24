package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.luanvantotnghiep.View.Fragments.DangKyFragment;
import com.example.lenovo.luanvantotnghiep.View.Fragments.DangNhapFragment;

/**
 * Created by Lenovo on 6/10/2017.
 */

public class AdapterViewPagerDangNhap extends FragmentPagerAdapter {

    public AdapterViewPagerDangNhap(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                DangNhapFragment dangNhapFragment = new DangNhapFragment();
                return dangNhapFragment;
            case 1 :
                DangKyFragment dangKyFragment = new DangKyFragment();
                return dangKyFragment;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Đăng nhập";
            case 1 :
                return "Đăng ký";
            default: return null;
        }
    }
}
