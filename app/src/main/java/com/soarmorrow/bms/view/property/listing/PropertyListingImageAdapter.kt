package com.soarmorrow.bms.view.property.listing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import com.soarmorrow.bms.view.property.details.BaseViewHolder
import com.soarmorrow.bms.view.property.details.model.ImagePickerItem
import kotlinx.android.synthetic.main.image_picker_item.view.*

class PropertyListingImageAdapter(private val context: Context) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var adapterDataList = listOf<ImagePickerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        val view = LayoutInflater.from(context)
            .inflate(R.layout.property_listing_image__item, parent, false)
        ImageViewHolder(view)
        return ImageViewHolder(view)

    }

    override fun getItemCount(): Int = adapterDataList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is ImageViewHolder -> holder.bind(element, null)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        val type = adapterDataList[position]
        return type.type

    }

    fun setMenuList(listOfMovies: List<ImagePickerItem>) {
        this.adapterDataList = listOfMovies
        notifyDataSetChanged()
    }

    //----------------ImageViewHolder |
    inner class ImageViewHolder(itemView: View) : BaseViewHolder<ImagePickerItem>(itemView) {

        override fun bind(
            item: ImagePickerItem,
            commonListClickListener: CommonListClickListener?
        ) {
            Glide.with(itemView.context).load(item.path).transform(RoundedCorners(20))
                .into(itemView.icon)
        }
    }

}