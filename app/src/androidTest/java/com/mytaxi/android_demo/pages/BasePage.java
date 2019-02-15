package com.mytaxi.android_demo.pages;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNull;

public class BasePage {

    void  writeText(int element, String myValue) {
        onView(withId(element)).perform(typeText(myValue)).check(matches(isDisplayed()));
        closeSoftKeyboard();
    }

    void clickButton(int element) {
        onView(withId(element)).perform(click());
    }

    void waitForTime(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            assertNull(e);
            e.printStackTrace();
        }
    }
}
