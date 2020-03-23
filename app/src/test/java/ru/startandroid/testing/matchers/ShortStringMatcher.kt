package ru.startandroid.testing.matchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class ShortStringMatcher(val length: Int) : TypeSafeMatcher<String>() {
    override fun describeTo(description: Description) {
        description.appendText("Length of string must be shorter than $length")
    }

    override fun matchesSafely(item: String): Boolean {
        return item.length < length
    }

    companion object {
        fun isShortString(limit: Int = 5): Matcher<String> {
            return ShortStringMatcher(limit)
        }
    }
}