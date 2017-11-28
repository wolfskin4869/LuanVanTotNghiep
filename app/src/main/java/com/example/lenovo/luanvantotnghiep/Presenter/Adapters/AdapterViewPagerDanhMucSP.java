package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentLaptop;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentMobile;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentSanPhamMoi;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentKhuyenMai;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentTablet;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentTrademark;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class AdapterViewPagerDanhMucSP extends FragmentPagerAdapter{

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tittleFragment = new ArrayList<>();


    public AdapterViewPagerDanhMucSP(FragmentManager fm) {
        super(fm);
        fragmentList.add(new FragmentSanPhamMoi());
        fragmentList.add(new FragmentKhuyenMai());
        fragmentList.add(new FragmentMobile());
        fragmentList.add(new FragmentTablet());
        fragmentList.add(new FragmentLaptop());
        fragmentList.add(new FragmentTrademark());

        tittleFragment.add("Trang chủ");
        tittleFragment.add("Chương trình khuyến mãi");
        tittleFragment.add("Điện thoại di động");
        tittleFragment.add("Máy tính bảng");
        tittleFragment.add("Máy tính xách tay");
        tittleFragment.add("Thương hiệu lớn");
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tittleFragment.get(position);
    }
}
