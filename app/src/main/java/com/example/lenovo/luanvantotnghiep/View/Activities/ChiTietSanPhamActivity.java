package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ThongSoKyThuat;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterViewPagerSlider;
import com.example.lenovo.luanvantotnghiep.Presenter.Logic_Presenters.PresenterChiTietSP;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Fragments.SliderCTSPFragment;
import com.example.lenovo.luanvantotnghiep.View.Interface_Views.IViewChiTietSP;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamActivity extends AppCompatActivity implements IViewChiTietSP, ViewPager.OnPageChangeListener{

    Toolbar toolBar;
    ViewPager viewPager;
    PresenterChiTietSP presenterChiTietSP;
    TextView[] txtDots;
    LinearLayout layoutDots;
    String maSP;
    List<Fragment> fragmentList;
    TextView txtTenSanPham, txtGiaSanPham, txtThongTinChiTiet;
    ImageView imgXemThem;
    LinearLayout lnThongSoKyThuat;
    Boolean kiemtraExpandChiTiet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        viewPager = (ViewPager) findViewById(R.id.viewPagerSlider);
        layoutDots = (LinearLayout) findViewById(R.id.layoutDots);
        txtTenSanPham = (TextView) findViewById(R.id.txtTenSanPham);
        txtGiaSanPham = (TextView) findViewById(R.id.txtGiaSanPham);
        txtThongTinChiTiet = (TextView) findViewById(R.id.txtThongTinChiTiet);
        imgXemThem = (ImageView) findViewById(R.id.imgXemThem);
        lnThongSoKyThuat = (LinearLayout) findViewById(R.id.lnThongSoKyThuat);

        maSP = getIntent().getStringExtra("MASANPHAM");
        presenterChiTietSP = new PresenterChiTietSP(this);
        presenterChiTietSP.layChiTietSanPham(maSP);
        actionBar();
    }

    private void actionBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if ( id == android.R.id.home ) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_trangchu,menu);
        return true;
    }

//    @Override
//    public void hienThiChiTietSP(final SanPham sanPham) {
//        txtTenSanPham.setText(sanPham.getTenSanPham());
//        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        txtGiaSanPham.setText(decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");
//        txtThongTinChiTiet.setText(sanPham.getThongTinSP().substring(0,100));
//
//        if(sanPham.getThongTinSP().length() < 100){
//            imgXemThem.setVisibility(View.GONE);
//        }else{
//            imgXemThem.setVisibility(View.VISIBLE);
//            imgXemThem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    kiemtraExpandChiTiet = !kiemtraExpandChiTiet;
//                    if(kiemtraExpandChiTiet){
//                        // mở chi tiết
//                        txtThongTinChiTiet.setText(sanPham.getThongTinSP());
//                        imgXemThem.setImageDrawable(getKeyboardUpDown(R.drawable.ic_keyboard_arrow_up_black_24dp));
//                    }else{
//                        // đóng chi tiết
//                        txtThongTinChiTiet.setText(sanPham.getThongTinSP().substring(0,100));
//                        imgXemThem.setImageDrawable(getKeyboardUpDown(R.drawable.ic_keyboard_arrow_down_black_24dp));
//                    }
//                }
//            });
//        }
//
//        List<ThongSoKyThuat> thongSoKyThuats = sanPham.getThongSoKyThuatList();
//
//        for(int i  = 0; i < thongSoKyThuats.size(); i++){
//            LinearLayout lnTSKT = new LinearLayout(this);
//            lnTSKT.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            lnTSKT.setOrientation(LinearLayout.HORIZONTAL);
//
//            TextView txtTenThongSo = new TextView(this);
//            txtTenThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
//            txtTenThongSo.setText(thongSoKyThuats.get(i).getTenThongSo());
//
//            TextView txtGiaTri = new TextView(this);
//            txtGiaTri.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
//            txtGiaTri.setText(thongSoKyThuats.get(i).getGiaTriThongSo());
//
//            lnTSKT.addView(txtTenThongSo);
//            lnTSKT.addView(txtGiaTri);
//
//            lnThongSoKyThuat.addView(lnTSKT);
//        }
//    }

    private Drawable getKeyboardUpDown(int idDrawalble){
        Drawable drawable;
        if(Build.VERSION.SDK_INT > 21){
            drawable = ContextCompat.getDrawable(this, idDrawalble);
        }else{
            drawable = getResources().getDrawable(idDrawalble);
        }
        return drawable;

    }

    @Override
    public void hienThiSlider(String[] hinhAnhList) {
        fragmentList = new ArrayList<>();

        for(int i = 0; i < hinhAnhList.length ; i++){
            SliderCTSPFragment ctspFragment = new SliderCTSPFragment();
            Bundle bundle = new Bundle();
            bundle.putString("LINKHINH", Server.SERVER + hinhAnhList[i]);
            ctspFragment.setArguments(bundle);
            fragmentList.add(ctspFragment);
        }

        AdapterViewPagerSlider adapterViewPagerSlider = new AdapterViewPagerSlider(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapterViewPagerSlider);
        adapterViewPagerSlider.notifyDataSetChanged();
        themDotSlider(0);
        viewPager.addOnPageChangeListener(this);
    }

    private void themDotSlider(int vitrihientai){
        txtDots = new TextView[fragmentList.size()];

        layoutDots.removeAllViews(); // làm sạch lại linear

        for(int i = 0; i < fragmentList.size(); i++){
            txtDots[i] = new TextView(this);
            txtDots[i].setText(Html.fromHtml("&#8226;"));
            txtDots[i].setTextSize(40);
            txtDots[i].setTextColor(getIdColor(R.color.colorLittleGray));
            layoutDots.addView(txtDots[i]);
        }

        txtDots[vitrihientai].setTextColor(getIdColor(R.color.colorGray));
    }

    private int getIdColor(int idcolor){
        int color = 0;
        if(Build.VERSION.SDK_INT > 21){
            color = ContextCompat.getColor(this, idcolor);
        }else{
            color = getResources().getColor(idcolor);
        }
        return color;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        themDotSlider(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
