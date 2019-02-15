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
    JsonObject jsonObject;
    String searchDriverName,dirverFullName, driverLocation, driverJoinedDate, driverTelephone;
    SearchForDrivers searchForDriver = new SearchForDrivers();
    DriverPageObject driverPage = new DriverPageObject();

    @Test
    public void _1checkDriverProfileData(){
        searchForDriver = new SearchForDrivers();
        driverPage = new DriverPageObject();
        jsonObject = (JsonObject) JsonReader.getJSONResource(resources, R.raw.testdata ).get("searchDriverProfile");
        searchDriverName = jsonObject.get("searchString").getAsString();
        dirverFullName = jsonObject.get("fullname").getAsString();
        driverLocation = jsonObject.get("location").getAsString();
        driverJoinedDate = jsonObject.get("date").getAsString();
        searchForDriver.searchForExistingDriver(searchDriverName,dirverFullName);
        driverPage.getDriverName().check(matches(withText(dirverFullName)));
        driverPage.getDriverLocation().check(matches(withText(driverLocation)));
        driverPage.getDriverDate().check(matches(withText(driverJoinedDate)));
        driverPage.getDriverPhoto().check(matches(isDisplayed()));
    }

    @Test
    public void _2callingDriver(){
        searchForDriver = new SearchForDrivers();
        driverPage = new DriverPageObject();
        jsonObject = (JsonObject) JsonReader.getJSONResource(resources, R.raw.testdata ).get("searchDriverProfile");
        searchDriverName = jsonObject.get("searchString").getAsString();
        dirverFullName = jsonObject.get("fullname").getAsString();
        driverTelephone = jsonObject.get("telephone").getAsString();
        searchForDriver.searchForExistingDriver(searchDriverName,dirverFullName);
        driverPage.callDriver();
    }
}