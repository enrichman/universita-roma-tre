/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service;

import com.squareup.okhttp.OkHttpClient;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class Client {

    private static OkHttpClient okInstance;

    public static OkHttpClient getInstance() {
        if(okInstance == null) {
            okInstance = new OkHttpClient();
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            okInstance.setCookieHandler(cookieManager);
        }
        return okInstance;
    }

}
