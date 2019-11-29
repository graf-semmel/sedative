package com.grafsemmel.sedative.library

interface Diffable {
    fun isSameItem(item: Diffable): Boolean = this == item
    fun hasSameContents(item: Diffable): Boolean = this == item
}