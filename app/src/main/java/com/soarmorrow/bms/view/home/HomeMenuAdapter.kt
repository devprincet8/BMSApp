package com.soarmorrow.bms.view.home

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import com.soarmorrow.bms.view.property.details.BaseViewHolder
import kotlinx.android.synthetic.main.home_menu_item.view.*
import kotlinx.android.synthetic.main.horizontal_menu_item.view.*

class HomeMenuAdapter(private val context: Context) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    private var listOfMenu = listOf<MenuItem>()
    private var menuClickListener: MenuClickListener? = null
    private var rowIndex = -1

    constructor(context: Context, listener: MenuClickListener) : this(context) {
        this.menuClickListener = listener
    }

    companion object {
        const val TYPE_GRID = 0
        const val TYPE_HORIZONTAL = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_GRID -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.home_menu_item, parent, false)
                HomeViewHolder(view)
            }
            TYPE_HORIZONTAL -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.horizontal_menu_item, parent, false)
                HorizontalMenuHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = listOfMenu[position]
        return item.type

    }

    override fun getItemCount(): Int = listOfMenu.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = listOfMenu[position]
        when (holder) {
            is HomeViewHolder -> holder.bind(element, null)
            is HorizontalMenuHolder -> holder.bind(element, null)
            else -> throw IllegalArgumentException()
        }
    }


    fun setMenuList(listOfMovies: List<MenuItem>) {
        this.listOfMenu = listOfMovies
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(itemView: View) : BaseViewHolder<MenuItem>(itemView) {
        override fun bind(menuModel: MenuItem, listener: CommonListClickListener?) {
            itemView.title.text = menuModel.title
            Glide.with(itemView.context).load(menuModel.image).into(itemView.icon)
            itemView.setOnClickListener {
                menuClickListener?.onMenuSelected(adapterPosition)
            }
        }

    }

    inner class HorizontalMenuHolder(itemView: View) : BaseViewHolder<MenuItem>(itemView) {
        override fun bind(menuModel: MenuItem, listener: CommonListClickListener?) {
            itemView.horizontal_menu_title.text = menuModel.title
            Glide.with(itemView.context).load(menuModel.image).into(itemView.horizontal_menu_icon)
            itemView.setOnClickListener {
                // rowIndex = adapterPosition
                //  notifyDataSetChanged()
                menuClickListener?.onMenuSelected(adapterPosition)
            }
        }
    }

}