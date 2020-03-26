package ru.startandroid.testing.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_list.textView
import kotlinx.android.synthetic.main.activity_recycler.*
import ru.startandroid.testing.R
import ru.startandroid.testing.data.list.ListItem
import ru.startandroid.testing.ui.adapters.RecyclerAdapter

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val data = mutableListOf<ListItem>()
        for (i in 1..99) {
            data.add(ListItem(i, "Item $i", i / 10))
        }

        val recyclerAdapter = RecyclerAdapter(data) { textView.text = it }

        with(recyclerView) {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this@RecyclerActivity)
        }
    }
}
