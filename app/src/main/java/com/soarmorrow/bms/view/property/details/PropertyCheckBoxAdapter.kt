package com.soarmorrow.bms.view.property.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.property.details.model.CheckBoxItem

class PropertyCheckBoxAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfMenu = listOf<CheckBoxItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PropertyCheckBoxViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.property_checkbox_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listOfMenu.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as PropertyCheckBoxViewHolder
        movieViewHolder.bindView(listOfMenu[position])
    }

    fun setMenuList(listOfMovies: List<CheckBoxItem>) {
        this.listOfMenu = listOfMovies
        notifyDataSetChanged()
    }
}