package ru.startandroid.testing.list

import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import ru.startandroid.testing.R
import ru.startandroid.testing.data.list.ListItem
import ru.startandroid.testing.ui.RecyclerActivity
import ru.startandroid.testing.ui.adapters.RecyclerAdapter
import ru.startandroid.testing.list.matchers.ListMatcher.withAdaptedData
import ru.startandroid.testing.list.matchers.ListMatcher.withHolderItemId
import ru.startandroid.testing.list.matchers.ListMatcher.withItemId
import ru.startandroid.testing.list.matchers.ListMatcher.withItemName

class RecyclerActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(RecyclerActivity::class.java)

    // Get view by position (via actionOnItemAtPosition)
    @Test
    fun recyclerItemClick1() {
        onView(withId(R.id.recyclerView)).perform(actionOnItemAtPosition<RecyclerAdapter.ViewHolder>(10, click()))
        onView(withId(R.id.textView)).check(matches(withText("Item 11")))
    }

    // Get view by holder (via actionOnItemAtPosition)
//    @Test TODO: don't work
//    fun recyclerItemClick2() {
//        onView(withId(R.id.recyclerView)).perform(actionOnHolderItem(withHolderItemId(20), click()))
//        onView(withId(R.id.textView)).check(matches(withText("Item 20")))
//    }
}