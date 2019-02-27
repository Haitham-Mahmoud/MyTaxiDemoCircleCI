package com.mytaxi.android_demo.pages;

import android.support.test.espresso.action.ViewActions;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNull;

public class BasePage {
    public static void  writeText(int element, String myValue) {
        onView(withId(element)).perform(typeText(myValue)).check(matches(isDisplayed()));
        closeSoftKeyboard();
    }

    public static void clickButton(int element) {
        onView(withId(element)).perform(click());
    }

    public static void waitForTime(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            assertNull(e);
            e.printStackTrace();
        }
    }

    public static void navigateLink(int elementDrawer, int elementText){
        // Click on button visible when drawer open
        onView(withContentDescription(elementDrawer)).perform(click());
        onView(withText(elementText)).perform(click());
    }

    public static void pressBack(){
        onView(isRoot()).perform(ViewActions.pressBack());
    }
}
