package com.soarmorrow.bms.view.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_menu_item.view.*

class MenuListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(menuModel: MenuItem) {
        itemView.title.text = menuModel.title
        Glide.with(itemView.context).load(menuModel.image).into(itemView.icon)
    }

}