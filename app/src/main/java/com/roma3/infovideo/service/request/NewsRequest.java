/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service.request;

import com.roma3.infovideo.model.News;
import com.roma3.infovideo.service.Client;
import com.roma3.infovideo.service.RemoteRequest;
import com.roma3.infovideo.service.RequestListener;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.util.List;

public class NewsRequest extends RemoteRequest<List<News>> {

    public NewsRequest(RequestListener<List<News>> listener) {
        super(listener);
    }

    @Override
    public OkHttpClient getClient() {
        return Client.getInstance();
    }

    @Override
    public Request buildRequest() {
        Request.Builder builder = new Request.Builder()
                .url("http://mobile.uniroma3.it/ateneo.rss");

        return builder.build();
    }

    @Override
    public List<News> parse(String body) {
        return null;
    }
}
