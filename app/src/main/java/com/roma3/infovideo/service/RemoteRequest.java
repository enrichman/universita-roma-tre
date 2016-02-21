/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public abstract class RemoteRequest<T> {

    protected RequestListener<T> listener;

    public RemoteRequest(RequestListener<T> listener) {
        this.listener = listener;
    }

    public void execute() {
        Request request = buildRequest();
        getClient().newCall(request).enqueue(new Callback() {

            public void onFailure(Request request, IOException e) {
                handleException(e);
            }

            public void onResponse(Response response) throws IOException {
                handleResponse(response);
            }
        });
    }

    public abstract Request buildRequest();

    public abstract OkHttpClient getClient();

    public abstract T parse(String body);

    private void handleResponse(Response response) {
        try {
            String jsonResp = response.body().string();

            if (response.isSuccessful()) {
                T resp = parse(jsonResp);
                if (listener != null)
                    listener.onSuccess(resp);

            }

        } catch (IOException e) {
            handleException(e);
        }
    }

    private void handleException(IOException e) {
        if (listener != null)
            listener.onException();
    }
}
