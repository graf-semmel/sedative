package com.grafsemmel.sedative.library

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager

class AdapterDelegateManager : AdapterDelegatesManager<List<Diffable>>() {
    override fun addDelegate(delegate: AdapterDelegate<List<Diffable>>): AdapterDelegatesManager<List<Diffable>> =
        super.addDelegate(delegate.hashCode(), true, delegate)
}