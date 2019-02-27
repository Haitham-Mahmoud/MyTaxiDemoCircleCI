package com.mytaxi.android_demo.pages;

import com.mytaxi.android_demo.R;

public class LogoutPageObject extends BasePage{
    public void clickOnLogout(){
        pressBack();
        navigateLink(R.string.navigation_drawer_open, R.string.text_item_title_logout);
        waitForTime(3000);
    }
}
