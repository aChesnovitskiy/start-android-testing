package ru.startandroid.testing.lesson_2_Как_создать_и_запустить_локальный_тест

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.Assert.*

class ConvertUtilsTest {
    @Test
    fun stringToInteger() {
        assertEquals(2,
            ConvertUtils.stringToInteger("2")
        )
        assertEquals(-2,
            ConvertUtils.stringToInteger("-2")
        )
        assertEquals(0,
            ConvertUtils.stringToInteger("")
        )
        assertEquals(0,
            ConvertUtils.stringToInteger("a")
        )
        assertThat(ConvertUtils.stringToInteger("2"), equalTo(2))
    }
}