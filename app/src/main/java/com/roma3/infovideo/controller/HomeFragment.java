/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
package com.roma3.infovideo.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roma3.infovideo.R;
import com.roma3.infovideo.service.LessonRequest;

/**
 * Created by enrico on 23/02/16.
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        */

        CardView newsCV = (CardView) view.findViewById(R.id.news_cardview);
        newsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), NewsActivity.class));

            }
        });

        LessonRequest.get(getActivity());
    }
}
