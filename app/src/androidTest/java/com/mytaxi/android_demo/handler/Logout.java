package com.mytaxi.android_demo.handler;

import com.mytaxi.android_demo.pages.LogoutPageObject;

public class Logout {
    LogoutPageObject logoutLink = new LogoutPageObject();

    public void logoutApp(String text){
        logoutLink.clickOnLogout();
    }
}
