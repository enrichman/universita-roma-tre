/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.controller;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;
import com.roma3.infovideo.R;
import com.roma3.infovideo.model.News;
import com.roma3.infovideo.view.NewsRecyclerView;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private NewsRecyclerView mListView;

    private NewsCallback newsCallback = new NewsCallback();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        mListView = (NewsRecyclerView) findViewById(R.id.news_list_view);

        refreshContent();
    }

    private void refreshContent() {
        mSwipeRefreshLayout.setRefreshing(true);

        PkRSS.with(NewsActivity.this)
                .load("http://mobile.uniroma3.it/ateneo.rss")
                .callback(newsCallback).async();
    }

    private List<News> parseNews(List<Article> articleList) {

        List<News> newsList = new ArrayList<>();
        for(Article article : articleList) {

            News news = new News();

            String title = StringEscapeUtils.unescapeHtml4(article.getTitle());
            news.setTitle(title);

            // StringEscapeUtils.unescapeHtml4(article.getDescription());

            newsList.add(news);
        }

        return newsList;
    }

    private class NewsCallback implements Callback {

        @Override
        public void onPreload() { /* do nothing */ }

        @Override
        public void onLoaded(List<Article> newArticles) {

            List<News> newsList = parseNews(newArticles);
            mListView.setNews(newsList);

            mSwipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onLoadFailed() {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

}