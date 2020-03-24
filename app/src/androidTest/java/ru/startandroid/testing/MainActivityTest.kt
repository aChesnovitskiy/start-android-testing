package ru.startandroid.testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun changeTextCorrect() {
        val text = "My text"

        onView(withId(R.id.editText)).perform(typeText(text))

        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.textView)).check(matches(withText(text)))
    }

    @Test
    fun changeTextEmpty() {
        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.textView)).check(matches(withText(R.string.empty_text)))
    }
}