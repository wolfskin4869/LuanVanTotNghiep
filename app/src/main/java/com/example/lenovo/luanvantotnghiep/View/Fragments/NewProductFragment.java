package com.example.lenovo.luanvantotnghiep.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterSPMoi;
import com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters.PresenterSPMoi;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewSPMoi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 6/26/2017.
 */

public class NewProductFragment extends Fragment implements IViewSPMoi {

    AdapterSPMoi adapterSPMoi;
    RecyclerView recyclerNewProduct;
    PresenterSPMoi presenterSPMoi;
    ViewFlipper viewFlipper;
    List<SanPham> sanPhamList;

    public NewProductFragment() {
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_newproducts_fragment,container, false);
        recyclerNewProduct = (RecyclerView) view.findViewById(R.id.recyclerNewProduct);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
        actionViewFlipper();
        presenterSPMoi = new PresenterSPMoi(this);
        presenterSPMoi.layDanhSachSPMoi();
        return  view ;

    }

    @Override
    public void hienThiDanhSachSPMoi(List<SanPham> sanPhams) {
        sanPhamList = sanPhams;
        adapterSPMoi = new AdapterSPMoi(getActivity(),sanPhamList);
        recyclerNewProduct.setHasFixedSize(true);
        recyclerNewProduct.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerNewProduct.setAdapter(adapterSPMoi);
        adapterSPMoi.notifyDataSetChanged();
    }

    private void actionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cdn4.tgdd.vn/Files/2017/03/12/959870/laptop-giam-5-760367-665x320.png");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2017/04/05/968755/len-doi-iphone-hn-760-367-665x320.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2016/09/17/888387/dmx-macbook-760-367.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2016/07/31/867631/tablet-760-367.jpg");
        mangquangcao.add("https://cdn2.tgdd.vn/Files/2017/02/28/955574/tgdd-lapbig-760-367a-665x320.png");
        mangquangcao.add("https://cdn4.tgdd.vn/Files/2017/03/09/958924/xa-hang-760-3671-665x320.png");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2016/10/01/894093/galaxy-tra-gop-800-300.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2016/06/02/836581/baitin-yoga300.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2014/04/16/542341/Samsung-Tab-4-8-1.jpg");
        mangquangcao.add("https://cdn2.tgdd.vn/Files/2017/06/05/989556/iphone-hn-big-t5-2-760-367-665x320.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2017/06/16/993287/dell-he%CC%80-vui-nho%CC%A3%CC%82n-ro%CC%A3%CC%82n-qua%CC%80-xinh-760-367.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2017/04/30/977964/uu-dai-galaxy-s8-760-367-665x320.jpg");
        mangquangcao.add("https://cdn2.tgdd.vn/Files/2017/05/31/987957/laptop-thang-6-760-367-a-665x320.jpg");
        mangquangcao.add("https://cdn1.tgdd.vn/Files/2017/05/16/982751/thu-cu-htc-760-367-665x320.jpg");
        mangquangcao.add("https://cdn3.tgdd.vn/Files/2017/01/20/939922/iphone-gia-tot-760-367-665x320.png");
        mangquangcao.add("https://cdn4.tgdd.vn/Files/2014/03/19/537755/640-384-180x120.jpg");
        for(int i = 0; i < mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }
}
