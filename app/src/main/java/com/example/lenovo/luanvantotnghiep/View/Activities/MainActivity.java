package com.example.lenovo.luanvantotnghiep.View.Activities;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Models.ModelDangNhap;
import com.example.lenovo.luanvantotnghiep.Presenter.Adapters.AdapterViewPagerDanhMucSP;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicChiTietSP;
import com.example.lenovo.luanvantotnghiep.Presenter.PresentersLogic.PresenterLogicDangNhap;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentMobile;
import com.example.lenovo.luanvantotnghiep.View.Fragments.FragmentTablet;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewTrangChu;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements IViewTrangChu,View.OnClickListener,
        GoogleApiClient.OnConnectionFailedListener, NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    PresenterLogicDangNhap presenterTrangChu;
    String tenNguoiDung = "";
    String emailNguoiDung = "";
    AccessToken accessToken;
    ModelDangNhap modelDangNhap;
    Menu menu;
    MenuItem itemDangNhap, itemDangXuat;
    GoogleApiClient mGoogleApiClient;
    GoogleSignInResult googleSignInResult;
    CircleImageView imgUser;
    TextView txtHoten, txtEmail, txtGioHang;
    Button btnSearch;
    View headerView;
    TabLayout tabDanhMuc;
    ViewPager viewPagerDanhMuc;
    AdapterViewPagerDanhMucSP adapter;
    boolean onpause = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        actionBar();


    }

    private void addEvents() {
        navigationView.setItemIconTintList(null);
        presenterTrangChu.getTenNguoiDungFaceBook();
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void addControls() {
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);
        txtHoten = (TextView) headerView.findViewById(R.id.txtHoten);
        txtEmail = (TextView) headerView.findViewById(R.id.txtEmail);
        imgUser = (CircleImageView) headerView.findViewById(R.id.imgUser);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        presenterTrangChu = new PresenterLogicDangNhap(this);
        modelDangNhap = new ModelDangNhap();
        mGoogleApiClient = modelDangNhap.layGoogleApiClient(this,this);

        tabDanhMuc = (TabLayout) findViewById(R.id.tabDanhMuc);
        viewPagerDanhMuc = (ViewPager) findViewById(R.id.viewPagerDanhMuc);
        adapter = new AdapterViewPagerDanhMucSP(getSupportFragmentManager());
        viewPagerDanhMuc.setAdapter(adapter);
        tabDanhMuc.setupWithViewPager(viewPagerDanhMuc);
        btnSearch.setOnClickListener(this);


    }

    private void actionBar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_trangchu, menu);
        this.menu = menu;

        MenuItem iGioHang = menu.findItem(R.id.itemGioHang);
        View giaoDienCustomGioHang = MenuItemCompat.getActionView(iGioHang);
        txtGioHang = (TextView) giaoDienCustomGioHang.findViewById(R.id.txtSoLuongSPGioHang);
        giaoDienCustomGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGioHang = new Intent(MainActivity.this,GioHangActivity.class);
                startActivity(iGioHang);
            }
        });
        PresenterLogicChiTietSP presenterLogicChiTietSP = new PresenterLogicChiTietSP();
        txtGioHang.setText(String.valueOf(presenterLogicChiTietSP.demSPCoTrongGioHang(this)));

        itemDangNhap = menu.findItem(R.id.iteDangNhap);
        itemDangXuat = menu.findItem(R.id.iteDangXuat);


        accessToken = presenterTrangChu.getTenNguoiDungFaceBook();
        googleSignInResult = modelDangNhap.layThongTinDNGoogle(mGoogleApiClient);
        if (accessToken != null) {
            GraphRequest graphRequest = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    try {
                        tenNguoiDung = object.getString("name");
                        emailNguoiDung = object.getString("email");
                        itemDangNhap.setTitle(tenNguoiDung);
                        itemDangNhap.setIcon(R.drawable.ic_face_black_24dp);
                        imgUser.setImageResource(R.drawable.user);
                        txtHoten.setText(tenNguoiDung);
                        txtEmail.setText(emailNguoiDung);
                    } catch (JSONException e) {

                    }
                }
            });

            Bundle parameter = new Bundle();
            parameter.putString("fields","name, email");
            graphRequest.setParameters(parameter);
            graphRequest.executeAsync();
        }

        String tennsd = modelDangNhap.layCatchDangNhap(this);
        if(!tennsd.equals("")){
            itemDangNhap.setTitle(tennsd);
            itemDangNhap.setIcon(R.drawable.ic_face_black_24dp);
            imgUser.setImageResource(R.drawable.user);
            txtHoten.setText(tennsd);
            txtEmail.setText("");
        }


        if(googleSignInResult != null){
            itemDangNhap.setTitle(googleSignInResult.getSignInAccount().getDisplayName());
            itemDangNhap.setIcon(R.drawable.ic_face_black_24dp);
            txtHoten.setText(googleSignInResult.getSignInAccount().getDisplayName());
            txtEmail.setText(googleSignInResult.getSignInAccount().getEmail());
            imgUser.setImageResource(R.drawable.user);
        }

        if(accessToken != null || googleSignInResult != null || !tennsd.equals("")){
            itemDangXuat.setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.iteDangNhap:
                if (accessToken == null && googleSignInResult == null && modelDangNhap.layCatchDangNhap(this).equals("")){
                    Intent iDangNhap = new Intent(this, DangNhapActivity.class);
                    startActivity(iDangNhap);
                }break;
            case R.id.iteDangXuat:
                if(accessToken != null){
                    LoginManager.getInstance().logOut();
                    txtHoten.setText("Tên người dùng");
                    txtEmail.setText("Emai / Facebook");
                    imgUser.setImageResource(R.drawable.account);
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                if( googleSignInResult!=null){
                    Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                    txtHoten.setText("Tên người dùng");
                    txtEmail.setText("Emai / Facebook");
                    imgUser.setImageResource(R.drawable.account);
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }

                if(!modelDangNhap.layCatchDangNhap(this).equals("")){
                    modelDangNhap.capNhatDuLieu(this,"");
                    txtHoten.setText("Tên người dùng");
                    txtEmail.setText("Emai / Facebook");
                    imgUser.setImageResource(R.drawable.account);
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                break;
        }
        return true;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itCart:
                Intent iCart = new Intent(this,GioHangActivity.class);
                startActivity(iCart);
                break;

            case R.id.itFavorite:
                Intent iFavorite = new Intent(this,YeuThichActivity.class);
                startActivity(iFavorite);
                break;

            case R.id.itAboutUs:
                Intent iAboutUs = new Intent(this,ThongTinUngDungActivity.class);
                startActivity(iAboutUs);
                break;

            case R.id.itExit:
                System.exit(0);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnSearch:
                Intent iSearch = new Intent(MainActivity.this, TimKiemActivity.class);
                startActivity(iSearch);
                break;
        }
    }
}

