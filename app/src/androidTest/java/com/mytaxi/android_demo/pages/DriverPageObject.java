package com.mytaxi.android_demo.pages;

import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class DriverPageObject extends BasePage{

    public ViewInteraction getDriverName(){

        return onView(withId(R.id.textViewDriverName));
    }

    public ViewInteraction getDriverLocation(){

        return onView(withId(R.id.textViewDriverLocation));
    }

    public ViewInteraction getDriverDate(){

        return onView(withId(R.id.textViewDriverDate));
    }

    public ViewInteraction getDriverPhoto(){

        return onView(withId(R.id.imageViewDriverAvatar));
    }

    public void callDriver(){
        onView(withId(R.id.fab)).perform(click());
    }

}
