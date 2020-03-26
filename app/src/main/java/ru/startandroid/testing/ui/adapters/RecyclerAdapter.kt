package ru.startandroid.testing.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ru.startandroid.testing.data.list.ListItem

class RecyclerAdapter(
    private val list: List<ListItem>,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(item: ListItem, listener: (String) -> Unit) {
            
        }
    }
}