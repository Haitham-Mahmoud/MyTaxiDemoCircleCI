package com.mytaxi.android_demo.tests;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.google.gson.JsonObject;
import com.mytaxi.android_demo.R;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.mytaxi.android_demo.dataprovider.JsonReader;
import com.mytaxi.android_demo.handler.Login;
import com.mytaxi.android_demo.pages.LoginPageObject;
import com.mytaxi.android_demo.pages.SearchPageObject;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@FixMethodOrder( MethodSorters.NAME_ASCENDING)
@RunWith( AndroidJUnit4.class)
@LargeTest
public class LoginActivity extends BaseTest {
    JsonObject jsonObject;
    String invalidusername, invalidpassword, validusername, validpassword;
    Login loginHandler;
    LoginPageObject loginPage;
    SearchPageObject searchPage;

    @Test
    public void _1testFailLogin() {
        loginHandler = new Login();
        loginPage = new LoginPageObject();
        jsonObject = (JsonObject) JsonReader.getJSONResource(resources,R.raw.testdata ).get("invalidLogin");
        invalidusername = jsonObject.get("invalidusername").getAsString();
        invalidpassword  = jsonObject.get("invalidpassword").getAsString();
        loginHandler.loginCredentials(invalidusername,invalidpassword);
        loginPage.getLoginButton().check(matches(isDisplayed()));
    }

    @Test
    public void _2testSuccessfulLogin() {
        loginHandler = new Login();
        searchPage = new SearchPageObject();
        jsonObject = (JsonObject) JsonReader.getJSONResource(resources,R.raw.testdata ).get("validLogin");
        validusername = jsonObject.get("validusername").getAsString();
        validpassword  = jsonObject.get("validpassword").getAsString();
        loginHandler.loginCredentials(validusername,validpassword);
        searchPage.getTextSearch().check(matches(isDisplayed()));
    }
}
