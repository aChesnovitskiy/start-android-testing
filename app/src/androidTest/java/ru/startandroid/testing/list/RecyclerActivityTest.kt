package ru.startandroid.testing.list

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import ru.startandroid.testing.R
import ru.startandroid.testing.list.matchers.ListMatcher.withHolderItemId
import ru.startandroid.testing.ui.RecyclerActivity
import ru.startandroid.testing.ui.adapters.RecyclerAdapter

class RecyclerActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(RecyclerActivity::class.java)

    // Get view by position (via actionOnItemAtPosition)
    @Test
    fun recyclerItemClick1() {
        onView(withId(R.id.recyclerView)).perform(
            actionOnItemAtPosition<RecyclerAdapter.ViewHolder>(20,click())
        )
        onView(withId(R.id.textView)).check(matches(withText("Item 21")))
    }

    // Get view by holder (via actionOnItemAtPosition)
//    @Test TODO: doesn't work (think because of wrong matcher)
//    fun recyclerItemClick2() {
//        onView(withId(R.id.recyclerView)).perform(actionOnHolderItem(withHolderItemId(20), click()))
//        onView(withId(R.id.textView)).check(matches(withText("Item 20")))
//    }

    // Get view by view (via actionOnItem)
    @Test
    fun recyclerItemClick3() {
        onView(withId(R.id.recyclerView)).perform(
            actionOnItem<RecyclerAdapter.ViewHolder>(
                hasDescendant(withText(containsString("Item 5"))), click()
            ).atPosition(2)
        )
        onView(withId(R.id.textView)).check(matches(withText("Item 51")))
    }
}