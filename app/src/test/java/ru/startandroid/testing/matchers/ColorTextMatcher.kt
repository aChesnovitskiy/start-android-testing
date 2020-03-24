package ru.startandroid.testing.matchers

import android.graphics.Color
import android.view.View
import android.widget.TextView
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ColorTextMatcher(private val color: Int): TypeSafeMatcher<View>() {
    override fun describeTo(description: Description?) {
        description?.appendText("Has red text color")
    }

    override fun matchesSafely(view: View?): Boolean {
        if (view is TextView) {
            return view.currentTextColor == color
        }
        return false
    }

    fun hasColorText(color: Int) = ColorTextMatcher(color)

    fun hasRedColorText() = hasColorText(Color.RED)

    fun hasGreenColorText() = hasColorText(Color.GREEN)
}