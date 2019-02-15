package com.mytaxi.android_demo.dataprovider;

import android.content.res.Resources;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;

import static android.content.ContentValues.TAG;

public class JsonReader {
    private static JsonParser parser;
    public static JsonObject getJSONResource(Resources resources, int id) {
        try
        {
            parser = new JsonParser();
            return parser.parse(new InputStreamReader(resources.openRawResource(id))).getAsJsonObject();
        }
        catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return null;
        }
    }

}