package com.soarmorrow.bms.view.property.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.common_listing.CommonListClickListener
import com.soarmorrow.bms.view.property.details.model.ImagePickerItem
import kotlinx.android.synthetic.main.home_menu_item.view.icon
import kotlinx.android.synthetic.main.image_picker_item.view.*

class PropertyImageAdapter(private val context: Context) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    companion object {
        const val TYPE_IMAGE = 0
        const val TYPE_CAMERA = 1
    }

    private var listener: AddPropertyClickListener? = null

    constructor(context: Context, listener: AddPropertyClickListener) : this(context) {
        this.listener = listener
    }

    private var adapterDataList = listOf<ImagePickerItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_IMAGE -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.image_picker_item, parent, false)
                ImageViewHolder(view)
            }
            TYPE_CAMERA -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.image_picker_item_camera, parent, false)
                CameraViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = adapterDataList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is ImageViewHolder -> holder.bind(element,null)
            is CameraViewHolder -> holder.bind(element,null)
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

        override fun bind(item: ImagePickerItem,commonListClickListener: CommonListClickListener?) {
            Glide.with(itemView.context).load(item.path).transform(RoundedCorners(20))
                .into(itemView.icon)
            itemView.remove.setOnClickListener { listener?.onImageRemoved(adapterPosition) }
        }
    }

    //----------------CameraViewHolder |
    inner class CameraViewHolder(itemView: View) : BaseViewHolder<ImagePickerItem>(itemView) {

        override fun bind(item: ImagePickerItem,commonListClickListener: CommonListClickListener?) {
            itemView.setOnClickListener { listener?.onPickerSelected() }
        }
    }
}