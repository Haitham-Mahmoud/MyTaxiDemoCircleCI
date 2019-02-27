package com.mytaxi.android_demo.tests;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.mytaxi.android_demo.handler.SearchForDrivers;
import com.mytaxi.android_demo.pages.DriverPageObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@FixMethodOrder( MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SearchCallingDriverActivity extends BaseTest{
    DriverPageObject driverPage = new DriverPageObject();
    SearchForDrivers searchForDriver = new SearchForDrivers();

    private void searchForDrivers(){
        searchForDriver.searchForExistingDriver(reader.getSearchDriver(),reader.getFullnameDriver());
    }
    @Test
    public void _1checkDriverProfileData(){
        searchForDrivers();
        driverPage.getDriverName().check(matches(withText(reader.getFullnameDriver())));
        driverPage.getDriverLocation().check(matches(withText(reader.getLocationDriver())));
        driverPage.getDriverDate().check(matches(withText(reader.getDateDriver())));
        driverPage.getDriverPhoto().check(matches(isDisplayed()));
    }

    @Test
    public void _2callingDriver(){
        searchForDrivers();
        driverPage.callDriver();
    }
}