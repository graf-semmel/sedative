package com.grafsemmel.sedative.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

abstract class BaseAdapterDelegate<T : Diffable>(@LayoutRes private val layoutRes: Int) :
    AbsListItemAdapterDelegate<T, Diffable, AdapterDelegateViewHolder>() {

    private var inflater: LayoutInflater? = null

    override fun isForViewType(item: Diffable, items: MutableList<Diffable>, position: Int): Boolean =
        isForViewType(item)

    abstract fun isForViewType(item: Diffable): Boolean

    override fun onCreateViewHolder(parent: ViewGroup): AdapterDelegateViewHolder {
        inflater = inflater ?: LayoutInflater.from(parent.context)
        return AdapterDelegateViewHolder(
            inflater!!.inflate(layoutRes, parent, false)
        )
    }
}