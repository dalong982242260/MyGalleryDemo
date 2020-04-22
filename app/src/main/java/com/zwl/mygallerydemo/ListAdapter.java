package com.zwl.mygallerydemo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author zwl
 * @date on 2020/4/22
 */
public class ListAdapter extends BaseQuickAdapter<String, ListAdapter.VideoHolder> {

    public ListAdapter(List<String> videoInfos) {
        super(R.layout.item_list, videoInfos);
    }

    @Override
    protected void convert(@NonNull VideoHolder videoHolder, String s) {
        videoHolder.itemTV.setText(s);
    }

    public class VideoHolder extends BaseViewHolder {

        TextView itemTV;

        public VideoHolder(View view) {
            super(view);
            itemTV = view.findViewById(R.id.item_tv);
        }
    }


}
