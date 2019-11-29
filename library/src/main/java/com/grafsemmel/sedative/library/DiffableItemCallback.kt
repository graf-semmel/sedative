package com.grafsemmel.sedative.library

import androidx.recyclerview.widget.DiffUtil

object DiffableItemCallback : DiffUtil.ItemCallback<Diffable>() {
    override fun areItemsTheSame(oldItem: Diffable, newItem: Diffable): Boolean = oldItem.isSameItem(newItem)

    override fun areContentsTheSame(oldItem: Diffable, newItem: Diffable): Boolean = oldItem.hasSameContents(newItem)
}