package com.mytaxi.android_demo.pages;

import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class LoginPageObject extends BasePage
{
    public void enterUserName(String username) {

        writeText(R.id.edt_username,username);
    }

    public void enterPassword(String password) {

        writeText(R.id.edt_password,password);
    }

    public void clickOnLoginButton() {
        clickButton(R.id.btn_login);
        waitForTime(3000);
    }

    public ViewInteraction getLoginButton(){

        return onView(withId(R.id.btn_login));
    }
}