package ru.startandroid.testing.lesson_2_Как_создать_и_запустить_локальный_тест

import org.junit.Assert.*
import org.junit.Test

class CalculatorTest2 {
    @Test
    fun operations() {
        assertEquals(2.0, 5.0, 0.001)
    }
}