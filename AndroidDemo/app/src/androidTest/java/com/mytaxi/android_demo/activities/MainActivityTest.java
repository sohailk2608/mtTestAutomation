package com.mytaxi.android_demo.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.mytaxi.android_demo.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
        private MainActivity mActivity = null;

        @Before
        public void setActivity() {
            mActivity = mActivityTestRule.getActivity();
        }

        @Test
        public void mainActivityTest() {
            String username = "whiteelephant261";
            String password = "video1";
            String searchString = "sa";
            String driverName = "Sarah Friedrich";
            int shortWait = 2000, longWait = 5000; //Introducing Short and Long waits for demo purpose

            // I Added sleep statements to slow down the demo.
            // I came to know that "Espresso idling resources" is a better option,
            // however, I did not get enough time to teach myself how to use that.
            // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html



            /////////////////////////////////////////////////////////////////////
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

            //Wait
            try {
                Thread.sleep(longWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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

            /////////////////////////////////////////////////////////////////////

            //Checking the Elements of the Driver Details page
            try {
                Thread.sleep(shortWait);
                ViewInteraction textTitle = onView(
                    allOf(withText("Driver Profile"),
                            isDisplayed()));
                textTitle.check(matches(withText("Driver Profile")));

                ViewInteraction textLabel = onView(
                    allOf(withId(R.id.textViewDriverName), withText("Sarah Friedrich"),
                            isDisplayed()));
                textLabel.check(matches(withText("Sarah Friedrich")));

                ViewInteraction imageBox = onView(
                    allOf(withId(R.id.imageViewDriverAvatar),
                            isDisplayed()));
                imageBox.check(matches(isDisplayed()));

                ViewInteraction callButton = onView(
                    allOf(withId(R.id.fab),
                            isDisplayed()));
                callButton.check(matches(isDisplayed()));

                ViewInteraction floatingActionButton = onView(
                    allOf(withId(R.id.fab),
                            isDisplayed()));
                floatingActionButton.perform(click());

                System.out.println("Sleeping for 5 Seconds Before Quit...");
                Thread.sleep(longWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}