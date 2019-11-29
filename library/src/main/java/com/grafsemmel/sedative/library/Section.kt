package com.grafsemmel.sedative.library

open class Section(
    var items: MutableList<Diffable> = mutableListOf(),
    var accepts: (Diffable) -> Boolean = { true },
    var isVisible: Boolean = true,
    var isHorizontal: Boolean = false,
    val emptyItem: Diffable? = null,
    val loadingController: LoadingController? = null,
    val titleController: TitleController? = null,
    val headerController: HeaderController? = null,
    val collapsibleController: CollapsibleController? = null
) {
    class HeaderController(val isGrouped: Boolean = false, val createItem: (Diffable) -> Diffable)
    class TitleController(val showIfEmpty: Boolean = false, val createItem: () -> Diffable)
    class LoadingController(var isLoading: Boolean = false, val createItem: () -> Diffable)
    class CollapsibleController(
        var isCollapsed: Boolean = false,
        val positionOffset: Int = 0,
        val createItem: (Diffable) -> Diffable
    )
}

