package ru.startandroid.testing

import org.junit.Test
import org.junit.Assert.*
import ru.startandroid.testing.matchers.ShortStringMatcher.Companion.isShortString

class MyTest {
    @Test
    fun myTest() {
        val s = "12345"
//        assertThat(s, isShortString(5))
        assertThat(s, isShortString())
    }
}