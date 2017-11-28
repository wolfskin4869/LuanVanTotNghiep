package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.SQLite.ModelGioHang;
import com.example.lenovo.luanvantotnghiep.Model.Objects.ChiTietKhuyenMai;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.Model.SQLite.ModelYeuThich;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.IViews.IViewYeuThich;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 11/18/2017.
 */

public class AdapterYeuThich extends RecyclerView.Adapter<AdapterYeuThich.ViewHolderYeuThich> {

    Context context;
    List<SanPham> sanPhamList;
    ModelYeuThich modelYeuThich;
    IViewYeuThich iViewYeuThich;

    public AdapterYeuThich(Context context, List<SanPham> sanPhamList, IViewYeuThich iViewYeuThich) {
        this.context = context;
        this.iViewYeuThich = iViewYeuThich;
        this.sanPhamList = sanPhamList;
        modelYeuThich = new ModelYeuThich();
        modelYeuThich.moKetNoi(context);
    }

    public class ViewHolderYeuThich extends RecyclerView.ViewHolder {

        TextView txtTenSanPham, txtGiaSanPham, txtGiamGia;
        ImageView imgHinhSanPham, imgXoaSanPham;
        Button btnThemVaoGioHang;
        public ViewHolderYeuThich(View itemView) {
            super(itemView);
            txtTenSanPham = (TextView) itemView.findViewById(R.id.txtTenSanPham);
            txtGiaSanPham = (TextView) itemView.findViewById(R.id.txtGiaSanPham);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtGiamGia);
            imgHinhSanPham = (ImageView) itemView.findViewById(R.id.imgHinhSanPham);
            imgXoaSanPham = (ImageView) itemView.findViewById(R.id.imgXoaSanPham);
            btnThemVaoGioHang = (Button) itemView.findViewById(R.id.btnThemVaoGioHang);
        }
    }

    @Override
    public ViewHolderYeuThich onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_recyclerview_yeu_thich,viewGroup,false);
        AdapterYeuThich.ViewHolderYeuThich viewHolderYeuThich = new ViewHolderYeuThich(view);
        return viewHolderYeuThich;
    }

    @Override
    public void onBindViewHolder(ViewHolderYeuThich holder, final int i) {
        final SanPham sanPham = sanPhamList.get(i);
        final ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();

        holder.txtTenSanPham.setText(sanPham.getTenSanPham());

        int giaTien = sanPham.getGiaSanPham();
        if(chiTietKhuyenMai != null){
            int phanTramKM = chiTietKhuyenMai.getPhanTramKM();

            if(phanTramKM > 0){ // Nếu có phần trăm giảm giá

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                String giaSP = decimalFormat.format(giaTien);

                holder.txtGiamGia.setVisibility(View.VISIBLE);
                holder.txtGiamGia.setPaintFlags(holder.txtGiamGia.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                holder.txtGiamGia.setText("Giá cũ: "+giaSP+ " VNĐ");

                giaTien = giaTien - (giaTien*phanTramKM/100);

            }else {
                holder.txtGiamGia.setVisibility(View.GONE);
            }
        }
        DecimalFormat format = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá: "+format.format(giaTien)+ " VNĐ");

        byte[] hinhSanPham = sanPham.getHinhSQLite();
        Bitmap bitmapHinhSP = BitmapFactory.decodeByteArray(hinhSanPham,0,hinhSanPham.length);
        holder.imgHinhSanPham.setImageBitmap(bitmapHinhSP);

        holder.imgXoaSanPham.setTag(sanPham.getMaSanPham());
        holder.imgXoaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelYeuThich modelYeuThich = new ModelYeuThich();
                modelYeuThich.moKetNoi(context);
                modelYeuThich.xoaSanPhamYeuThich((String) v.getTag());
                sanPhamList.remove(i);
                notifyDataSetChanged();
            }
        });

        holder.btnThemVaoGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelGioHang modelGioHang = new ModelGioHang();
                modelGioHang.moKetNoi(context);
                boolean kiemtra = modelGioHang.themGioHang(sanPham);
                if(kiemtra){
                    /*Toast.makeText(context, "Thêm giỏ hàng thành công", Toast.LENGTH_SHORT).show();*/
                    iViewYeuThich.themVaoGioHangThanhCong();
                }else {
                    /*Toast.makeText(context, "Thêm giỏ hàng thất bại", Toast.LENGTH_SHORT).show();*/
                    iViewYeuThich.themVaoGioHangThatBai();
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

}
