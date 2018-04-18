package com.mytaxi.android_demo.SepwiseTests;


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
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
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
public class ALoginTestcase {
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
    public void loginTest() {
        String username = "whiteelephant261";
        String password = "video1";

        //Login Starts from here
        try {
            //Finding Username Field and bringing it to focus.
            ViewInteraction usernameField = onView(withId(R.id.edt_username));
            usernameField.perform(click());
            //Typing username on the Field as per the String passed in the parameters
            usernameField.perform(typeTextIntoFocusedView(username), closeSoftKeyboard());
            Thread.sleep(shortWait);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //Finding password Field and bringing it to focus.
            ViewInteraction passwordField = onView(
                    withId(R.id.edt_password));
            passwordField.perform(click());
            //Typing password on the Field as per the String passed in the parameters
            passwordField.perform(replaceText(password), closeSoftKeyboard());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Checking if the Login Button is present and if it is present then tap on it.
        try {
            ViewInteraction loginButton = onView(
                    allOf(withId(R.id.btn_login), withText("Login"),
                            isDisplayed()));
            loginButton.perform(click());
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
