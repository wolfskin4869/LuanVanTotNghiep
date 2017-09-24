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

public class AdapterTablet extends RecyclerView.Adapter<AdapterTablet.ViewHolderTablet> {

    Context context;
    List<SanPham> sanPhams;

    public AdapterTablet(Context context, List<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    public class ViewHolderTablet extends RecyclerView.ViewHolder {

        TextView txtTenTablet, txtGiaTablet;
        ImageView imgHinhTablet;
        ProgressBar progressBarTablet;
        public ViewHolderTablet(View itemView) {
            super(itemView);
            txtTenTablet = (TextView) itemView.findViewById(R.id.txtTenTablet);
            txtGiaTablet = (TextView) itemView.findViewById(R.id.txtGiaTablet);
            imgHinhTablet = (ImageView) itemView.findViewById(R.id.imgHinhTablet);
            progressBarTablet = (ProgressBar) itemView.findViewById(R.id.progressBarTablet);
        }
    }

    @Override
    public ViewHolderTablet onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recyclerview_tablet,parent,false);
        ViewHolderTablet viewHolder = new ViewHolderTablet(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderTablet holder, int position) {
        SanPham sanPham = sanPhams.get(position);
        holder.txtTenTablet.setText(sanPham.getTenSanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGiaTablet.setText("Giá: "+decimalFormat.format(sanPham.getGiaSanPham())+ " VNĐ");
        Picasso.with(context).load(sanPham.getHinhLon()).into(holder.imgHinhTablet, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBarTablet.setVisibility(View.GONE);
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
