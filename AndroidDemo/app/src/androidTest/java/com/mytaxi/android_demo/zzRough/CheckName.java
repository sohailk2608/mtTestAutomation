package com.mytaxi.android_demo.activities;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.mytaxi.android_demo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


@LargeTest
@RunWith(AndroidJUnit4.class)

public class CheckName {


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setActivity() {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testAutoCompleteTextView() {
        //Type on the Search box

        //onView(withId(R.id.textSearch)).perform(click());
        onView(withId(R.id.searchContainer)).perform(click());
        /////onView(withId(R.id.textSearch)).perform(click().perform(typeTextIntoFocusedView()););

        // Type "sa" to trigger suggestions.

        onView(withId(R.id.textSearch)).perform(typeText("sa"));
        onView(withId(R.id.textSearch)).perform(ViewActions.pressKey(KeyEvent.KEYCODE_R));
        //onView(withId(R.id.searchContainer)).perform(typeText("sa"), closeSoftKeyboard());


        // Check that Sarah Friedrich is present in the results.
        onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));
        //onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));

        // Tap on Sarah Friedrich in the results.
        onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).perform(click());
        //onView(withText("Sarah Friedrich")).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView())))).perform(click());

        try {
            System.out.println("Sleeping for 5 Seconds...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
