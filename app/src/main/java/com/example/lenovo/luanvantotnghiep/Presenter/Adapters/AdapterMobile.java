package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.R;
import com.example.lenovo.luanvantotnghiep.View.Activities.ChiTietSanPhamActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 6/22/2017.
 */

public class AdapterMobile extends RecyclerView.Adapter<AdapterMobile.ViewHolderMobile> {

    Context context;
    List<SanPham> sanPhams;
    int layout;

    public AdapterMobile(Context context, List<SanPham> sanPhams, int layout) {
        this.context = context;
        this.sanPhams = sanPhams;
        this.layout = layout;
    }

    public class ViewHolderMobile extends RecyclerView.ViewHolder {
        TextView txtTenMobile, txtGiaMobile;
        ImageView imgHinhMobile;
        ProgressBar progressBarMobile;
        CardView cardView;
        public ViewHolderMobile(View itemView) {
            super(itemView);
            txtTenMobile = (TextView) itemView.findViewById(R.id.txtTenMobile);
            txtGiaMobile = (TextView) itemView.findViewById(R.id.txtGiaMobile);
            imgHinhMobile = (ImageView) itemView.findViewById(R.id.imgHinhMobile);
            progressBarMobile = (ProgressBar) itemView.findViewById(R.id.progressBarMobile);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public AdapterMobile.ViewHolderMobile onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout,parent,false);
        ViewHolderMobile viewHolder = new ViewHolderMobile(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterMobile.ViewHolderMobile holder, int position) {
        SanPham sanPham = sanPhams.get(position);
        holder.txtTenMobile.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaMobile.setText("Giá: "+decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");
        Picasso.with(context).load(sanPham.getHinhLon()).into(holder.imgHinhMobile, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBarMobile.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });

        holder.cardView.setTag(sanPham.getMaSanPham());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iChiTietSanPham = new Intent(context, ChiTietSanPhamActivity.class);
                iChiTietSanPham.putExtra("MASANPHAM", (String)v.getTag());
                context.startActivity(iChiTietSanPham);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }


}
