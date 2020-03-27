package ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import ru.startandroid.testing.R
import ru.startandroid.testing.data.list.ListItem

class ListAdapter(
    private val context: Context,
    private val resLayout: Int,
    private val list: List<ListItem>,
    private val listener: (String) -> Unit
) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resLayout, null)

        val item = getItem(position)

        view.findViewById<TextView>(R.id.textViewName).text = item.name

        view.findViewById<TextView>(R.id.textViewTen).apply {
            val ten = item.ten.toString()
            text = ten
            setOnClickListener {
                listener.invoke(ten)
            }
        }

        return view
    }

    override fun getItem(position: Int): ListItem = list[position]

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun getCount(): Int = list.size
}