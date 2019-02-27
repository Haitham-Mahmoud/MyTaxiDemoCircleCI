package com.mytaxi.android_demo.pages;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import com.mytaxi.android_demo.R;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class SearchPageObject extends BasePage{

    public void searchForDriver(String driverName) {
        waitForTime(3000);
        writeText(R.id.textSearch,driverName);
    }

    public void selectFromDisplayedOptions(String fullDriverName) {
        onView(withText(fullDriverName)).inRoot(RootMatchers.isPlatformPopup()).perform(click());
    }

    public ViewInteraction getTextSearch(){

        return onView(withId(R.id.textSearch));
    }

}
