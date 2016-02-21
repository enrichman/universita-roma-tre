/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service;

public interface RequestListener<T> {
    void onSuccess(T result);
    void onError();
    void onException();
}
