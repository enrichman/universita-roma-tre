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
import android.widget.Button;
import android.widget.Toast;

import com.roma3.infovideo.R;
import com.roma3.infovideo.model.RomaTre;

public class MenuFragment extends Fragment {

    private Button homeButton;
    private Button ingButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View.OnClickListener listener = new MenuButtonListener();

        homeButton = (Button) view.findViewById(R.id.fragment_home_button_home);
        homeButton.setOnClickListener(listener);
        ingButton = (Button) view.findViewById(R.id.fragment_home_button_dip_ing);
        ingButton.setOnClickListener(listener);
    }

    private class MenuButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            RomaTre romaTre = null;
            switch (v.getId()) {
                case R.id.fragment_home_button_home: {
                    romaTre = RomaTre.ATENEO;
                    break;
                }
                case R.id.fragment_home_button_dip_ing: {
                    romaTre = RomaTre.ING;
                    break;
                }
            }

            if(romaTre != null) {
                Toast.makeText(getActivity(), romaTre.getNameId(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
