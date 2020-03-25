package ru.startandroid.testing.list

import android.view.View
import android.widget.AdapterView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
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
import ru.startandroid.testing.ui.ListActivity


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

        onData(withItemId(100)).check(matches(isDisplayed()))
    }

    /* Matchers */
    private fun withItemId(id: Int): Matcher<Any?>? {
        return object : BoundedMatcher<Any?, ListItem>(ListItem::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("with item id: $id")
            }

            override fun matchesSafely(item: ListItem): Boolean {
                return item.id == id
            }
        }
    }

    private fun withItemName(itemNameMatcher: Matcher<String>): Matcher<Any?>? {
        return object : BoundedMatcher<Any?, ListItem>(ListItem::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("with item name: ")
                itemNameMatcher.describeTo(description)
            }

            override fun matchesSafely(item: ListItem): Boolean {
                return itemNameMatcher.matches(item.name)
            }
        }
    }

    private fun withAdaptedData(dataMatcher: Matcher<Any?>): Matcher<View?>? {
        return object : TypeSafeMatcher<View?>() {
            override fun describeTo(description: Description) {
                description.appendText("Adapter data ")
                dataMatcher.describeTo(description)
            }

            override fun matchesSafely(view: View?): Boolean {
                if (view !is AdapterView<*>) {
                    return false
                }
                val adapter: Adapter = view.adapter
                for (i in 0 until adapter.getCount()) {
                    if (dataMatcher.matches(adapter.getItem(i))) {
                        return true
                    }
                }
                return false
            }
        }
    }
}