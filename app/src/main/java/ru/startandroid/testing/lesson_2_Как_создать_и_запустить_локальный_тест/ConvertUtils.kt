package ru.startandroid.testing.lesson_2_Как_создать_и_запустить_локальный_тест

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