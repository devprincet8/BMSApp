package com.soarmorrow.bms.view.property.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soarmorrow.bms.view.common_listing.CommonListClickListener

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T,listener: CommonListClickListener?)
}