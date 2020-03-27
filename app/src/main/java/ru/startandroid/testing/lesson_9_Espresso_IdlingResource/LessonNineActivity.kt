package ru.startandroid.testing.lesson_9_Espresso_IdlingResource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lesson_nine.*
import ru.startandroid.testing.R

class LessonNineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_nine)

        button.setOnClickListener {
            textView.text = getString(R.string.data_string)
        }
    }
}
