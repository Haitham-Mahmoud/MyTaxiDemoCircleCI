package com.mytaxi.android_demo.tests;

import android.content.res.Resources;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.dataprovider.JsonData;
import com.mytaxi.android_demo.dataprovider.JsonReader;

import org.junit.Before;
import org.junit.Rule;

public class BaseTest {
    JsonObject jsonObject;
    Gson gson = new Gson();
    public JsonData reader;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class, true,true);
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);
    public Resources resources;
    @Before
    public void init() {

        resources = mActivityRule.getActivity().getResources();
        jsonObject = JsonReader.getJSONResource(resources, R.raw.testdata );
        reader = gson.fromJson(jsonObject, JsonData.class);
    }
}