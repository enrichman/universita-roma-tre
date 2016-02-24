/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
package com.roma3.infovideo.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roma3.infovideo.R;

/**
 * Created by enrico on 24/02/16.
 */
public class MenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }
}
