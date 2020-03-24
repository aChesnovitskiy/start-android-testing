package ru.startandroid.testing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import ru.startandroid.testing.R
import ru.startandroid.testing.data.list.ListItem

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val data = mutableListOf<ListItem>()

        for (i in 1..99) {
            data.add(ListItem(i, "Item $i", i / 10))
        }

        val adapter = ArrayAdapter<ListItem>(this, )
    }
}
