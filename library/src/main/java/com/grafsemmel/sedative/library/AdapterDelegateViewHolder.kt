package com.grafsemmel.sedative.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class AdapterDelegateViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
