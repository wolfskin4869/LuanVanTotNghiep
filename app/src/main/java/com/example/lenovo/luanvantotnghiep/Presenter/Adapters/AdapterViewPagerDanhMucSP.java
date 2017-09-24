package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lenovo.luanvantotnghiep.View.Fragments.LaptopFragment;
import com.example.lenovo.luanvantotnghiep.View.Fragments.MobileFragment;
import com.example.lenovo.luanvantotnghiep.View.Fragments.NewProductFragment;
import com.example.lenovo.luanvantotnghiep.View.Fragments.SaleFragment;
import com.example.lenovo.luanvantotnghiep.View.Fragments.TabletFragment;
import com.example.lenovo.luanvantotnghiep.View.Fragments.TrademarkFragment;

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
        fragmentList.add(new NewProductFragment());
        fragmentList.add(new MobileFragment());
        fragmentList.add(new TabletFragment());
        fragmentList.add(new LaptopFragment());
        fragmentList.add(new TrademarkFragment());
        fragmentList.add(new SaleFragment());

        tittleFragment.add("Trang chủ");
        tittleFragment.add("Điện thoại di động");
        tittleFragment.add("Máy tính bảng");
        tittleFragment.add("Máy tính xách tay");
        tittleFragment.add("Thương hiệu lớn");
        tittleFragment.add("Khuyến mãi HOT");
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
