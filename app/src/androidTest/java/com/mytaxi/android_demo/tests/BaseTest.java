package com.mytaxi.android_demo.tests;

import android.content.res.Resources;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import com.mytaxi.android_demo.activities.MainActivity;
import org.junit.Before;
import org.junit.Rule;

public class BaseTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class, true,true);
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);
    public Resources resources;
    @Before
    public void init() {

        resources = mActivityRule.getActivity().getResources();
    }
}