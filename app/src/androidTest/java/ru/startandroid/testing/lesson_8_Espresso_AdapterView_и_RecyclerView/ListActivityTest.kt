package ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import ru.startandroid.testing.R
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.matchers.ListMatcher.withAdaptedData
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.matchers.ListMatcher.withItemId
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.matchers.ListMatcher.withItemName


class ListActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(ListActivity::class.java)

    @Test
    fun listItemClick() {
//        val listItem = ListItem(1, "Item 1", 0)
//        onData(equalTo(listItem)).perform(click())

        onData(withItemId(1)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Item 1")))

        onData(withItemName(`is`("Item 2"))).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Item 2")))

        onData(withItemName(endsWith("57"))).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Item 57")))

        onData(withItemName(startsWith("Item 5")))
            .atPosition(3)
            .perform(click())
        onView(withId(R.id.textView)).check(matches(withText("Item 52")))

        onData(withItemName(endsWith("57")))
            .onChildView(withId(R.id.textViewTen))
            .perform(click())
        onView(withId(R.id.textView)).check(matches(withText("5")))

        onData(withItemId(52)).check(matches(isDisplayed()))

        onView(withId(R.id.listView)).check(matches(withAdaptedData(withItemId(50))))
    }
}