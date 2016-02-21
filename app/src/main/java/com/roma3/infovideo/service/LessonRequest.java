/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.service;

import android.content.Context;
import android.util.Log;

import com.roma3.infovideo.model.Facolta;
import com.roma3.infovideo.util.LessonModelConverter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LessonRequest {

    public static void get(Context context) {
        try {
            Serializer serializer = new Persister();
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("ing.xml")));
            com.roma3.infovideo.service.model.Facolta facoltaXml =
                    serializer.read(com.roma3.infovideo.service.model.Facolta.class, br);

            Facolta facolta = LessonModelConverter.convert(facoltaXml);
            LessonModelConverter.saveDB(context, facolta);

            System.out.println();
        } catch (Exception e) {
            Log.e("BLA", "ee", e);
        }
    }
}
