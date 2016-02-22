/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
package com.roma3.infovideo.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roma3.infovideo.R;

/**
 * Created by enrico on 22/02/16.
 */
public class FacoltaAdapter extends RecyclerView.Adapter<FacoltaAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            mTextView = (TextView) cardView.findViewById(R.id.news_title_text_view);
        }
    }
}
