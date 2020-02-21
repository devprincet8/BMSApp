package com.soarmorrow.bms.view.common_listing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soarmorrow.bms.R
import com.soarmorrow.bms.view.account.model.ItemAgentCommission
import com.soarmorrow.bms.view.account.model.ItemAgentWiseTotalSales
import com.soarmorrow.bms.view.account.model.ItemTotalSales
import com.soarmorrow.bms.view.agent.listing.model.AgentItem
import com.soarmorrow.bms.view.booking.model.BookingItem
import com.soarmorrow.bms.view.offer.model.OfferItem
import com.soarmorrow.bms.view.property.details.BaseViewHolder
import com.soarmorrow.bms.view.property.details.model.ImagePickerItem
import com.soarmorrow.bms.view.property.listing.PropertyListingImageAdapter
import com.soarmorrow.bms.view.property.listing.model.PropertyItem
import kotlinx.android.synthetic.main.agent_list_item.view.*
import kotlinx.android.synthetic.main.booking_list_item.view.*
import kotlinx.android.synthetic.main.fragment_property_listing_item.view.*
import kotlinx.android.synthetic.main.offer_list_item.view.*
import kotlinx.android.synthetic.main.report_agent_commission_item.view.*
import kotlinx.android.synthetic.main.report_agent_sales_item.view.*
import kotlinx.android.synthetic.main.report_total_sales_item.view.*


class CommonListAdapter(private val context: Context) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    private var type: Int = 0

    companion object {
        const val TYPE_PROPERTY = 0
        const val TYPE_AGENT = 1
        const val TYPE_OFFER = 2
        const val TYPE_BOOKING = 3
        const val TYPE_REPORT_TOTAL = 4
        const val TYPE_REPORT_AGENT_WISE = 5
        const val TYPE_REPORT_AGENT_COMMISSION = 6
    }

    private var listener: CommonListClickListener? = null

    constructor(
        listType: Int,
        context: Context,
        commonClickListener: CommonListClickListener?
    ) : this(
        context
    ) {
        this.listener = commonClickListener
        this.type = listType
    }

    private var listOfMenu = listOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_PROPERTY -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.fragment_property_listing_item, parent, false)
                PropertyListViewHolder(context, view)
            }
            TYPE_AGENT -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.agent_list_item, parent, false)
                AgentListViewHolder(view)
            }
            TYPE_OFFER -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.offer_list_item, parent, false)
                OfferListViewHolder(view)
            }
            TYPE_BOOKING -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.booking_list_item, parent, false)
                BookingListViewHolder(view)
            }

            TYPE_REPORT_TOTAL -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.report_total_sales_item, parent, false)
                TotalSalesViewHolder(view)
            }
            TYPE_REPORT_AGENT_WISE -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.report_agent_sales_item, parent, false)
                AgentWiseSalesViewHolder(view)
            }

            TYPE_REPORT_AGENT_COMMISSION -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.report_agent_commission_item, parent, false)
                AgentCommissionViewHolder(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return type
    }

    override fun getItemCount(): Int = listOfMenu.size
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = listOfMenu[position]
        when (holder) {
            is PropertyListViewHolder -> holder.bind(element, listener!!)
            is AgentListViewHolder -> holder.bind(element, listener!!)
            is OfferListViewHolder -> holder.bind(element, listener!!)
            is BookingListViewHolder -> holder.bind(element, listener!!)
            is TotalSalesViewHolder -> holder.bind(element, listener!!)
            is AgentWiseSalesViewHolder -> holder.bind(element, listener!!)
            is AgentCommissionViewHolder -> holder.bind(element, listener!!)
            else -> throw IllegalArgumentException()
        }
    }

    fun setItemList(listOfMovies: List<Any>) {
        this.listOfMenu = listOfMovies
        notifyDataSetChanged()
    }

    inner class PropertyListViewHolder(var context: Context, itemView: View) :
        BaseViewHolder<Any>(itemView) {
        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as PropertyItem
            itemView.property_title.text = item.title
            itemView.property_address.text = item.address
            itemView.property_distance.text = item.distance
            itemView.property_details.setOnClickListener { listener?.onItemSelected(item) }
            //recyclerview
            setHorizontalImageList(itemView, item.imageList)
        }

        private fun setHorizontalImageList(itemView: View, imageList: List<ImagePickerItem>) {
            itemView.rv_property_images.layoutManager = layoutManager
            val menuAdapter =
                PropertyListingImageAdapter(context)
            itemView.rv_property_images.adapter = menuAdapter
            menuAdapter.setMenuList(imageList)
        }
    }

    inner class AgentListViewHolder(itemView: View) :
        BaseViewHolder<Any>(itemView) {
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as AgentItem
            itemView.agent_title.text = item.title
            itemView.agent_address.text = item.address
            itemView.agent_tel.text = item.tele
            itemView.agent_mob.text = item.mob
            itemView.agent_email.text = item.email
            itemView.agent_contact_person.text = item.contact_person
            itemView.agent_details.setOnClickListener { listener?.onItemSelected(item) }
        }
    }

    inner class OfferListViewHolder(itemView: View) :
        BaseViewHolder<Any>(itemView) {
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as OfferItem
            itemView.offer_title.text = item.title
            itemView.offer_start_date.text = item.from
            itemView.offer_end_date.text = item.to
            itemView.offer_value.text = "${item.offer}%"

            itemView.setOnClickListener { listener?.onItemSelected(item) }
        }
    }

    inner class BookingListViewHolder(itemView: View) :
        BaseViewHolder<Any>(itemView) {
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as BookingItem
            itemView.booking_title.text = item.bookingTitle
            itemView.booking_date.text = item.bookingDate
            itemView.setOnClickListener { listener?.onItemSelected(item) }
        }
    }

    inner class TotalSalesViewHolder(itemView: View) :
        BaseViewHolder<Any>(itemView) {
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as ItemTotalSales
            itemView.total_sales_title.text = item.totalSalesTitle
            itemView.total_sales_date.text = item.totalSalesDate
            itemView.total_sales_address.text = item.totalSalesPropertyAddress
            itemView.total_sales_desc.text = item.totalSalesDesc
            itemView.total_sales_net_amount.text =
                "${context.getString(R.string.Rs)}${item.totalSalesNetAmount}"
            itemView.setOnClickListener { listener?.onItemSelected(item) }
        }
    }

    inner class AgentWiseSalesViewHolder(itemView: View) :
        BaseViewHolder<Any>(itemView) {
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as ItemAgentWiseTotalSales
            itemView.agent_sales_title.text = item.agentSalesTitle
            itemView.agent_sales_date.text = item.agentSalesDate
            itemView.agent_sales_address.text = item.agentSalesPropertyAddress
            itemView.agent_sales_desc.text = item.agentSalesDesc
            itemView.agent_sales_commission.text = item.agentSalesCommission
            itemView.agent_sales_net_amount.text =
                "${context.getString(R.string.Rs)}${item.agentSalesNetAmount}"
            itemView.setOnClickListener { listener?.onItemSelected(item) }
        }
    }

    inner class AgentCommissionViewHolder(itemView: View) :
        BaseViewHolder<Any>(itemView) {
        override fun bind(item: Any, listener: CommonListClickListener?) {
            item as ItemAgentCommission
            itemView.agent_commission_title.text = item.agentCommissionTitle
            itemView.agent_commission_date.text = item.agentCommissionDate
            itemView.agent_commission_commission.text =
                "${item.agentCommissionTitle} Commission: ${item.agentSalesCommission}"
            itemView.agent_commission_amount.text =
                "${context.getString(R.string.Rs)}${item.agentSalesNetAmount}"
            itemView.setOnClickListener { listener?.onItemSelected(item) }
        }
    }
}