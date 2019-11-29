package com.grafsemmel.sedative.library

open class SectionList : ArrayList<Section>() {
    fun flatList(): List<Diffable> = this.flatMap { section: Section ->
        mutableListOf<Diffable>().apply {
            if (section.isVisible) {
                processTitle(section, this)
                processItems(section, this)
                processEmptyOrLoading(section, this)
            }
        }
    }

    private fun processEmptyOrLoading(section: Section, list: MutableList<Diffable>) {
        if (section.loadingController?.isLoading == true) {
            list.add(section.loadingController.createItem.invoke())
        } else {
            section.emptyItem?.let { if (list.isEmpty()) list.add(it) }
        }
    }

    private fun processTitle(section: Section, list: MutableList<Diffable>) {
        section.titleController?.let { factory ->
            if (section.items.isNotEmpty()
                || factory.showIfEmpty
                || section.emptyItem != null
                || section.loadingController?.isLoading == true
            ) {
                list.add(factory.createItem.invoke())
            }
        }
    }

    private fun processItems(section: Section, list: MutableList<Diffable>) {
        if (section.items.isNotEmpty()) {
            if (section.headerController != null) {
                processWithHeader(section, section.headerController, list)
            } else {
                list.addAll(section.items)
            }
        }
    }

    private fun processWithHeader(
        section: Section,
        headerController: Section.HeaderController,
        list: MutableList<Diffable>
    ) {
        if (section.items.isNotEmpty() && section.headerController != null) {
            var lastHeader: Diffable? = null
            section.items.onEach { item ->
                val header: Diffable = headerController.createItem(item)
                if (headerController.isGrouped) {
                    if (lastHeader?.hasSameContents(header) != true) {
                        list.add(header)
                    }
                    lastHeader = header
                } else {
                    list.add(header)
                }
                list.add(item)
            }
        }
    }

    fun setItems(list: List<Diffable>) {
        this.onEach { it.items.clear() }
        addAllItems(list)
    }

    fun addAllItems(list: List<Diffable>) {
        list.onEach { addItem(it) }
    }

    fun addItem(item: Diffable) {
        this.onEach { section -> if (section.accepts.invoke(item)) section.items.add(item) }
    }
}


