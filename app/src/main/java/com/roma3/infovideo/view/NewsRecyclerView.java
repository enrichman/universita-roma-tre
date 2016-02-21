/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.roma3.infovideo.model.News;
import com.roma3.infovideo.view.adapter.NewsAdapter;

import java.util.List;

public class NewsRecyclerView extends RecyclerView {

    private NewsAdapter mAdapter;

    public NewsRecyclerView(Context context) {
        super(context);
        init();
    }

    public NewsRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NewsRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mAdapter = new NewsAdapter();
        setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        setAdapter(mAdapter);
    }

    public void setNews(List<News> newsList) {
        mAdapter.setNewsList(newsList);
    }
}
