package com.mytaxi.android_demo.handler;

import com.mytaxi.android_demo.pages.LoginPageObject;

public class Login {

    LoginPageObject loginPage = new LoginPageObject();

    public void loginCredentials(String username, String password){
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }
}