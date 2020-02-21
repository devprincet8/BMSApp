package com.soarmorrow.bms.view.property.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soarmorrow.bms.view.property.details.model.CheckBoxItem
import kotlinx.android.synthetic.main.property_checkbox_item.view.*

class PropertyCheckBoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(item: CheckBoxItem) {
        itemView.cb.isSelected = item.isSelected
        itemView.cb.text = item.title
    }

}