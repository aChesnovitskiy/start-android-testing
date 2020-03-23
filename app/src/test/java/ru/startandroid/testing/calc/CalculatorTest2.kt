package ru.startandroid.testing.calc

import org.junit.Assert.*
import org.junit.Test

class CalculatorTest2 {
    @Test
    fun operations() {
        assertEquals(2.0, 5.0, 0.001)
    }
}