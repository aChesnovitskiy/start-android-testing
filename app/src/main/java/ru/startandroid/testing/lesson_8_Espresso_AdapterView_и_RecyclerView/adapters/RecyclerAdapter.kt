package ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*
import ru.startandroid.testing.R
import ru.startandroid.testing.lesson_8_Espresso_AdapterView_и_RecyclerView.ListItem

class RecyclerAdapter(
    private val list: List<ListItem>,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item, parent, false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    inner class ViewHolder(containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(item: ListItem, listener: (String) -> Unit) {
            val name = item.name

            textViewName.text = name
            textViewTen.apply {
                val ten = item.ten.toString()
                text = ten
                setOnClickListener {
                    listener.invoke(ten)
                }
            }

            itemView.setOnClickListener { listener.invoke(name) }
        }
    }
}