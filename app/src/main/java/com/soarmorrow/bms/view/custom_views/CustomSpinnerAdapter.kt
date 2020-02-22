package com.soarmorrow.bms.view.custom_views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.soarmorrow.bms.R
import com.soarmorrow.bms.api.response.city.City
import com.soarmorrow.bms.api.response.country.Country
import com.soarmorrow.bms.api.response.state.State

internal class CustomSpinnerAdapter(val context: Context, var listItemsTxt: List<Any>) :
    BaseAdapter() {


    val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.layout_spinner, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }
        val item = listItemsTxt[position]
        if (item is Country)
        {
            vh.label.text = item.name
        }
        if (item is State)
        {
            vh.label.text = item.name
        }
        if (item is City)
        {
            vh.label.text = item.name
        }



        return view
    }

    override fun getItem(position: Int): Any? {

        return null

    }

    override fun getItemId(position: Int): Long {

        return 0

    }
    fun setItems(list:List<Any>)
    {
        this.listItemsTxt=list
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return listItemsTxt.size
    }

    private class ItemRowHolder(row: View?) {

        val label: TextView

        init {
            this.label = row?.findViewById(R.id.txt) as TextView
        }
    }
}
