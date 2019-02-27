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
import com.mytaxi.android_demo.handler.Login;
import com.mytaxi.android_demo.handler.Logout;
import com.mytaxi.android_demo.pages.SearchPageObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class BaseTest {
    Login loginHandler;
    SearchPageObject searchPage;
    JsonObject jsonObject;
    Logout logoutHandler;
    Gson gson = new Gson();
    public JsonData reader;
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class,true,true);
    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);
    public Resources resources;
    @Before
    public void init() {
        resources = mActivityRule.getActivity().getResources();
        jsonObject = JsonReader.getJSONResource(resources, R.raw.testdata );
        reader = gson.fromJson(jsonObject, JsonData.class);
        loginHandler = new Login();
        searchPage = new SearchPageObject();
        loginHandler.loginCredentials(reader.getValidUsername(), reader.getValidPassword());
        searchPage.getTextSearch().check(matches(isDisplayed()));
    }

    @After
    public void tearDown(){
        logoutHandler = new Logout();
        logoutHandler.logoutApp(reader.getLogout());
    }
}