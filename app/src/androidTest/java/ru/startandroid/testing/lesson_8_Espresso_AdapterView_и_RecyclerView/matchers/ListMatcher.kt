package ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.matchers

import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.ListItem
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.adapters.RecyclerAdapter

object ListMatcher {
    fun withItemId(id: Int): Matcher<Any?> {
        return object : BoundedMatcher<Any?, ListItem>(ListItem::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("with item id: $id")
            }

            override fun matchesSafely(item: ListItem): Boolean {
                return item.id == id
            }
        }
    }

    fun withHolderItemId(id: Int): Matcher<RecyclerAdapter.ViewHolder> {
        return object : TypeSafeMatcher<RecyclerAdapter.ViewHolder>() {
            override fun describeTo(description: Description) {
                description.appendText("Item with id: $id")
            }

            override fun matchesSafely(holder: RecyclerAdapter.ViewHolder): Boolean {
                return holder.containerView?.id == id
            }
        }
    }

    fun withItemName(itemNameMatcher: Matcher<String>): Matcher<Any?>? {
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

    fun withAdaptedData(dataMatcher: Matcher<Any?>): Matcher<View?>? {
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

                for (i in 0 until adapter.count) {
                    if (dataMatcher.matches(adapter.getItem(i))) {
                        return true
                    }
                }

                return false
            }
        }
    }
}