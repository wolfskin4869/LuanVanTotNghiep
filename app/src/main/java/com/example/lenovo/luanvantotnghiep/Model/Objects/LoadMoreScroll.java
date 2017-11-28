package com.example.lenovo.luanvantotnghiep.Model.Objects;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lenovo.luanvantotnghiep.Model.Objects.ILoadMore;

/**
 * Created by Lenovo S410p on 8/5/2016.
 */
public class LoadMoreScroll extends RecyclerView.OnScrollListener {
    int itemandautien = 0;
    int tongitem = 0;
    int itemloadtruoc = 10;
    RecyclerView.LayoutManager layoutManager;
    ILoadMore iLoadMore;

    public LoadMoreScroll(RecyclerView.LayoutManager layoutManager,ILoadMore iLoadMore){
        this.layoutManager = layoutManager;
        this.iLoadMore = iLoadMore;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        tongitem = layoutManager.getItemCount();

        if(layoutManager instanceof LinearLayoutManager){
            itemandautien = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }else if(layoutManager instanceof GridLayoutManager){
            itemandautien = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }

        if(tongitem <= (itemandautien + itemloadtruoc)){
            iLoadMore.loadMore(tongitem);
        }

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }
}
