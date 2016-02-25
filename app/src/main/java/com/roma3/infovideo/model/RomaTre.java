/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */
package com.roma3.infovideo.model;

import com.roma3.infovideo.R;

/**
 * Created by enrico on 25/02/16.
 */
public enum RomaTre {

    ATENEO(R.string.r3_dip_ateneo_name, R.string.r3_dip_ateneo_rss_url),
    ING(R.string.r3_dip_ing_name, R.string.r3_dip_ing_rss_url);

    private int nameId;
    private int rssUrlId;

    RomaTre(int nameId, int rssUrlId) {
        this.nameId = nameId;
        this.rssUrlId = rssUrlId;
    }

    public int getNameId() {
        return nameId;
    }

    public int getRssUrlId() {
        return rssUrlId;
    }
}
