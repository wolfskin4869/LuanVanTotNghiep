package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.luanvantotnghiep.Model.Objects.SanPham;
import com.example.lenovo.luanvantotnghiep.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Lenovo on 6/23/2017.
 */

public class AdapterLaptop extends RecyclerView.Adapter<AdapterLaptop.ViewHolderLaptop> {

    Context context;
    List<SanPham> sanPhams;

    public AdapterLaptop(Context context, List<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    public class ViewHolderLaptop extends RecyclerView.ViewHolder {

        TextView txtTenLaptop, txtGiaLaptop;
        ImageView imgHinhLaptop;
        ProgressBar progressBarLaptop;
        public ViewHolderLaptop(View itemView) {
            super(itemView);
            txtTenLaptop = (TextView) itemView.findViewById(R.id.txtTenLaptop);
            txtGiaLaptop = (TextView) itemView.findViewById(R.id.txtGiaLaptop);
            imgHinhLaptop = (ImageView) itemView.findViewById(R.id.imgHinhLaptop);
            progressBarLaptop = (ProgressBar) itemView.findViewById(R.id.progressBarLaptop);
        }
    }

    @Override
    public ViewHolderLaptop onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recyclerview_laptop,parent,false);
        ViewHolderLaptop viewHolder = new ViewHolderLaptop(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderLaptop holder, int position) {
        SanPham sanPham = sanPhams.get(position);
        holder.txtTenLaptop.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaLaptop.setText("Giá: "+decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");
        Picasso.with(context).load(sanPham.getHinhLon()).into(holder.imgHinhLaptop, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBarLaptop.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return sanPhams.size();
    }

}
