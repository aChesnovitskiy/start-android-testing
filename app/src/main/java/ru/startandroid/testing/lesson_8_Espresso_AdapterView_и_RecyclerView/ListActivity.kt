package ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list.*
import ru.startandroid.testing.R
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.adapters.ListAdapter

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val data = mutableListOf<ListItem>()
        for (i in 1..99) {
            data.add(ListItem(i, "Item $i", i / 10))
        }

        val adapter = ListAdapter(
            this,
            R.layout.list_item,
            data
        ) {
            textView.text = it
        }
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            textView.text = data[position].name
        }
    }
}
