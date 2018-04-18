package com.mytaxi.android_demo.SepwiseTests;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

public class BDriverSearchTestcase {

    int shortWait = 2000, longWait = 5000; //Introducing Short and Long waits for demo purpose
    // I Added sleep statements to slow down the demo.
    // I came to know that "Espresso idling resources" is a better option,
    // however, I did not get enough time to teach myself how to use that.
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;

    @Before
    public void setActivity() {
        mActivity = mActivityTestRule.getActivity();
    }


    @Test
    public void searchDriver() {
        String searchString = "sa";
        String driverName = "Sarah Friedrich";

        //Checking if the Auto Complete Search bar is present and if it is present then tap on it.
        //Assert that Element is present
        try {
            ViewInteraction frameLayout = onView(
                    allOf(withId(R.id.searchContainer),isDisplayed()));
            frameLayout.check(matches(isDisplayed()));
            Thread.sleep(shortWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Type on the Search box
        try {
            Thread.sleep(shortWait);
            ViewInteraction autoSearch = onView(withId(R.id.textSearch));
            //ViewInteraction autoSearch = onView(withId(R.id.searchContainer));

            autoSearch.perform(click());
            // Type "sa" to trigger suggestions.
            autoSearch.perform(typeText(searchString));
            //autoSearch.perform(ViewActions.pressKey(KeyEvent.KEYCODE_R)); //optionally you can send individual keys this way
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(shortWait);
            // Check that Sarah Friedrich is present in the results.
            onView(withText(driverName)).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));
            //onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));

            // Tap on Sarah Friedrich in the results.
            onView(withText(driverName)).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).perform(click());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @After
    //Wait
    public void afterTest(){
        try {
            Thread.sleep(longWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
