package ru.startandroid.testing.lesson_2_Как_создать_и_запустить_локальный_тест

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {
    private val calculator = Calculator()

    @Before
    fun setUp() {
        println("setUp")
    }

    @After
    fun tearDown() {
        println("tearDown")
    }

    @Test
    fun add() {
        println("add")
        assertEquals(9,calculator.add(6,3))
    }

    @Test
    fun subtract() {
        println("subtract")
        assertEquals(3,calculator.subtract(6,3))
    }

    @Test
    fun multiply() {
        println("multiply")
        assertEquals(18,calculator.multiply(6,3))
    }

    @Test
    fun divide() {
        println("divide")
        assertEquals(2,calculator.divide(6,3))
    }
}