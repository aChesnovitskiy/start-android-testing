package ru.startandroid.testing.lesson_9_Espresso_IdlingResource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.test.espresso.idling.CountingIdlingResource
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_lesson_nine.*
import ru.startandroid.testing.R
import java.util.concurrent.TimeUnit

class LessonNineActivity : AppCompatActivity() {
    val simpleIdlingResource = SimpleIdlingResource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_nine)

        button.setOnClickListener {
            simpleIdlingResource.setIdleState(false)
            Single.just(getString(R.string.data_string))
                .subscribeOn(Schedulers.io())
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { text ->
                    setText(text)
                    simpleIdlingResource.setIdleState(true)
                }
        }

//        button.setOnClickListener {
//            countingIdlingResource.increment()
//            Single.just(getString(R.string.data_string))
//                .subscribeOn(Schedulers.io())
//                .delay(1, TimeUnit.SECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe { text ->
//                    setText(text)
//                    countingIdlingResource.decrement()
//                }
//        }
    }

    private fun setText(text: String) {
        textView.text = text
    }
}
