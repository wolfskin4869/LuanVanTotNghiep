package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.luanvantotnghiep.Model.GioHang.ModelGioHang;
import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 10/22/2017.
 */

public class AdapterGioHang extends RecyclerView.Adapter<AdapterGioHang.ViewHolderGioHang> {


    Context context;
    List<SanPham> sanPhamList;

    public AdapterGioHang(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }

    public class ViewHolderGioHang extends RecyclerView.ViewHolder {
        TextView txtTenSanPham, txtGiaSanPham;
        ImageView imgHinhSanPham, imgXoaSanPham;
        public ViewHolderGioHang(View itemView) {
            super(itemView);
            txtTenSanPham = (TextView) itemView.findViewById(R.id.txtTenSanPham);
            txtGiaSanPham = (TextView) itemView.findViewById(R.id.txtGiaSanPham);
            imgHinhSanPham = (ImageView) itemView.findViewById(R.id.imgHinhSanPham);
            imgXoaSanPham = (ImageView) itemView.findViewById(R.id.imgXoaSanPham);
        }
    }

    @Override
    public ViewHolderGioHang onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_gio_hang,parent,false);
        ViewHolderGioHang viewHolderGioHang = new ViewHolderGioHang(view);
        return viewHolderGioHang;
    }

    @Override
    public void onBindViewHolder(final ViewHolderGioHang holder, final int position) {
        SanPham sanPham = sanPhamList.get(position);
        holder.txtTenSanPham.setMaxLines(1);
        holder.txtTenSanPham.setEllipsize(TextUtils.TruncateAt.END);
        holder.txtTenSanPham.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaSanPham.setText("Giá: "+decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");
        byte[] hinhSanPham = sanPham.getHinhgiohang();
        Bitmap bitmapHinhSP = BitmapFactory.decodeByteArray(hinhSanPham,0,hinhSanPham.length);
        holder.imgHinhSanPham.setImageBitmap(bitmapHinhSP);

        holder.imgXoaSanPham.setTag(sanPham.getMaSanPham());
        holder.imgXoaSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelGioHang modelGioHang = new ModelGioHang();
                modelGioHang.moKetNoi(context);
                modelGioHang.xoaSanPhamTrongGioHang((String) v.getTag());
                sanPhamList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }


}
