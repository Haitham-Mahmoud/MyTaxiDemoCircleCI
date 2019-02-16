package com.mytaxi.android_demo.tests;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.google.gson.JsonObject;
import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.dataprovider.JsonReader;
import com.mytaxi.android_demo.handler.SearchForDrivers;
import com.mytaxi.android_demo.pages.DriverPageObject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@FixMethodOrder( MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SearchCallingDriverActivity extends BaseTest{
    SearchForDrivers searchForDriver = new SearchForDrivers();
    DriverPageObject driverPage = new DriverPageObject();

    @Test
    public void _1checkDriverProfileData(){
        searchForDriver = new SearchForDrivers();
        driverPage = new DriverPageObject();
        searchForDriver.searchForExistingDriver(reader.getSearchDriver(),reader.getFullnameDriver());
        driverPage.getDriverName().check(matches(withText(reader.getFullnameDriver())));
        driverPage.getDriverLocation().check(matches(withText(reader.getLocationDriver())));
        driverPage.getDriverDate().check(matches(withText(reader.getDateDriver())));
        driverPage.getDriverPhoto().check(matches(isDisplayed()));
    }

    @Test
    public void _2callingDriver(){
        searchForDriver = new SearchForDrivers();
        driverPage = new DriverPageObject();
        searchForDriver.searchForExistingDriver(reader.getSearchDriver(),reader.getFullnameDriver());
        driverPage.callDriver();
    }
}