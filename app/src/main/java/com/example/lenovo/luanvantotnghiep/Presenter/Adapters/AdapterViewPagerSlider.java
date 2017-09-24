package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Lenovo on 9/12/2017.
 */

public class AdapterViewPagerSlider extends FragmentStatePagerAdapter {

    List<Fragment> fragments;

    public AdapterViewPagerSlider(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragments = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
