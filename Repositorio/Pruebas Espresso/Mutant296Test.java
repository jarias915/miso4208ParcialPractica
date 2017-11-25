package org.secuso.privacyfriendlytodolist.view;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.secuso.privacyfriendlytodolist.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Mutant296Test {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void mutant296Test() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(android.R.id.button1), withText("Okay"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab_new_list),
                        withParent(allOf(withId(R.id.rootLayout),
                                withParent(withId(R.id.fragment_container)))),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.et_todo_list_name), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.et_todo_list_name), isDisplayed()));
        appCompatEditText2.perform(replaceText("e"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.et_todo_list_description), isDisplayed()));
        appCompatEditText3.perform(replaceText("t"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.bt_newtodolist_ok), withText("Okay"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open menu"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withId(R.id.design_menu_item_text), withText("Home"), isDisplayed()));
        appCompatCheckedTextView.perform(click());

        ViewInteraction frameLayout = onView(
                allOf(withId(android.R.id.content),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_root),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
