package ru.startandroid.testing.utils

object ConvertUtils {
    fun stringToInteger(s: String): Int {
        var result = 0
        try {
            result = Integer.parseInt(s)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }
}