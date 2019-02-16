package com.mytaxi.android_demo.tests;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.mytaxi.android_demo.handler.Login;
import com.mytaxi.android_demo.pages.LoginPageObject;
import com.mytaxi.android_demo.pages.SearchPageObject;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@FixMethodOrder( MethodSorters.NAME_ASCENDING)
@RunWith( AndroidJUnit4.class)
@LargeTest
public class LoginActivity extends BaseTest {
    Login loginHandler;
    LoginPageObject loginPage;
    SearchPageObject searchPage;

    @Test
    public void _1testFailLogin() {
        loginHandler = new Login();
        loginPage = new LoginPageObject();
        loginHandler.loginCredentials(reader.getInvalidUsername(), reader.getInvalidPassword());
        loginPage.getLoginButton().check(matches(isDisplayed()));
    }

    @Test
    public void _2testSuccessfulLogin() {
        loginHandler = new Login();
        searchPage = new SearchPageObject();
        loginHandler.loginCredentials(reader.getValidUsername(), reader.getValidPassword());
        searchPage.getTextSearch().check(matches(isDisplayed()));
    }
}
