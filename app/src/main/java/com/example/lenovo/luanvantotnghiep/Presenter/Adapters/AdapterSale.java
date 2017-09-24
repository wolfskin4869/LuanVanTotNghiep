package com.example.lenovo.luanvantotnghiep.Presenter.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.lenovo.luanvantotnghiep.Model.Objects.KhuyenMai;
import com.example.lenovo.luanvantotnghiep.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Lenovo on 6/23/2017.
 */

public class AdapterSale extends RecyclerView.Adapter<AdapterSale.ViewHolderSale> {

    Context context;
    List<KhuyenMai> khuyenMais;

    public AdapterSale(Context context, List<KhuyenMai> khuyenMais) {
        this.context = context;
        this.khuyenMais = khuyenMais;
    }

    public class ViewHolderSale extends RecyclerView.ViewHolder {

        ImageView imgHinhSale;
        ProgressBar progressBarSale;
        public ViewHolderSale(View itemView) {
            super(itemView);
            imgHinhSale = (ImageView) itemView.findViewById(R.id.imgHinhSale);
            progressBarSale = (ProgressBar) itemView.findViewById(R.id.progressBarSale);
        }
    }

    @Override
    public ViewHolderSale onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recyclerview_sale,parent,false);
        ViewHolderSale viewHolder = new ViewHolderSale(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolderSale holder, int position) {
        KhuyenMai khuyenMai = khuyenMais.get(position);
        Picasso.with(context).load(khuyenMai.getHinhKhuyenMai()).into(holder.imgHinhSale, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBarSale.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return khuyenMais.size();
    }

}
