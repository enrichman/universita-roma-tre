/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.persistence;

import android.provider.BaseColumns;

public final class RomaTreContract {

    public RomaTreContract() {}

    public static abstract class CorsoEntry implements BaseColumns {
        public static final String TABLE_NAME = "corso";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_FACOLTA_ID = "facolta_id";
        public static final String COLUMN_NAME_FACOLTA_NOME = "facolta_nome";
    }

}
