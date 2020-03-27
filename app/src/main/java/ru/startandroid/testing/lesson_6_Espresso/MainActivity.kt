package ru.startandroid.testing.lesson_6_Espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.startandroid.testing.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text =
                if (editText.text.isEmpty()) getString(R.string.empty_text) else editText.text
        }
    }
}
