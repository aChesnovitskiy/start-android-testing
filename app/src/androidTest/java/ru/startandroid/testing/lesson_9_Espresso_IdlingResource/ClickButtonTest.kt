package ru.startandroid.testing.lesson_9_Espresso_IdlingResource

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import ru.startandroid.testing.R

class ClickButtonTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(LessonNineActivity::class.java)

    @Test
    fun whenClickButton() {
        val idlingResource = activityRule.activity.countingIdlingResource
        val text = "Data string"

        IdlingRegistry.getInstance().register(idlingResource)

        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))

        IdlingRegistry.getInstance().unregister(idlingResource)
    }
}