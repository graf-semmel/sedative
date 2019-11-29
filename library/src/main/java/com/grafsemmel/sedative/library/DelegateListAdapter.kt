package com.grafsemmel.sedative.library

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

open class DelegateListAdapter<T : Diffable>(delegates: List<BaseAdapterDelegate<out T>>) :
    AsyncListDifferDelegationAdapter<Diffable>(DiffableItemCallback, AdapterDelegateManager()), StickyHeaderHandler {

    init {
        delegates.iterator().forEach { this.delegatesManager.addDelegate(it) }
    }

    var onItemClickListener: ((diffable: Diffable, viewHolder: RecyclerView.ViewHolder) -> Unit)? = null

    override fun getItemCount(): Int = items.size

    override fun getAdapterData(): MutableList<*> = items.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, viewType).also { holder ->
            holder.itemView.setOnClickListener {
                onItemClickListener?.invoke(items[holder.adapterPosition], holder)
            }
        }
    }
}

