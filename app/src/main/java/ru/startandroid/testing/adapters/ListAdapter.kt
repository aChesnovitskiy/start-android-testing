package ru.startandroid.testing.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import ru.startandroid.testing.R
import ru.startandroid.testing.data.list.ListItem

class ListAdapter(
    private val context: Context,
    private val resLayout: Int,
    private val list: List<ListItem>
) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resLayout, null)

        val item = getItem(position)

        view.findViewById<TextView>(R.id.textViewName).apply {
            text = item.name
            setOnClickListener{
                (parent as ListView).performItemClick(it, position, 0)
            }
        }
        view.findViewById<TextView>(R.id.textViewTen).apply {
            text = item.ten.toString()
            setOnClickListener{
                (parent as ListView).performItemClick(it, position, 0)
            }
        }

        return view
    }

    override fun getItem(position: Int): ListItem = list[position]

    override fun getItemId(position: Int): Long = list[position].id.toLong()

    override fun getCount(): Int = list.size
}