package ru.startandroid.testing.lesson_3_JUnit4_assert_методы

import org.junit.Test
import org.junit.Assert.*
import ru.startandroid.testing.lesson_3_JUnit4_assert_методы.ShortStringMatcher.Companion.isShortString

class MyTest {
    @Test
    fun myTest() {
        val s = "12345"
//        assertThat(s, isShortString(5))
        assertThat(s, isShortString())
    }
}