package com.example.lenovo.luanvantotnghiep.View.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.DanhGia;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ThongSoKyThuat;
import com.example.lenovo.luanvantotnghiep.MyPublic.Server;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterDanhGia;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterViewPagerSlider;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicChiTietSP;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentSliderChiTietSanPham;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewChiTietSP;
import com.squareup.picasso.Picasso;


import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamActivity extends AppCompatActivity implements IViewChiTietSP, ViewPager.OnPageChangeListener, View.OnClickListener{

    Toolbar toolBar;
    ViewPager viewPager;
    PresenterLogicChiTietSP presenterLogicChiTietSP;
    TextView[] txtDots;
    LinearLayout layoutDots;
    RecyclerView recyclerDSDanhGia;
    Button btnMuaNgay;
    int maSP;
    List<Fragment> fragmentList;
    TextView txtTenSanPham, txtGiaSanPham, txtThongTinChiTiet, txtVietDanhGia, txtTatCaDG, txtGioHang, txtGiamGia;
    ImageView imgXemThem, imgHinhSanPham, imgThemVaoGioHang;
    LinearLayout lnThongSoKyThuat;
    Boolean kiemtraExpandChiTiet = false, onpause = false;
    SanPham sanPhamSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        viewPager = (ViewPager) findViewById(R.id.viewPagerSlider);
        layoutDots = (LinearLayout) findViewById(R.id.layoutDots);
        txtTenSanPham = (TextView) findViewById(R.id.txtTenSanPham);
        txtGiaSanPham = (TextView) findViewById(R.id.txtGiaSanPham);
        txtGiamGia = (TextView) findViewById(R.id.txtGiamGia);
        txtVietDanhGia = (TextView) findViewById(R.id.txtVietDanhGia);
        recyclerDSDanhGia = (RecyclerView) findViewById(R.id.recyclerDSDanhGia);
        txtTatCaDG = (TextView) findViewById(R.id.txtTatCaDanhGia);
        txtThongTinChiTiet = (TextView) findViewById(R.id.txtThongTinChiTiet);
        imgXemThem = (ImageView) findViewById(R.id.imgXemThem);
        imgHinhSanPham = (ImageView) findViewById(R.id.imgHinhSanPham);
        lnThongSoKyThuat = (LinearLayout) findViewById(R.id.lnThongSoKyThuat);
        imgThemVaoGioHang = (ImageView) findViewById(R.id.imgThemVaoGioHang);
        btnMuaNgay = (Button) findViewById(R.id.btnMuaNgay);


        maSP = getIntent().getIntExtra("MASANPHAM",0);
        presenterLogicChiTietSP = new PresenterLogicChiTietSP(this);
        presenterLogicChiTietSP.layChiTietSanPham(maSP);
        presenterLogicChiTietSP.layDanhSachDanhGiaSanPham(maSP,0);
        actionBar();
        txtVietDanhGia.setOnClickListener(this);
        txtTatCaDG.setOnClickListener(this);
        imgThemVaoGioHang.setOnClickListener(this);
        btnMuaNgay.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(onpause){
            PresenterLogicChiTietSP presenterLogicChiTietSP = new PresenterLogicChiTietSP();
            txtGioHang.setText(String.valueOf(presenterLogicChiTietSP.demSPCoTrongGioHang(this)));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        onpause = true;
    }

    private void actionBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolBar.setTitle(" ");
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

        MenuItem iGioHang = menu.findItem(R.id.itemGioHang);
        View giaoDienCustomGioHang = MenuItemCompat.getActionView(iGioHang);

        giaoDienCustomGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGioHang = new Intent(ChiTietSanPhamActivity.this,GioHangActivity.class);
                startActivity(iGioHang);
            }
        });
        txtGioHang = (TextView) giaoDienCustomGioHang.findViewById(R.id.txtSoLuongSPGioHang);
        txtGioHang.setText(String.valueOf(presenterLogicChiTietSP.demSPCoTrongGioHang(this)));

        return true;
    }

    @Override
    public void hienThiChiTietSP(final SanPham sanPham) {
        maSP = sanPham.getMaSanPham();

        sanPhamSQLite = sanPham;
        sanPhamSQLite.setSoLuongTon(sanPham.getSoLuongTon());

        txtTenSanPham.setText(sanPham.getTenSanPham());

        ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
        int giaTien = sanPham.getGiaSanPham();

        if(chiTietKhuyenMai != null){

            int phanTramKM = chiTietKhuyenMai.getPhanTramKM();
            if(phanTramKM != 0){

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                String giaCu = decimalFormat.format(giaTien);
                txtGiamGia.setVisibility(View.VISIBLE);
                txtGiamGia.setPaintFlags(txtGiamGia.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                txtGiamGia.setText("Giá cũ: "+giaCu+ " VNĐ");

                giaTien = giaTien - (giaTien*phanTramKM/100);
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGiaSanPham.setText("Giá: "+decimalFormat.format(giaTien)+ " VNĐ");

//        Log.d("HinhHinh",sanPham.getHinhLon());
        Picasso.with(this).load(Server.SERVER + sanPham.getHinhLon()).into(imgHinhSanPham);

        txtThongTinChiTiet.setText(sanPham.getThongTinSP().substring(0,80)+ " ...");

        if(sanPham.getThongTinSP().length() < 50){
            imgXemThem.setVisibility(View.GONE);
        }else{
            imgXemThem.setVisibility(View.VISIBLE);
            imgXemThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kiemtraExpandChiTiet = !kiemtraExpandChiTiet;
                    if(kiemtraExpandChiTiet){
                        // mở chi tiết
                        txtThongTinChiTiet.setText(sanPham.getThongTinSP());
                        imgXemThem.setImageDrawable(getKeyboardUpDown(R.drawable.ic_keyboard_arrow_up_black_24dp));
                    }else{
                        // đóng chi tiết
                        txtThongTinChiTiet.setText(sanPham.getThongTinSP().substring(0,80) + "......");
                        imgXemThem.setImageDrawable(getKeyboardUpDown(R.drawable.ic_keyboard_arrow_down_black_24dp));
                    }
                }
            });
        }

        List<ThongSoKyThuat> thongSoKyThuats = sanPham.getThongSoKyThuatList();





        if(thongSoKyThuats.size()!= 0){
            for(int i  = 0; i < thongSoKyThuats.size(); i++){

                LinearLayout lnTSKT1 = new LinearLayout(this);
                lnTSKT1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                lnTSKT1.setOrientation(LinearLayout.HORIZONTAL);

                TextView txtTenThongSo = new TextView(this);
                txtTenThongSo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 2.0f));
                txtTenThongSo.setText(thongSoKyThuats.get(i).getTenThongSo());
                txtTenThongSo.setPadding(10,0,0,0);

                TextView txtGiaTri = new TextView(this);
                txtGiaTri.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
                txtGiaTri.setText(thongSoKyThuats.get(i).getGiaTriThongSo());
                txtGiaTri.setPadding(0,0,5,0);

                lnTSKT1.addView(txtTenThongSo);
                lnTSKT1.addView(txtGiaTri);

                lnThongSoKyThuat.addView(lnTSKT1);
            }
        }else{

            LinearLayout lnTSKT2 = new LinearLayout(this);
            lnTSKT2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            lnTSKT2.setPadding(5,5,5,5);
            lnTSKT2.setOrientation(LinearLayout.HORIZONTAL);

            TextView txtNoData = new TextView(this);
            txtNoData.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            txtNoData.setText("Không có dữ  liệu");
            txtNoData.setGravity(View.TEXT_ALIGNMENT_CENTER);
            txtNoData.setPadding(5,5,5,5);
            lnTSKT2.addView(txtNoData);
            lnThongSoKyThuat.addView(lnTSKT2);
        }

    }

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
            FragmentSliderChiTietSanPham ctspFragment = new FragmentSliderChiTietSanPham();
            Bundle bundle = new Bundle();
            bundle.putString("LINKHINH", Server.SERVER + hinhAnhList[i]);
            Log.d("Mến", Server.SERVER +  hinhAnhList[i]);
            ctspFragment.setArguments(bundle);
            fragmentList.add(ctspFragment);
        }

        AdapterViewPagerSlider adapterViewPagerSlider = new AdapterViewPagerSlider(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapterViewPagerSlider);
        adapterViewPagerSlider.notifyDataSetChanged();
        addDotSlider(0);
        viewPager.addOnPageChangeListener(this);
    }

    private void addDotSlider(int currentPosition){
        txtDots = new TextView[fragmentList.size()];

        layoutDots.removeAllViews(); // làm sạch lại linear

        for(int i = 0; i < fragmentList.size(); i++){
            txtDots[i] = new TextView(this);
            txtDots[i].setText(Html.fromHtml("&#8226;"));
            txtDots[i].setTextSize(40);
            txtDots[i].setTextColor(getIdColor(R.color.colorLittleGray));
            layoutDots.addView(txtDots[i]);
        }

        txtDots[currentPosition].setTextColor(getIdColor(R.color.colorGray));
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
        addDotSlider(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){

            case R.id.txtVietDanhGia:
                Intent iThemDanhGia = new Intent(this, DanhGiaActivity.class);
                iThemDanhGia.putExtra("MASANPHAM", maSP);
                startActivity(iThemDanhGia);
                break;

            case  R.id.txtTatCaDanhGia:
                Intent iTatCaDanhGia = new Intent(ChiTietSanPhamActivity.this, TatCaDanhGiaActivity.class);
                iTatCaDanhGia.putExtra("MASANPHAM",maSP);
                startActivity(iTatCaDanhGia);
                break;

            case R.id.imgThemVaoGioHang:
                ImageView imageView = (ImageView) findViewById(R.id.imgHinhSanPham);
                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
                byte[] hinhGioHang = byteArrayOutputStream.toByteArray();

                sanPhamSQLite.setHinhSQLite(hinhGioHang);
                sanPhamSQLite.setSoLuongDat(1);
                presenterLogicChiTietSP.themGioHang(sanPhamSQLite, this);

                break;

            case R.id.btnMuaNgay:

                ImageView imageView1 = (ImageView) findViewById(R.id.imgHinhSanPham);
                Bitmap bitmap1 = ((BitmapDrawable)imageView1.getDrawable()).getBitmap();

                ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
                bitmap1.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream1);
                byte[] hinhGioHang1 = byteArrayOutputStream1.toByteArray();

                sanPhamSQLite.setHinhSQLite(hinhGioHang1);
                sanPhamSQLite.setSoLuongDat(1);
                presenterLogicChiTietSP.themGioHang(sanPhamSQLite,this);

                Intent iMuaNgay = new Intent(ChiTietSanPhamActivity.this, ThanhToanActivity.class);
                startActivity(iMuaNgay);
                break;


//            case R.id.imgThemYeuThich:
                /*ImageView imgHinhSPYeuThich = (ImageView) findViewById(R.id.imgHinhSanPham);
                Bitmap bitmapYeuThich = ((BitmapDrawable)imgHinhSPYeuThich.getDrawable()).getBitmap();

                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                bitmapYeuThich.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream2);
                byte[] hinhSPYeuThich = byteArrayOutputStream2.toByteArray();
                
                sanPhamSQLite.setHinhSQLite(hinhSPYeuThich);
                presenterLogicChiTietSP.themYeuThich(sanPhamSQLite);

                kiemtraYeuThich = !kiemtraYeuThich;
                if(kiemtraYeuThich){
                    imgThemYeuThich.setImageDrawable(getKeyboardUpDown(R.drawable.favorite));
                }else{
                    imgThemYeuThich.setImageDrawable(getKeyboardUpDown(R.drawable.favorite_border));
                }
                break;*/
        }
    }

    @Override
    public void hienThiDsDanhGia(List<DanhGia> danhGiaList) {
        AdapterDanhGia adapterDanhGia = new AdapterDanhGia(this,danhGiaList,3);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerDSDanhGia.setLayoutManager(layoutManager);
        recyclerDSDanhGia.setAdapter(adapterDanhGia);
        adapterDanhGia.notifyDataSetChanged();
    }

    @Override
    public void themGioHangThanhCong() {
        Toast.makeText(this, "Sản phảm đã được thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
        txtGioHang.setText(String.valueOf(presenterLogicChiTietSP.demSPCoTrongGioHang(this)));
    }

    @Override
    public void themGioHangThatBai() {
        Toast.makeText(this, "Sản phảm đã có trong giỏ hàng", Toast.LENGTH_SHORT).show();
    }
/*
    @Override
    public void themYeuThichThanhCong() {
        Toast.makeText(this, "Sản phảm đã được thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void themYeuThichThatBai() {
        Toast.makeText(this, "Sản phảm đã có trong danh sách yêu thích", Toast.LENGTH_SHORT).show();
    }*/
}
