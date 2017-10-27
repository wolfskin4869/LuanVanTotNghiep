package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.luanvantotnghiep.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Lenovo on 9/12/2017.
 */

public class FragmentCTSPSlider extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_slider_chitietsanpham, container, false);
        Bundle bundle = getArguments();
        String linkHinh = bundle.getString("LINKHINH");
        ImageView imageView = (ImageView) view.findViewById(R.id.imgHinhSlider);
        Picasso.with(getContext()).load(linkHinh).into(imageView);
        return view;
    }
}
